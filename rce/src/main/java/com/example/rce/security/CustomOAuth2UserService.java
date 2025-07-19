package com.example.rce.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.rce.model.User;
import com.example.rce.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest req) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oauthUser = delegate.loadUser(req);

        Number githubIdRaw = oauthUser.getAttribute("id");
        Long githubId = githubIdRaw != null ? githubIdRaw.longValue() : null;

        String login = oauthUser.getAttribute("login");
        String avatarUrl = oauthUser.getAttribute("avatar_url");

        String email = fetchPrimaryEmailFromGithub(req.getAccessToken().getTokenValue());

        if (githubId == null || login == null) {
            log.error("GitHub OAuth error: Missing id or login. id={}, login={}", githubId, login);
            throw new OAuth2AuthenticationException("GitHub authentication failed: Missing required user info.");
        }

        repository.findById(githubId).ifPresentOrElse(existingUser -> {
            log.info("User already exists in DB: {}", existingUser.getUsername());
        }, () -> {
            log.info("Registering new user with GitHub ID: {}", githubId);
            User newUser = new User(githubId, login, email, avatarUrl);
            repository.save(newUser);
        });

        Map<String, Object> attributes = new HashMap<>(oauthUser.getAttributes());
        if (email != null) {
            attributes.put("email", email);
        }

        log.info("OAuth2 user authenticated: {}", login);
        return new DefaultOAuth2User(oauthUser.getAuthorities(), attributes, "login");
    }

    private String fetchPrimaryEmailFromGithub(String accessToken) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                    "https://api.github.com/user/emails",
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<>() {
                    });

            List<Map<String, Object>> emails = response.getBody();

            if (emails != null) {
                for (Map<String, Object> emailEntry : emails) {
                    Boolean primary = (Boolean) emailEntry.get("primary");
                    Boolean verified = (Boolean) emailEntry.get("verified");
                    if (Boolean.TRUE.equals(primary) && Boolean.TRUE.equals(verified)) {
                        String email = (String) emailEntry.get("email");
                        log.debug("Primary verified GitHub email: {}", email);
                        return email;
                    }
                }
            }

            log.warn("No verified primary email found in GitHub response.");
        } catch (Exception e) {
            log.error("Error fetching email from GitHub: {}", e.getMessage(), e);
        }

        return null;
    }
}

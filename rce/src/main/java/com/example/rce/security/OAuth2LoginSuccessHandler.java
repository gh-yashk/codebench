package com.example.rce.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${frontend.origin}")
    private String frontendOrigin;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException {
        log.info("OAuth2 login successful for user: {}", authentication.getName());

        HttpSession session = request.getSession(false);
        String redirectUrl = null;

        if (session != null) {
            redirectUrl = (String) session.getAttribute("redirectUrl");
            session.removeAttribute("redirectUrl");
            log.debug("Retrieved redirectUrl from session: {}", redirectUrl);
        } else {
            log.debug("No session found. Using default redirect.");
        }

        // Validate redirect URL
        if (redirectUrl == null || !(redirectUrl = redirectUrl.trim()).startsWith("/")) {
            log.warn("Invalid or missing redirect URL. Falling back to '/'");
            redirectUrl = "/";
        }

        String targetUrl = frontendOrigin + redirectUrl;
        log.info("Redirecting user to: {}", targetUrl);

        response.sendRedirect(targetUrl);
    }
}

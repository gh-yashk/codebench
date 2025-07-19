package com.example.rce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rce.dto.UserInfo;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<UserInfo> getUserInfo(@AuthenticationPrincipal OAuth2User user) {
        if (user == null) {
            return ResponseEntity.ok(new UserInfo(false, null, null, null));
        }
        return ResponseEntity.ok(new UserInfo(
                true,
                user.getAttribute("login"),
                user.getAttribute("email"),
                user.getAttribute("avatar_url")));
    }

}

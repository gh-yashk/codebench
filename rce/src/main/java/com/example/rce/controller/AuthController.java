package com.example.rce.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/login/oauth2")
    public void loginAndRedirect(
            @RequestParam(required = false, defaultValue = "/") String redirect,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("redirectUrl", redirect);
        response.sendRedirect("/oauth2/authorization/github");
    }

}

package com.example.rce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private boolean authenticated;
    private String username;
    private String email;
    private String avatarUrl;

}

package com.blogletsgo.model.user;

public record RegisterDTO(String login, String password, UserRole role) {
    
}

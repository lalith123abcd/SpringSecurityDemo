package com.example.SpringSecurityDemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class RegisterRequestDTO {

    @NotBlank(message = "UserName is Required")
    @Size(min=3,max = 20,message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Email is Required")
    @Size(min=3,max = 20,message = "Email must be greater 10 characters")
    private String email;
    private String password;

    private Set<String> roles;
}

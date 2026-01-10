package com.example.SpringSecurityDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponseDTO {

    private String token;

    @Builder.Default
    private String type="Bearer";
    private String email;
    private String username;
    private Long id;

    private Set<String> roles;

}

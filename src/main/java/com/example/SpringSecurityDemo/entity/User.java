package com.example.SpringSecurityDemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Table(name="users",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    public User (String username,String email,String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3,max = 20)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(max = 20)
    @Column(unique = true)

    private String email;

    @NotBlank
    @Size(min=8)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role",nullable = false)
    @CollectionTable(name="user_roles",joinColumns = @JoinColumn(name = "user_id"))
    @ElementCollection(fetch = FetchType.EAGER)

    private Set<Role> roles;


    public enum Role{
        USER,
        ADMIN

    }

}

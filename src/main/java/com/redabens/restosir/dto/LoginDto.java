package com.redabens.restosir.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginDto {

    private String email;
    private String password;
    private String role;
}

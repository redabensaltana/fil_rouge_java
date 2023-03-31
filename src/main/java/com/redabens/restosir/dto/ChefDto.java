package com.redabens.restosir.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class ChefDto {
    private String username;
    private String email;
    private String password;
    private String address;
    private String numberPhone;
}


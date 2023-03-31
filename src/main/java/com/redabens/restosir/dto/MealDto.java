package com.redabens.restosir.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MealDto {
    private String name;
    private Integer price;
    private Integer category;
}

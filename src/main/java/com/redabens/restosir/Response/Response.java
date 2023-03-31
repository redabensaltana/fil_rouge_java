package com.redabens.restosir.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Response {
    private Map data;
    private String message;
    private Integer status;
}

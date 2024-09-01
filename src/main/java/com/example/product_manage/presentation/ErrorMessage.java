package com.example.product_manage.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private List<String> errors;

}

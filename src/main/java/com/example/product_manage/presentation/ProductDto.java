package com.example.product_manage.presentation;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProductDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer price;
    @NotNull
    private Integer amount;

    public void setId(Long id){
        this.id = id;
    }
}

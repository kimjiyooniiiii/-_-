package com.example.product_manage.presentation;

import lombok.Getter;

@Getter
public class ProductDto {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public void setId(Long id){
        this.id = id;
    }
}

package com.example.product_manage.domain;

import java.util.Objects;

public class Product {
    private Long id;     // Wrapper Class를 사용하면 null값을 가질 수 있음. 컬렉션 기능 사용 가능
    private String name;
    private Integer price;
    private Integer amount;

    public void setId(Long id){
        this.id = id;
    }

    public Boolean sameId(Long id){
        return this.id.equals(id);
    }

    public Boolean containsName(String name){
        return this.name.contains(name);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

}

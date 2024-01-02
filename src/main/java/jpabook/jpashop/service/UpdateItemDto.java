package jpabook.jpashop.service;

import lombok.Getter;

@Getter
public class UpdateItemDto {

    public UpdateItemDto(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }


    private String name;
    private int price;
    private int stockQuantity;
}

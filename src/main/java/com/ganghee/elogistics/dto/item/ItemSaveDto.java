package com.ganghee.elogistics.dto.item;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemSaveDto {

    private String name;

    private int price;

    private int quantity;

    private String category;

    @Builder
    public ItemSaveDto(String name, int price, int quantity, String category){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}

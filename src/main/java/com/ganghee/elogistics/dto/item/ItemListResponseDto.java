package com.ganghee.elogistics.dto.item;

import com.ganghee.elogistics.domain.item.Item;
import lombok.Getter;

@Getter
public class ItemListResponseDto {

    private Long id;

    private String name;

    private int price;

    private int quantity;

    private String provider;

    private String categoryName;

    public ItemListResponseDto(Item entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
        this.provider = entity.getProvider().getName();
        this.categoryName = entity.getCategory().getName();
    }
}

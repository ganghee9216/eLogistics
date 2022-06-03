package com.ganghee.elogistics.dto.item;

import com.ganghee.elogistics.domain.categoryItem.CategoryItem;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemSaveDto {

    private String name;

    private int price;

    private int quantity;

    private List<CategoryItem> categories;

    @Builder
    public ItemSaveDto(String name, int price, int quantity, List<CategoryItem> categories){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categories = categories;
    }
}

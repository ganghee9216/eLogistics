package com.ganghee.elogistics.dto.item;

import com.ganghee.elogistics.domain.categoryItem.CategoryItem;
import com.ganghee.elogistics.domain.item.Item;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemResponseDto {

    private Long id;

    private String name;

    private int price;

    private int quantity;

    private List<CategoryItem> categories;

    public ItemResponseDto(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
        this.categories = item.getCategories();
    }
}

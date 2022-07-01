package com.ganghee.elogistics.dto.item;

import com.ganghee.elogistics.domain.categoryItem.CategoryItem;
import com.ganghee.elogistics.domain.item.Item;
import com.ganghee.elogistics.domain.member.Member;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemListResponseDto {

    private Long id;

    private String name;

    private int price;

    private int quantity;

    private Member producer;

    private List<CategoryItem> categories;

    public ItemListResponseDto(Item entity){
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
        this.producer = entity.getProvider();
        this.categories = entity.getCategories();
    }
}

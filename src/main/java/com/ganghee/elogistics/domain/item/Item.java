package com.ganghee.elogistics.domain.item;

import com.ganghee.elogistics.domain.categoryItem.CategoryItem;
import com.ganghee.elogistics.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member producer;

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categories = new ArrayList<>();

    @Builder
    public Item(String name, int price, int quantity, Member producer){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
    }

    public void updateItem(String name, int price, int Quantity) {
        this.name = name;
        this.price = price;
        this.quantity = Quantity;
    }
}

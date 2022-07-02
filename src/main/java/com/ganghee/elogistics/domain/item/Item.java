package com.ganghee.elogistics.domain.item;

import com.ganghee.elogistics.domain.category.Category;
import com.ganghee.elogistics.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    private int quantity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    @Builder
    public Item(String name, int price, int quantity, Member provider, Category category){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
        this.category = category;
    }

    public void updateItem(String name, int price, int Quantity) {
        this.name = name;
        this.price = price;
        this.quantity = Quantity;
    }

    public void addQuantity(int count){ quantity += count; };

    public void removeQuantity(int count){
        int restQuantity = this.quantity - count;
        this.quantity = restQuantity;
    }
}

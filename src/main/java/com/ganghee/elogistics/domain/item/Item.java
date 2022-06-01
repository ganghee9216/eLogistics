package com.ganghee.elogistics.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long item_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    private String category;
}

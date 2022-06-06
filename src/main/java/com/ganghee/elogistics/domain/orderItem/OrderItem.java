package com.ganghee.elogistics.domain.orderItem;

import com.ganghee.elogistics.domain.BaseTimeEntity;
import com.ganghee.elogistics.domain.item.Item;
import com.ganghee.elogistics.domain.order.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class OrderItem extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int count;

    @Builder
    public OrderItem(Order order, Item item, int count){
        this.order = order;
        this.item = item;
        this.count = count;
    }

    public void cancel() { item.addQuantity(count); }
}

package com.ganghee.elogistics.domain.delivery;

import com.ganghee.elogistics.domain.BaseTimeEntity;
import com.ganghee.elogistics.domain.address.Address;
import com.ganghee.elogistics.domain.order.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Delivery extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    Order order;

    @Embedded
    Address address;

    @Enumerated(EnumType.STRING)
    DeliveryStatus status;

    @Builder
    public Delivery(Order order, Address address){
        if(order != null){
            this.order = order;
            order.changeDelivery(this);
        }
        this.address = address;
        this.status = DeliveryStatus.BEFORE_DELIVER;
    }
}

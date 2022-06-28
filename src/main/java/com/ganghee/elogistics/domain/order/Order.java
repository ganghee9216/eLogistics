package com.ganghee.elogistics.domain.order;

import com.ganghee.elogistics.domain.BaseTimeEntity;
import com.ganghee.elogistics.domain.delivery.Delivery;
import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.orderItem.OrderItem;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
//order는 예약자이기 때문에 orders로 이름 변경
@Table(name="Orders")
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    //즉시 로딩은 예측이 어렵고, 어떤 SQL이 실행될지 추적하기 어려워서 지연로딩으로 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Builder
    public Order(Member member, List<OrderItem> orderItems){
        this.member = member;
        this.orderItems = orderItems;
        changeStatus(OrderStatus.BEFORE_GET);
    }

    public void changeDelivery(Delivery delivery){
        this.delivery = delivery;
    }
    public void changeStatus(OrderStatus status){ this.status = status; }

    public void cancel(){
        for(OrderItem orderItem: orderItems){
            orderItem.cancel();
        }
    }

}

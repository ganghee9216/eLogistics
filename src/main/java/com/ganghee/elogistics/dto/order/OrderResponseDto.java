package com.ganghee.elogistics.dto.order;

import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.order.Order;
import com.ganghee.elogistics.domain.order.OrderStatus;
import com.ganghee.elogistics.domain.orderItem.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class OrderResponseDto {

    private Long orderId;

    private Member member;

    private OrderStatus status;

    private List<OrderItem> items;

    private LocalDateTime modifiedDate;

    public OrderResponseDto(Order order){
        this.orderId = order.getId();
        this.member = order.getMember();
        this.status = order.getStatus();
        this.items = order.getOrderItems();
        this.modifiedDate = order.getModifiedDate();
    }
}

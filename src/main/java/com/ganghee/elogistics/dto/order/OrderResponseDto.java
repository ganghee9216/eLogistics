package com.ganghee.elogistics.dto.order;

import com.ganghee.elogistics.domain.order.Order;
import com.ganghee.elogistics.domain.order.OrderStatus;
import com.ganghee.elogistics.domain.orderItem.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class OrderResponseDto {

    private Long orderId;

    private List<String> itemName = new ArrayList<>();

    private List<Integer> itemCount = new ArrayList<>();

    private String memberName;

    private OrderStatus status;

    private String memberEmail;

    private LocalDateTime modifiedDate;

    public OrderResponseDto(Order order){
        this.orderId = order.getId();
        this.memberName = order.getMember().getName();
        this.status = order.getStatus();
        for(OrderItem orderItem : order.getOrderItems()){
            itemName.add(orderItem.getItem().getName());
            itemCount.add(orderItem.getCount());
        }
        this.memberEmail = order.getMember().getEmail();
        this.modifiedDate = order.getModifiedDate();
    }
}

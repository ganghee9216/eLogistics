package com.ganghee.elogistics.dto.delivery;

import com.ganghee.elogistics.domain.delivery.Delivery;
import com.ganghee.elogistics.domain.delivery.DeliveryStatus;
import com.ganghee.elogistics.domain.orderItem.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class DeliveryResponseDto {

    private Long deliveryId;

    private List<String> itemName = new ArrayList<>();

    private List<Integer> itemCount = new ArrayList<>();

    private DeliveryStatus status;

    private String memberEmail;

    private LocalDateTime sendDate;

    public DeliveryResponseDto(Delivery delivery){
        this.deliveryId = delivery.getId();
        this.status = delivery.getStatus();
        for(OrderItem orderItem : delivery.getOrder().getOrderItems()){
            itemName.add(orderItem.getItem().getName());
            itemCount.add(orderItem.getCount());
        }
        this.memberEmail = delivery.getOrder().getMember().getEmail();
        this.sendDate = delivery.getModifiedDate();
    }
}

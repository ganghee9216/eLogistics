package com.ganghee.elogistics.service.order;

import com.ganghee.elogistics.dto.order.OrderResponseDto;
import com.ganghee.elogistics.dto.order.OrderSaveDto;

import java.util.List;

public interface OrderService {
    void createOrder(List<OrderSaveDto> saveDto);

    List<OrderResponseDto> orderList();

    void cancelOrder(Long orderId);
}

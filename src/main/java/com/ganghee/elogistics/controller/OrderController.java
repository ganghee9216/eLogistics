package com.ganghee.elogistics.controller;

import com.ganghee.elogistics.dto.order.OrderResponseDto;
import com.ganghee.elogistics.dto.order.OrderSaveDto;
import com.ganghee.elogistics.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody List<OrderSaveDto> saveDto){
        orderService.createOrder(saveDto);
    }
    @PutMapping("/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody List<OrderSaveDto> saveDto){
        orderService.updateOrder(id, saveDto);
    }
    @DeleteMapping("/{id}")
    public void cancelOrder(@PathVariable Long id){
        orderService.cancelOrder(id);
    }
    @GetMapping
    public List<OrderResponseDto> orderList(){
        return orderService.orderList();
    }
}

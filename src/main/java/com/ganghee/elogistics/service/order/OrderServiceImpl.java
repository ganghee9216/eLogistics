package com.ganghee.elogistics.service.order;

import com.ganghee.elogistics.domain.delivery.Delivery;
import com.ganghee.elogistics.domain.delivery.DeliveryRepository;
import com.ganghee.elogistics.domain.item.Item;
import com.ganghee.elogistics.domain.item.ItemRepository;
import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.member.MemberRepository;
import com.ganghee.elogistics.domain.order.Order;
import com.ganghee.elogistics.domain.order.OrderQueryRepository;
import com.ganghee.elogistics.domain.order.OrderRepository;
import com.ganghee.elogistics.domain.orderItem.OrderItem;
import com.ganghee.elogistics.dto.order.OrderResponseDto;
import com.ganghee.elogistics.dto.order.OrderSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderQueryRepository orderQueryRepository;

    private final MemberRepository memberRepository;

    private final ItemRepository itemRepository;

    private final DeliveryRepository deliveryRepository;

    @Override
    @Transactional
    public void createOrder(List<OrderSaveDto> saveDto){

        Member member = memberRepository.findById(saveDto.get(0).getMemberId())
                .orElseThrow(() -> new IllegalArgumentException());

        for(OrderSaveDto sDto : saveDto){

            Order order = Order.builder().member(member).orderItems(
                    makeOrderItems(member, sDto)).build();

            deliveryRepository.save(Delivery.builder()
                    .order(order)
                    .address(member.getAddress())
                    .build());

            orderRepository.save(order);
        }
    }

    @Override
    @Transactional
    public void updateOrder(Long orderId, List<OrderSaveDto> saveDto){

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException());

        Member member = memberRepository.findById(saveDto.get(0).getMemberId())
                .orElseThrow(() -> new IllegalArgumentException());

        for(OrderSaveDto sDto : saveDto){

            order = Order.builder().member(member).orderItems(
                    makeOrderItems(member, sDto)).build();
        }
    }

    @Override
    @Transactional
    public List<OrderResponseDto> orderList(Long memberId){
        return orderQueryRepository.findAllOrdersDesc(memberId).stream()
                .map(OrderResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void cancelOrder(Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException());
        order.cancel();
        orderRepository.delete(order);
    }


    @Transactional
    public List<OrderItem> makeOrderItems(Member member, OrderSaveDto sDto){

        List<OrderItem> orderItems = new ArrayList<>();

        HashMap<Long, Integer> items = sDto.getItems();

        if(items != null){
            for(Long itemId : items.keySet()){
                Item item = itemRepository.findById(itemId)
                        .orElseThrow(() -> new IllegalArgumentException());
                int count = items.get(itemId);
                item.removeQuantity(count);

                orderItems.add(OrderItem.builder()
                        .order(Order.builder().member(member).build())
                        .item(item).count(count).build());
            }
        }
        return orderItems;
    }
}

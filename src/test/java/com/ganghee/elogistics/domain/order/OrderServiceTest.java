package com.ganghee.elogistics.domain.order;

import com.ganghee.elogistics.domain.address.Address;
import com.ganghee.elogistics.domain.delivery.Delivery;
import com.ganghee.elogistics.domain.delivery.DeliveryQueryRepository;
import com.ganghee.elogistics.domain.delivery.DeliveryRepository;
import com.ganghee.elogistics.domain.item.Item;
import com.ganghee.elogistics.domain.item.ItemRepository;
import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.member.MemberRepository;
import com.ganghee.elogistics.domain.member.Role;
import com.ganghee.elogistics.dto.delivery.DeliveryResponseDto;
import com.ganghee.elogistics.dto.order.OrderResponseDto;
import com.ganghee.elogistics.dto.order.OrderSaveDto;
import com.ganghee.elogistics.service.delivery.DeliveryService;
import com.ganghee.elogistics.service.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired(required = false)
    OrderQueryRepository orderQueryRepository;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    DeliveryService deliveryService;

    @Autowired(required = false)
    DeliveryQueryRepository deliveryQueryRepository;

    @Test
    @Transactional
    public void createOrder(){

        Member member = Member.builder().name("kim").email("example@naver.com")
                .password("123").address(new Address("서울", "강남", "56번지"))
                .role(Role.PROVIDER).build();

        member = memberRepository.findById(memberRepository.save(member).getId())
                .orElseThrow(() -> new IllegalArgumentException());

        String[] itemNames = {"갤럭시", "아이폰"};

        Item item1 = Item.builder().name(itemNames[0]).price(1000000)
                .quantity(50).build();

        itemRepository.save(item1);

        Item item2 = Item.builder().name(itemNames[1]).price(1200000)
                .quantity(30).build();

        itemRepository.save(item2);

        List<Item> itemList = itemRepository.findAll();

        HashMap<Long, Integer> items = new HashMap<>();

        for(Item reqItem : itemList){
            Long id = reqItem.getId();
            int quantity = reqItem.getQuantity();

            items.put(id, quantity);
        }

        OrderSaveDto saveDto = OrderSaveDto.builder().memberId(member.getId())
                .items(items).build();

        List<OrderSaveDto> orderDtoList = new ArrayList<>();

        orderDtoList.add(saveDto);

        orderService.createOrder(orderDtoList);

        //querydsl 테스트
        List<Order> order = orderQueryRepository.findAllOrdersDesc(member.getId());

        assertThat(order.get(0).getOrderItems().get(0).getItem().getName()).isEqualTo(itemNames[0]);
        //주문리스트 조회 리팩토링 테스트
        List<OrderResponseDto> orderList = orderService.orderList(member.getId());

        assertThat(orderList.get(0).getItemName().get(0)).isEqualTo(itemNames[0]);

        //delivery 생성 테스트
        List<Delivery> delivery = deliveryRepository.findAll();

        //배송리스트 조회 테스트
        List<DeliveryResponseDto> deliveryList = deliveryService.deliveryList(member.getId());

        assertThat(delivery.get(0).getOrder().getOrderItems().get(0).getItem().getName()).isEqualTo(itemNames[0]);
    }
}

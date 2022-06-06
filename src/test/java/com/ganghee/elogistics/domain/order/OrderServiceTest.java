package com.ganghee.elogistics.domain.order;

import com.ganghee.elogistics.domain.address.Address;
import com.ganghee.elogistics.domain.item.Item;
import com.ganghee.elogistics.domain.item.ItemRepository;
import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.member.MemberRepository;
import com.ganghee.elogistics.domain.member.Role;
import com.ganghee.elogistics.dto.order.OrderSaveDto;
import com.ganghee.elogistics.service.order.OrderServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    OrderServiceImpl orderService;

    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
        itemRepository.deleteAll();
        orderRepository.deleteAll();
    }

    @Test
    @Transactional
    public void registerItem(){

        Member member = Member.builder().name("kim").email("example@naver.com")
                .password("123").address(new Address("서울", "강남"))
                .role(Role.PRODUCER).build();

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

        List<Order> order = orderRepository.findAll();

        List<String> itemNameList = itemRepository.findItemName();

        assertThat(itemNameList.get(0)).isEqualTo(itemNames[0]);
    }
}

package com.ganghee.elogistics.domain.item;

import com.ganghee.elogistics.domain.address.Address;
import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.member.MemberRepository;
import com.ganghee.elogistics.domain.member.Role;
import com.ganghee.elogistics.dto.item.ItemResponseDto;
import com.ganghee.elogistics.dto.item.ItemSaveDto;
import com.ganghee.elogistics.service.item.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void createProd(){
        Member member = Member.builder().name("kim")
                .email("example@naver.com").password("password")
                .address(new Address()).role(Role.PRODUCER).build();

        memberRepository.save(member);
    }

    @Test
    public void registerItemTest(){
        String name = "갤럭시";
        int price = 1000000;

        ItemSaveDto saveDto = ItemSaveDto.builder().name(name)
                .price(price).quantity(50).categories(new ArrayList<>())
                .build();

        ItemResponseDto responseDto = itemService.registerItem(saveDto, 1L);

        assertThat(responseDto.getName()).isEqualTo(name);
    }
}

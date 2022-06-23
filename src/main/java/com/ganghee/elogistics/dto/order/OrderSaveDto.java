package com.ganghee.elogistics.dto.order;

import com.ganghee.elogistics.domain.address.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Getter
@NoArgsConstructor
public class OrderSaveDto {

    private Long memberId;

    //아이템의 아이디, 갯수
    private HashMap<Long, Integer> items;

    private Address address;

    @Builder
    public OrderSaveDto(Long memberId, HashMap<Long, Integer> items, Address address){
        this.memberId = memberId;
        this.items = items;
        this.address = address;
    }
}

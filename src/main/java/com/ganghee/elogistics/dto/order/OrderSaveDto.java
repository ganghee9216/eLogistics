package com.ganghee.elogistics.dto.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Getter
@NoArgsConstructor
public class OrderSaveDto {

    private Long memberId;

    private HashMap<Long, Integer> items;

    @Builder
    public OrderSaveDto(Long memberId, HashMap<Long, Integer> items){
        this.memberId = memberId;
        this.items = items;
    }
}

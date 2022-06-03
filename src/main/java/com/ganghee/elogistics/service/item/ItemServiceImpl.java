package com.ganghee.elogistics.service.item;

import com.ganghee.elogistics.domain.categoryItem.CategoryItem;
import com.ganghee.elogistics.domain.item.Item;
import com.ganghee.elogistics.domain.item.ItemRepository;
import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.member.MemberRepository;
import com.ganghee.elogistics.domain.member.Role;
import com.ganghee.elogistics.dto.item.ItemResponseDto;
import com.ganghee.elogistics.dto.item.ItemSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final MemberRepository memberRepository;

    private final ItemRepository itemRepository;

    @Override
    public ItemResponseDto registerItem(ItemSaveDto itemDto, Long memberId){

        Member producer = memberRepository.findById(memberId)
                .orElseThrow(()->new IllegalArgumentException());

        if(!producer.getRole().equals(Role.PRODUCER)){
            throw new IllegalArgumentException("생산자가 아니라 등록할 수 없습니다.");
        }

        Item item = Item.builder().name(itemDto.getName())
                .price(itemDto.getPrice())
                .quantity(itemDto.getQuantity())
                .producer(producer)
                .build();

        for(CategoryItem category : itemDto.getCategories()){
            item.getCategories().add(category);
        }

        Long savedId = itemRepository.save(item).getId();

        Item savedItem = itemRepository.findById(savedId).orElseThrow(
                () -> new IllegalArgumentException());

        ItemResponseDto responseDto = new ItemResponseDto(savedItem);

        return responseDto;
    }
}

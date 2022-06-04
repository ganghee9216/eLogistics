package com.ganghee.elogistics.service.item;

import com.ganghee.elogistics.domain.categoryItem.CategoryItem;
import com.ganghee.elogistics.domain.item.Item;
import com.ganghee.elogistics.domain.item.ItemRepository;
import com.ganghee.elogistics.domain.member.Member;
import com.ganghee.elogistics.domain.member.MemberRepository;
import com.ganghee.elogistics.domain.member.Role;
import com.ganghee.elogistics.dto.item.ItemListResponseDto;
import com.ganghee.elogistics.dto.item.ItemResponseDto;
import com.ganghee.elogistics.dto.item.ItemSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final MemberRepository memberRepository;

    private final ItemRepository itemRepository;

    @Override
    @Transactional
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

        return new ItemResponseDto(savedItem);
    }
    @Override
    @Transactional
    public ItemResponseDto findItem(Long itemId){

        Item item = itemRepository.findById(itemId)
                .orElseThrow(()-> new IllegalArgumentException("해당 아이템이 없습니다. id="+itemId));

        return new ItemResponseDto(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemListResponseDto> itemList(){
        return itemRepository.findAllDesc().stream()
                .map(ItemListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateItem(Long itemId, Long memberId, ItemSaveDto saveDto){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id="+itemId));

        if (!item.getProducer().getId().equals(memberId)) {
            throw new IllegalArgumentException("생산자가 아니라 수정할 수 없습니다.");
        }

        item.updateItem(item.getName(), item.getPrice(), item.getQuantity());
    }

    @Override
    @Transactional
    public void deleteItem(Long itemId, Long memberId){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id="+itemId));

        if (!item.getProducer().getId().equals(memberId)) {
            throw new IllegalArgumentException("생산자가 아니라 삭제할 수 없습니다.");
        }

        itemRepository.delete(item);
    }
}

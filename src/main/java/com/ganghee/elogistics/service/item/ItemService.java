package com.ganghee.elogistics.service.item;

import com.ganghee.elogistics.dto.item.ItemListResponseDto;
import com.ganghee.elogistics.dto.item.ItemResponseDto;
import com.ganghee.elogistics.dto.item.ItemSaveDto;

import java.util.List;

public interface ItemService {

    ItemResponseDto registerItem(ItemSaveDto itemDto, Long memberId);

    ItemResponseDto findItem(Long itemId);

    //아이템을 조회하여 카테고리까지 확인
    List<ItemListResponseDto> itemList();

    void updateItem(Long itemId, Long memberId, ItemSaveDto saveDto);

    void deleteItem(Long itemId, Long memberId);
}

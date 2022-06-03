package com.ganghee.elogistics.service.item;

import com.ganghee.elogistics.dto.item.ItemResponseDto;
import com.ganghee.elogistics.dto.item.ItemSaveDto;

public interface ItemService {

    ItemResponseDto registerItem(ItemSaveDto itemDto, Long memberId);

//    void findItem();
//
//    void itemList();
//
//    void updateItem();
//
//    void deleteItem();
}

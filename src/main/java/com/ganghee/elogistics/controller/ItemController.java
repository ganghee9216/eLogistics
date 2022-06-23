package com.ganghee.elogistics.controller;

import com.ganghee.elogistics.dto.item.ItemListResponseDto;
import com.ganghee.elogistics.dto.item.ItemResponseDto;
import com.ganghee.elogistics.dto.item.ItemSaveDto;
import com.ganghee.elogistics.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/register")
    public ItemResponseDto registerItem(@RequestBody ItemSaveDto saveDto, HttpSession session){
        Long memberId = Long.parseLong(session.getId());
        return itemService.registerItem(saveDto, memberId);
    }
    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id, HttpSession session, @RequestBody ItemSaveDto saveDto){
        Long memberId = Long.parseLong(session.getId());
        itemService.updateItem(id, memberId, saveDto);
    }
    @DeleteMapping("/{id}")
    public void cancelOrder(@PathVariable Long id, HttpSession session){
        Long memberId = Long.parseLong(session.getId());
        itemService.deleteItem(id, memberId);
    }
    @GetMapping
    public List<ItemListResponseDto> orderList(){
        return itemService.itemList();
    }
}

package com.ganghee.elogistics.controller;

import com.ganghee.elogistics.config.auth.LoginMember;
import com.ganghee.elogistics.config.auth.dto.SessionMember;
import com.ganghee.elogistics.dto.item.ItemResponseDto;
import com.ganghee.elogistics.dto.item.ItemSaveDto;
import com.ganghee.elogistics.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/save")
    public ItemResponseDto registerItem(@RequestBody ItemSaveDto saveDto, @LoginMember SessionMember member){
        return itemService.registerItem(saveDto, member.getId());
    }
    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id, @LoginMember SessionMember member, @RequestBody ItemSaveDto saveDto){
        itemService.updateItem(id, member.getId(), saveDto);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id, @LoginMember SessionMember member){
        itemService.deleteItem(id, member.getId());
    }

}

package com.ganghee.elogistics.controller;

import com.ganghee.elogistics.config.auth.LoginMember;
import com.ganghee.elogistics.config.auth.dto.SessionMember;
import com.ganghee.elogistics.service.delivery.DeliveryService;
import com.ganghee.elogistics.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final DeliveryService deliveryService;

    private final ItemService itemService;

    @GetMapping("/")
    public String index(Model model, @LoginMember SessionMember member){
        if(member != null){
            model.addAttribute("delivery", deliveryService.deliveryList(member.getId()));
            model.addAttribute("memberName", member.getName());
        }
        return "index";
    }

    @GetMapping("/item/save")
    public String itemSave(){ return "item/item-register"; }

    @GetMapping("/item/list")
    public String itemList(Model model, @LoginMember SessionMember member){
        model.addAttribute("item", itemService.itemList(member.getId()));
        return "item/item-list";
    }

}

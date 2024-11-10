package org.factoriaf5.computers_shop.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.factoriaf5.computers_shop.models.Shop;
import org.factoriaf5.computers_shop.services.ShopService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ShopController {
    
    private ShopService shopService;

    public ShopController (ShopService shopService) {
        this.shopService = shopService;
    }
    
    @GetMapping(path = "/shops")
    public List<Shop> getShops() {
        return shopService.getAll();
    }
    
}

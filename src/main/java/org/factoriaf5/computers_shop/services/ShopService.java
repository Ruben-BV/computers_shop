package org.factoriaf5.computers_shop.services;

import java.util.List;

import org.factoriaf5.computers_shop.models.Shop;
import org.factoriaf5.computers_shop.repositories.ShopRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    
    ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }
    public List<Shop> getAll(){
        return shopRepository.findAll();
    }


    
}

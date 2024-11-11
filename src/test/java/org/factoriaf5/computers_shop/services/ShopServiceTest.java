package org.factoriaf5.computers_shop.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.computers_shop.models.Shop;
import org.factoriaf5.computers_shop.repositories.ShopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ShopServiceTest {
    
    @Mock
    private ShopRepository shopRepository;
    @InjectMocks
    ShopService shopService;
    @Mock
    private Shop mockShop1;
    @Mock
    private Shop mockShop2;
    
    
    @BeforeEach
    void setUp() {
    
        this.mockShop1 = new Shop(1L, "ShopA", "OwnerA", 123L);
        this.mockShop2 = new Shop(2L, "ShopB", "OwnerB", 234L);
    }
    
    @Test
    void testGetAll() {
        
        List<Shop> mockShops = new ArrayList<>();
        
        mockShops.add(mockShop1);
        mockShops.add(mockShop2);
        
        when(shopRepository.findAll()).thenReturn(mockShops);
        
        List<Shop> result = shopService.getAll();
        assertTrue(result.equals(mockShops));
    }
    
}

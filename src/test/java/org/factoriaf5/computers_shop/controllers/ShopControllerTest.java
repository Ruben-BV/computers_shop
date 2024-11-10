package org.factoriaf5.computers_shop.controllers;

import org.factoriaf5.computers_shop.models.Shop;
import org.factoriaf5.computers_shop.services.ShopService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ShopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShopService shopService;

    @Test
    void testGetShops() throws Exception {

        Shop shop1 = new Shop(1L, "Shop1", "Owner1", 123456789L);
        Shop shop2 = new Shop(2L, "Shop2", "Owner2", 987654321L);
        
        List<Shop> mockShops = Arrays.asList(shop1, shop2);
        Mockito.when(shopService.getAll()).thenReturn(mockShops);

        mockMvc.perform(get("/shops"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Shop1"))
                .andExpect(jsonPath("$[0].owner").value("Owner1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Shop2"))
                .andExpect(jsonPath("$[1].owner").value("Owner2"));
    }
}




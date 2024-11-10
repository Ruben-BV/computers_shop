package org.factoriaf5.computers_shop.controllers;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.factoriaf5.computers_shop.models.Computer;
import org.factoriaf5.computers_shop.models.Shop;
import org.factoriaf5.computers_shop.services.ComputerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ComputerControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ComputerService computerService;

    private Computer mockComputer;

    @Test
    void testAddComputer() throws Exception {
        Computer computerToAdd = new Computer(1L, "BrandA", 8, "ProcessorA", "OS1", 1000, new Shop(1L, "ShopA", "OwnerA", 123L));

        when(computerService.addComputer(any(Computer.class))).thenReturn(computerToAdd);

        mockMvc.perform(MockMvcRequestBuilders.post("/computers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"brand\":\"BrandA\",\"memory\":8,\"processor\":\"ProcessorA\",\"operatingSystem\":\"OS1\",\"price\":1000,\"shop\":{\"id\":1,\"name\":\"ShopA\",\"owner\":\"OwnerA\",\"taxId\":123}}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value("BrandA"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.memory").value(8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.processor").value("ProcessorA"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operatingSystem").value("OS1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(1000));

        verify(computerService, times(1)).addComputer(any(Computer.class));
    }

    @Test
    void testDeleteComputerByBrand() throws Exception {
        String brandToDelete = "mockBrand";
        
        doNothing().when(computerService).deleteComputerByBrand(brandToDelete);

        mockMvc.perform(MockMvcRequestBuilders.delete("/computers/{brand}", brandToDelete))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        
        verify(computerService, times(1)).deleteComputerByBrand(brandToDelete);
    }

    @Test
    void testFindComputerByBrand() throws Exception {
        
        String brandToFind = "mockBrand";
        Computer mockComputer = new Computer(1L, "mockBrand", 8, "mockProcessor", "mockOperatingSystem", 10, new Shop(1L, "mockShop", "mockOwner", 123L));
        List<Computer> mockComputers = Arrays.asList(mockComputer);

        when(computerService.findComputerByBrand(brandToFind)).thenReturn(mockComputers);

        mockMvc.perform(MockMvcRequestBuilders.get("/computers/{brand}", brandToFind))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].brand").value("mockBrand"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].memory").value(8))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].processor").value("mockProcessor"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].operatingSystem").value("mockOperatingSystem"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(10));

        verify(computerService, times(1)).findComputerByBrand(brandToFind);
    }

    @Test
    void testGetComputers() throws Exception{
        
    }

}

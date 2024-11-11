package org.factoriaf5.computers_shop.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.computers_shop.models.Computer;
import org.factoriaf5.computers_shop.models.Shop;
import org.factoriaf5.computers_shop.repositories.ComputerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ComputerServiceTest {


    @Mock
    private ComputerRepository computerRepository;
    @InjectMocks
    ComputerService computerService;
    @Mock
    private Computer mockComputer1;
    @Mock
    private Computer mockComputer2;
    
    
    @BeforeEach
    void setUp() {
        
        this.mockComputer1 = new Computer(1L, "BrandA", 8, "ProcessorA", "OS1", 1000, new Shop(1L, "ShopA", "OwnerA", 123L));
        this.mockComputer2 = new Computer(2L, "BrandB", 16, "ProcessorB", "OS2", 1250, new Shop(1L, "ShopA", "OwnerA", 123L));

    }
    
    @Test
    void testAddComputer() {
        
    }

    @Test
    void testDeleteComputerByBrand() {
        
    }

    @Test
    void testFindComputerByBrand() {
        
    }

    @Test
    void testGetAll() {
        List<Computer> mockComputers = new ArrayList<>();
        
        mockComputers.add(mockComputer1);
        mockComputers.add(mockComputer2);
        
        when(computerRepository.findAll()).thenReturn(mockComputers);
        
        List<Computer> result = computerService.getAll();
        assertTrue(result.equals(mockComputers));
    }
    
}

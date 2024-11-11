package org.factoriaf5.computers_shop.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    
    private Computer testComputer;

    @BeforeEach
    public void init() {
        this.testComputer = new Computer(1L, "BrandA", 8, "ProcessorA", "OS1", 1000, new Shop(1L, "ShopA", "OwnerA", 123L));

    }

    @Test
    void testGetBrand() {
        
        String result=testComputer.getBrand();
        assertEquals("BrandA", result);
    }

    @Test
    void testGetId() {
        Long result=testComputer.getId();
        assertEquals(1L, result);
    }

    @Test
    void testGetMemory() {
        double result=testComputer.getMemory();
        assertEquals(8, result);
    }

    @Test
    void testGetOperatingSystem() {
        String result=testComputer.getOperatingSystem();
        assertEquals("OS1", result);
    }

    @Test
    void testGetPrice() {
        double result=testComputer.getPrice();
        assertEquals(1000, result);
    }

    @Test
    void testGetProcessor() {
        String result=testComputer.getProcessor();
        assertEquals("ProcessorA", result);
    }

    @Test
    void testGetShop() {
        
    }

    @Test
    void testSetBrand() {
        
        testComputer.setBrand("brandB");
        String result=testComputer.getBrand();

        assertEquals("brandB", result);
    }

    @Test
    void testSetId() {
        testComputer.setId(2L);
        Long result=testComputer.getId();

        assertEquals(2, result);
    }

    @Test
    void testSetMemory() {
        testComputer.setMemory(64);
        double result=testComputer.getMemory();

        assertEquals(64, result);
    }

    @Test
    void testSetOperatingSystem() {
        testComputer.setOperatingSystem("OSTest");
        String result=testComputer.getOperatingSystem();

        assertEquals("OSTest", result);
    }

    @Test
    void testSetPrice() {
        testComputer.setPrice(1250);
        double result=testComputer.getPrice();

        assertEquals(1250, result);
    }

    @Test
    void testSetProcessor() {
        testComputer.setProcessor("Acme");
        String result=testComputer.getProcessor();

        assertEquals("Acme", result);
    }

    @Test
    void testSetShop() {
        
    }
    
}

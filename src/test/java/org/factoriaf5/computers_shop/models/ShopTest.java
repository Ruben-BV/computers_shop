package org.factoriaf5.computers_shop.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {
    private Shop testShop;

    @BeforeEach
    public void init() {
        this.testShop = new Shop(1L, "ShopA", "OwnerA", 123L);
    }

    @Test
    void testGetComputers() {
    }

    @Test
    void testGetId() {
        Long result=testShop.getId();
        assertEquals(1L, result);
    }

    @Test
    void testGetName() {
        String result=testShop.getName();
        assertEquals("ShopA", result);
    }

    @Test
    void testGetOwner() {
        String result=testShop.getOwner();
        assertEquals("OwnerA", result);
    }

    @Test
    void testGetUtr() {
        Long result=testShop.getUtr();
        assertEquals(123L, result);
    }

    @Test
    void testSetComputers() {
        
    }

    @Test
    void testSetId() {
        testShop.setId(10L);
        Long result=testShop.getId();

        assertEquals(10L, result);
    }

    @Test
    void testSetName() {
        testShop.setName("Testshop");
        String result=testShop.getName();

        assertEquals("Testshop", result);
    }

    @Test
    void testSetOwner() {
        testShop.setOwner("TestOwner");
        String result=testShop.getOwner();
        assertEquals("TestOwner", result);
    }

    @Test
    void testSetUtr() {
        testShop.setUtr(102L);
        Long result=testShop.getUtr();
        assertEquals(102L, result);
    }


}

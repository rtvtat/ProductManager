package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone(1, "samsung a50", 50000, "samsung");
    private Smartphone smartphone2 = new Smartphone(1, "samsung a50", 50000, "samsung");

    @Test
    void testId() {
        assertEquals(1, smartphone.getId());
    }

    @Test
    void testName() {
        assertEquals("samsung a50", smartphone.getName());
    }

    @Test
    void testPrice() {
        assertEquals(50000, smartphone.getPrice());
    }

    @Test
    void testAuthor() {
        assertEquals("samsung", smartphone.getManufacturer());
    }


    @Test
    void testEquals() {
        assertEquals(smartphone, smartphone2);
        assertTrue(smartphone.hashCode() == smartphone2.hashCode());
    }

    @Test
    void testEqualsOfAnotherId() {
        Smartphone smartphone2 = new Smartphone(2, "samsung a50", 50000, "samsung");
        assertNotEquals(smartphone, smartphone2);
    }

    @Test
    void testEqualsOfAnotherName() {
        Smartphone smartphone2 = new Smartphone(1, "samsung a30", 50000, "samsung");
        assertNotEquals(smartphone, smartphone2);
    }

    @Test
    void testEqualsOfAnotherPrice() {
        Smartphone smartphone2 = new Smartphone(1, "samsung a50", 30000, "samsung");
        assertNotEquals(smartphone, smartphone2);
    }

    @Test
    void testEqualsOfAnotherManufacturer() {
        Smartphone smartphone2 = new Smartphone(1, "samsung a50", 50000, "apple");
        assertNotEquals(smartphone, smartphone2);
    }

    @Test
    void testEqualsOfNull() {
        assertNotEquals(smartphone, null);
    }

    @Test
    void testEqualsOfAnotherClass() {
        Product product = new Product(1, "samsung a50", 50000);
        assertNotEquals(smartphone, product);
    }

    @Test
    void testEqualsOfSelf() {
        assertEquals(smartphone, smartphone);
    }

}
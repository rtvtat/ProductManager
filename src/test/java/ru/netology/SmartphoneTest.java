package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone(1, "samsung a50", 50000, "samsung");
    private Smartphone smartphone2 = new Smartphone(1, "samsung a50", 50000, "samsung");

    @Test
    public void testId() {
        assertEquals(1, smartphone.getId());
    }

    @Test
    public void testName() {
        assertEquals("samsung a50", smartphone.getName());
    }

    @Test
    public void testPrice() {
        assertEquals(50000, smartphone.getPrice());
    }

    @Test
    public void testAuthor() {
        assertEquals("samsung", smartphone.getManufacturer());
    }


    @Test
    public void testEquals() {
        assertEquals(smartphone, smartphone2);
        assertTrue(smartphone.hashCode() == smartphone2.hashCode());
    }

    @Test
    public void testEqualsOfAnotherId() {
        Smartphone smartphone2 = new Smartphone(2, "samsung a50", 50000, "samsung");
        assertNotEquals(smartphone, smartphone2);
    }

    @Test
    public void testEqualsOfAnotherName() {
        Smartphone smartphone2 = new Smartphone(1, "samsung a30", 50000, "samsung");
        assertNotEquals(smartphone, smartphone2);
    }

    @Test
    public void testEqualsOfAnotherPrice() {
        Smartphone smartphone2 = new Smartphone(1, "samsung a50", 30000, "samsung");
        assertNotEquals(smartphone, smartphone2);
    }

    @Test
    public void testEqualsOfAnotherManufacturer() {
        Smartphone smartphone2 = new Smartphone(1, "samsung a50", 50000, "apple");
        assertNotEquals(smartphone, smartphone2);
    }

    @Test
    public void testEqualsOfNull() {
        assertNotEquals(smartphone, null);
    }

    @Test
    public void testEqualsOfAnotherClass() {
        Product product = new Product(1, "samsung a50", 50000);
        assertNotEquals(smartphone, product);
    }

    @Test
    public void testEqualsOfSelf() {
        assertEquals(smartphone, smartphone);
    }

}
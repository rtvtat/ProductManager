package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void testId() {
        Product product = new Product(1, "product", 100);
        assertEquals(1, product.getId());
    }

    @Test
    public void testName() {
        Product product = new Product(1, "product", 100);
        assertEquals("product", product.getName());
    }

    @Test
    public void testPrice() {
        Product product = new Product(1, "product", 100);
        assertEquals(100, product.getPrice());
    }

    @Test
    public void testEquals() {
        Product product1 = new Product(1, "product", 100);
        Product product2 = new Product(1, "product", 100);
        assertEquals(product1, product2);
        assertTrue(product1.hashCode() == product2.hashCode());
    }

    @Test
    public void testEqualsOfAnotherId() {
        Product product1 = new Product(1, "product", 100);
        Product product2 = new Product(2, "product", 100);
        assertNotEquals(product1, product2);
    }

    @Test
    public void testEqualsOfAnotherName() {
        Product product1 = new Product(1, "product1", 100);
        Product product2 = new Product(1, "product2", 100);
        assertNotEquals(product1, product2);
    }

    @Test
    public void testEqualsOfAnotherPrice() {
        Product product1 = new Product(1, "product", 100);
        Product product2 = new Product(1, "product", 200);
        assertNotEquals(product1, product2);
    }

    @Test
    public void testEqualsOfNull() {
        Product product1 = new Product(1, "product", 100);
        assertNotEquals(product1, null);
    }

    @Test
    public void testEqualsOfAnotherClass() {
        Product product1 = new Product(1, "product", 100);
        Object product2 = new Object();
        assertNotEquals(product1, product2);
    }

    @Test
    public void testEqualsOfSelf() {
        Product product1 = new Product(1, "product", 100);
        assertEquals(product1, product1);
    }

}
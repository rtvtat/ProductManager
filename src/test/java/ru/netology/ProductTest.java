package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void testId() {
        Product product = new Product(1, "product", 100);
        assertEquals(1, product.getId());
    }

    @Test
    void testName() {
        Product product = new Product(1, "product", 100);
        assertEquals("product", product.getName());
    }

    @Test
    void testPrice() {
        Product product = new Product(1, "product", 100);
        assertEquals(100, product.getPrice());
    }

    @Test
    void testEquals() {
        Product product1 = new Product(1, "product", 100);
        Product product2 = new Product(1, "product", 100);
        assertEquals(product1, product2);
        assertTrue(product1.hashCode() == product2.hashCode());
    }

    @Test
    void testEqualsOfAnotherId() {
        Product product1 = new Product(1, "product", 100);
        Product product2 = new Product(2, "product", 100);
        assertNotEquals(product1, product2);
    }

    @Test
    void testEqualsOfAnotherName() {
        Product product1 = new Product(1, "product1", 100);
        Product product2 = new Product(1, "product2", 100);
        assertNotEquals(product1, product2);
    }

    @Test
    void testEqualsOfAnotherPrice() {
        Product product1 = new Product(1, "product", 100);
        Product product2 = new Product(1, "product", 200);
        assertNotEquals(product1, product2);
    }

    @Test
    void testEqualsOfNull() {
        Product product1 = new Product(1, "product", 100);
        assertNotEquals(product1, null);
    }

    @Test
    void testEqualsOfAnotherClass() {
        Product product1 = new Product(1, "product", 100);
        Object product2 = new Object();
        assertNotEquals(product1, product2);
    }

    @Test
    void testEqualsOfSelf() {
        Product product1 = new Product(1, "product", 100);
        assertEquals(product1, product1);
    }

}
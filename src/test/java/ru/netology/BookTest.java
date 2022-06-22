package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "Унесенные ветром", 10, "Маргарет Митчелл");
    private Book book2 = new Book(1, "Унесенные ветром", 10, "Маргарет Митчелл");

    @Test
    void testId() {
        assertEquals(1, book.getId());
    }

    @Test
    void testName() {
        assertEquals("Унесенные ветром", book.getName());
    }

    @Test
    void testPrice() {
        assertEquals(10, book.getPrice());
    }

    @Test
    void testAuthor() {
        assertEquals("Маргарет Митчелл", book.getAuthor());
    }


    @Test
    void testEquals() {
        assertEquals(book, book2);
        assertTrue(book.hashCode() == book2.hashCode());
    }

    @Test
    void testEqualsOfAnotherId() {
        Book book2 = new Book(2, "Унесенные ветром", 10, "Маргарет Митчелл");
        assertNotEquals(book, book2);
    }

    @Test
    void testEqualsOfAnotherName() {
        Book book2 = new Book(1, "Книга", 10, "Маргарет Митчелл");
        assertNotEquals(book, book2);
    }

    @Test
    void testEqualsOfAnotherPrice() {
        Book book2 = new Book(1, "Унесенные ветром", 20, "Маргарет Митчелл");
        assertNotEquals(book, book2);
    }

    @Test
    void testEqualsOfAnotherAuthor() {
        Book book2 = new Book(1, "Унесенные ветром", 10, "Лев Толстой");
        assertNotEquals(book, book2);
    }

    @Test
    void testEqualsOfNull() {
        assertNotEquals(book, null);
    }

    @Test
    void testEqualsOfAnotherClass() {
        Product product = new Product(1, "Унесенные ветром", 10);
        assertNotEquals(book, product);
    }

    @Test
    void testEqualsOfSelf() {
        assertEquals(book, book);
    }

}

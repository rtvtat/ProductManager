package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {
    ProductManager manager1;
    ProductManager manager2;

    @BeforeEach
    public void setUp() {

        manager1 = new ProductManager(new ProductRepository());
        manager1.add(new Book(1, "Унесенные ветром", 200, "Маргарет Митчелл"));
        manager1.add(new Book(2, "Двенадцать стульев", 100, "Илья Ильф, Евгений Петров"));
        manager1.add(new Book(3, "1984", 150, "Джордж Оруэл"));
        manager1.add(new Smartphone(4, "samsung a50", 50000, "samsung"));
        manager1.add(new Smartphone(4, "iphone", 100000, "apple"));

        manager2 = new ProductManager(new ProductRepository());
    }

    @Test
    public void testAddAll() {
        manager2.addAll(new Product[]{
                new Book(1, "Унесенные ветром", 200, "Маргарет Митчелл"),
                new Smartphone(4, "iphone", 100000, "apple")});
        Product[] all = manager2.findAll();
        assertEquals(2, all.length);
        Product[] expected = new Product[]{
                new Book(1, "Унесенные ветром", 200, "Маргарет Митчелл"),
                new Smartphone(4, "iphone", 100000, "apple")};
        assertArrayEquals(expected, all);

    }

    @Test
    public void testAdd() {
        manager2.add(new Book(1, "Книга1", 100, "Автор"));
        Product[] all = manager2.findAll();
        assertEquals(1, all.length);
        assertEquals("Книга1", all[0].getName());
        assertEquals(1, all[0].getId());
        assertEquals(100, all[0].getPrice());
        assertEquals("Автор", ((Book) all[0]).getAuthor());
    }

    @Test
    public void testSearch() {
        Product[] results = manager1.searchBy("Двенадцать");
        assertEquals(1, results.length);
        assertEquals("Двенадцать стульев", results[0].getName());
    }

    @Test
    public void testDelete() {
        manager1.deleteById(1);
        Product[] all = manager1.findAll();
        assertEquals(4, all.length);
        Product[] expected = new Product[4];
        expected[0] = new Book(1, "Унесенные ветром", 200, "Маргарет Митчелл");
        expected[1] = new Book(3, "1984", 150, "Джордж Оруэл");
        expected[2] = new Smartphone(4, "samsung a50", 50000, "samsung");
        expected[3] = new Smartphone(4, "iphone", 100000, "apple");
        assertArrayEquals(expected, all);
    }

    @Test
    public void testDeleteEmpty() {
        manager2.deleteById(0);
        Product[] all = manager2.findAll();
        assertEquals(0, all.length);
    }

    @Test
    public void testDeleteOutOfLowerRange() {
        manager1.deleteById(-1);
        Product[] all = manager1.findAll();
        assertEquals(5, all.length);
    }

    @Test
    public void testDeleteOutOfUpperRange() {
        manager1.deleteById(5);
        Product[] all = manager1.findAll();
        assertEquals(5, all.length);
    }

    @Test
    public void testSearchNotExitst() {
        Product[] results = manager1.searchBy("Одинадцать");
        assertEquals(0, results.length);
    }

    @Test
    void testAdd1() {
        Book product = new Book(1, "Книга1", 100, "Автор");
        manager2.add(product);
        Product[] all = manager2.findAll();
        assertEquals(1, all.length);
        assertEquals(product, all[0]);
    }

    @Test
    void testAdd2() {
        Product product = new Smartphone(1, "samsung a50", 150, "samsung");
        manager2.add(product);
        Product[] all = manager2.findAll();
        assertEquals(1, all.length);
        assertEquals("samsung a50", all[0].getName());
        assertEquals(1, all[0].getId());
        assertEquals(150, all[0].getPrice());
        assertEquals("samsung", ((Smartphone) all[0]).getManufacturer());
        assertEquals(product, all[0]);
    }

}
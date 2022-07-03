package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {
    ProductManager manager1;
    ProductManager manager2;
    ProductManager manager3;

    @BeforeEach
    public void setUp() {

        manager1 = new ProductManager(new ProductRepository());
        manager1.add(new Book(1, "Унесенные ветром", 200, "Маргарет Митчелл"));
        manager1.add(new Book(2, "Двенадцать стульев", 100, "Илья Ильф, Евгений Петров"));
        manager1.add(new Book(3, "1984", 150, "Джордж Оруэл"));
        manager1.add(new Book(4, "Двенадцать стульев", 100, "Илья Ильф, Евгений Петров"));
        manager1.add(new Smartphone(5, "samsung a50", 50000, "samsung"));
        manager1.add(new Smartphone(6, "iphone", 100000, "apple"));

        manager2 = new ProductManager(new ProductRepository());

        manager3 = new ProductManager(new ProductRepository());
        manager3.add(new Book(2, "Двенадцать стульев", 100, "Илья Ильф, Евгений Петров"));
    }

    @Test
    public void testAddAll() {
        manager2.addAll(new Product[]{
                new Book(1, "Унесенные ветром", 200, "Маргарет Митчелл"),
                new Smartphone(4, "iphone", 100000, "apple")});
        Product[] all = manager2.findAll();

        Product[] expected = new Product[]{
                new Book(1, "Унесенные ветром", 200, "Маргарет Митчелл"),
                new Smartphone(4, "iphone", 100000, "apple")};
        assertArrayEquals(expected, all);

    }

    @Test
    public void testAdd() {
        manager2.add(new Book(1, "Книга1", 100, "Автор"));
        Product[] all = manager2.findAll();

        Product[] excepted = new Product[] {
                new Book(1, "Книга1", 100, "Автор"),
        };
        assertArrayEquals(excepted, all);
    }

    @Test
    public void testSearchFindOne() {
        Product[] results = manager1.searchBy("1984");
        Product[] excepted = new Product[] {
                new Book(3, "1984", 150, "Джордж Оруэл")
        };
        assertArrayEquals(excepted, results);
    }

    @Test
    public void testSearchFindMany() {
        Product[] results = manager1.searchBy("Двенадцать");

        Product[] excepted = new Product[] {
            new Book(2, "Двенадцать стульев", 100, "Илья Ильф, Евгений Петров"),
            new Book(4, "Двенадцать стульев", 100, "Илья Ильф, Евгений Петров")
        };
        assertArrayEquals(excepted, results);
    }

    @Test
    public void testSearchEmptyRepository() {
        Product[] results = manager2.searchBy("Двенадцать");
        assertEquals(0, results.length);
    }

    @Test
    public void testSearchSingleRepository() {
        Product[] results = manager3.searchBy("Двенадцать");

        Product[] excepted = new Product[] {
                new Book(2, "Двенадцать стульев", 100, "Илья Ильф, Евгений Петров")
        };
        assertArrayEquals(excepted, results);
    }

    @Test
    public void testDelete() {
        manager1.deleteById(1);
        Product[] all = manager1.findAll();

        Product[] expected = new Product[] {
            new Book(1, "Унесенные ветром", 200, "Маргарет Митчелл"),
            new Book(3, "1984", 150, "Джордж Оруэл"),
            new Book(4, "Двенадцать стульев", 100, "Илья Ильф, Евгений Петров"),
            new Smartphone(5, "samsung a50", 50000, "samsung"),
            new Smartphone(6, "iphone", 100000, "apple")
        };
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
        assertEquals(6, all.length);
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

        assertEquals(product, all[0]);
    }

    @Test
    public void testAdd2() {
        Product product = new Smartphone(1, "samsung a50", 150, "samsung");
        manager2.add(product);
        Product[] all = manager2.findAll();

        Product[] expected = new Product[] {
                new Smartphone(1, "samsung a50", 150, "samsung")
        };
        assertArrayEquals(expected, all);
    }

}
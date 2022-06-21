package ru.netology;

import java.util.Arrays;

public class ProductRepository {
    private Product[] products = new Product[0];


    public void save(Product[] products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        Product[] newProducts = Arrays.copyOf(products, products.length + 1);
        newProducts[newProducts.length - 1] = product;
        this.products = newProducts;
    }

    public Product[] findAll() {
        return products;
    }

    public void deleteById(int id) {
        if (id < 0 || id > products.length - 1) {
            return;
        }
        int length = products.length - 1;
        Product[] newProducts = new Product[length];
        System.arraycopy(products, 0, newProducts, 0, id);
        System.arraycopy(products, id + 1, newProducts, id, products.length - 1 - id);
        products = newProducts;
    }

}

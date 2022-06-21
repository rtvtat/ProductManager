package ru.netology;

import java.util.Arrays;

public class ProductManager {

    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addAll(Product[] products) {
        repository.save(products);
    }

    public void add(Product product) {
        repository.addProduct(product);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = product;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}

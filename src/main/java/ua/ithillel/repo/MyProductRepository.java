package ua.ithillel.repo;

import org.springframework.stereotype.Repository;
import ua.ithillel.exception.ProductNotFoundException;
import ua.ithillel.model.Product;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MyProductRepository implements ProductRepository{
    List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Product("Product 1", 100.0f));
        products.add(new Product("Product 2", 200.0f));
        products.add(new Product("Product 3", 300.0f));
        products.add(new Product("Product 4", 50.0f));
        products.add(new Product("Product 5", 1000.0f));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> optionalProduct = products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();

        return optionalProduct.orElseThrow(() -> new ProductNotFoundException(id));
    }
}

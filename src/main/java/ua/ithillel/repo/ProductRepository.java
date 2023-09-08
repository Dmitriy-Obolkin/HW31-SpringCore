package ua.ithillel.repo;


import ua.ithillel.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getAllProducts();
    public Product getProductById(int id);
}

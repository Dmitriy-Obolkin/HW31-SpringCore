package ua.ithillel.model;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.ithillel.exception.ProductNotFoundException;
import ua.ithillel.repo.ProductRepository;

import java.util.List;

@Component
@Scope("prototype")
@RequiredArgsConstructor
@ToString(exclude = "repository")
public class MyCart implements Cart {
    private final ProductRepository repository;
    private final List<Product> products;

    public boolean addProduct(int id){
        try {
            Product productById = repository.getProductById(id);
            products.add(productById);

            System.out.println("The product " + productById.getName() + " has been successfully added to the cart");
            return true;
        } catch (ProductNotFoundException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removeProduct(int id){
        try {
            Product productById = repository.getProductById(id);

            if(products.remove(productById)){
                System.out.println("The product " + productById.getName() + " has been successfully removed from the cart");
                return true;
            } else {
                System.out.println("No product with ID " + id + " in the cart");
                return false;
            }



        } catch (ProductNotFoundException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

package ua.ithillel.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Integer id){
        super("Product with ID " + id + " not found.");
    }
}

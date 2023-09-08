package ua.ithillel.model;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private static int lastId = 0;

    private Integer id;
    private String name;
    private Float price;

    public Product(String name, Float price) {
        this.id = ++lastId;
        this.name = name;
        this.price = price;
    }
}

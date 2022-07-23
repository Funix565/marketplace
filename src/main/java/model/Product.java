package model;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private BigDecimal price;

    // I plan not to use setters, because adding a new field will cause troubles
    // When we have a constructor, a missing argument will be highlighted
    public Product(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // TODO: What getters do we need?
}

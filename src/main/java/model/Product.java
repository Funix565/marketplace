package model;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "ID: " + id +
                "\nName: " + name +
                "\nPrice: " + price + "\n\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && name.equals(product.name) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    // TODO: What getters do we need?
}

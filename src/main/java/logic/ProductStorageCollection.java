package logic;

import model.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductStorageCollection {

    // We use the Set to store unique objects in random order
    private Set<Product> products = new HashSet<>();
    private static ProductStorageCollection productStorageCollection;

    private ProductStorageCollection() {
        products.add(new Product(1, "Ubergun", new BigDecimal("750.95")));
        products.add(new Product(2, "ASCII Portrait", new BigDecimal("193.66")));
        products.add(new Product(3, "Mars rover", new BigDecimal("1000000000")));
    }

    // The Singleton because I want to have only one instance of product set created
    public static ProductStorageCollection getProductStorageCollection() {
        if (productStorageCollection == null) {
            productStorageCollection = new ProductStorageCollection();
        }

        return productStorageCollection;
    }

    public Set<Product> getAll() {
        return products;
    }
}

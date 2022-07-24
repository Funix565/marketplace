package logic;

import model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductStorageCollection {

    // We use Map to store objects and have quick access by id
    private Map<Integer, Product> products = new HashMap<>();
    private static ProductStorageCollection productStorageCollection;

    private ProductStorageCollection() {
        Product prod1 = new Product(1, "Ubergun", new BigDecimal("750.95"));
        products.putIfAbsent(prod1.getId(), prod1);
        Product prod2 = new Product(2, "ASCII Portrait", new BigDecimal("193.66"));
        products.putIfAbsent(prod2.getId(), prod2);
        Product prod3 = new Product(3, "Mars rover", new BigDecimal("1000000000"));
        products.putIfAbsent(prod3.getId(), prod3);
    }

    // The Singleton because I want to have only one instance of product map created
    public static ProductStorageCollection getProductStorageCollection() {
        if (productStorageCollection == null) {
            productStorageCollection = new ProductStorageCollection();
        }

        return productStorageCollection;
    }

    public Map<Integer, Product> getAll() {
        return products;
    }
}

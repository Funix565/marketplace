package logic;

import model.Product;
import model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserStorageCollection {

    // We use Map to store objects and have quick access by id
    private Map<Integer, User> users = new HashMap<>();

    // We use Map to associate User with their products
    // We use List because one User can have duplicate products
    private Map<User, ArrayList<Product>> userProducts = new HashMap<>();

    // Of course, it would be great to a have a list as a field for every User
    // But requirements: information about user and his products has to be stored in collection best suited for that purpose

    public static UserStorageCollection userStorageCollection;

    private UserStorageCollection() {
        User user1 = new User(1, "Taras", "Red", new BigDecimal("20000000"));
        users.putIfAbsent(user1.getId(), user1);
        User user2 = new User(2, "Inna", "Depp", new BigDecimal("15000"));
        users.putIfAbsent(user2.getId(), user2);
        User user3 = new User(3, "Bill", "Yellow", new BigDecimal("2500"));
        users.putIfAbsent(user3.getId(), user3);
        userProducts.putIfAbsent(user1, new ArrayList<>());
        userProducts.putIfAbsent(user2, new ArrayList<>());
        userProducts.putIfAbsent(user3, new ArrayList<>());
    }

    // The Singleton because I want to have only one instance of user set created
    public static UserStorageCollection getUserStorageCollection() {
        if (userStorageCollection == null) {
            userStorageCollection = new UserStorageCollection();
        }
        return userStorageCollection;
    }

    public Map<Integer, User> getAll() {
        return users;
    }

    public void buy(int userId, int productId) throws NotEnoughMoneyException {
        User user = users.get(userId);
        Product product = ProductStorageCollection.getProductStorageCollection().getAll().get(productId);
        if (user != null && product != null) {
            if (user.getAmountOfMoney().compareTo(product.getPrice()) < 0) {
                throw new NotEnoughMoneyException("WARNING: User has " + user.getAmountOfMoney()
                        + " but product costs " + product.getPrice() + "\n");
            }
            else {
                addProduct(user, product);
            }
        }
    }

    // It was the stupidest approach to update User fields as it was a Map key
    // At the beginning, we put User to Map (in Node) based on its hash
    // Then we changed User fields, hence we got a new hash
    // As a result, during the next hash (for contains), we could not find our User
    private void addProduct(User user, Product product) {
        // Save List
        // Remove user
        // Update balance
        // Add to List
        // Put to Map
        ArrayList<Product> products = userProducts.remove(user);
        user.setAmountOfMoney(user.getAmountOfMoney().subtract(product.getPrice()));
        products.add(product);
        userProducts.putIfAbsent(user, products);
    }

    public ArrayList<Product> getProductsByUserId(int userId) {
        User user = users.get(userId);
        ArrayList<Product> products = userProducts.get(user);
        return products;
    }

    public List<User> getUsersByProductId(int productId) {
        List<User> result = new ArrayList<>();
        Product product = ProductStorageCollection.getProductStorageCollection().getAll().get(productId);
        for (User u : userProducts.keySet()) {
            if (userProducts.get(u).contains(product)) {
                result.add(u);
            }
        }

        return result;
    }
}

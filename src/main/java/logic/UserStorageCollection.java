package logic;

import model.Product;
import model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserStorageCollection {

    // We use the Set to store unique objects in random order
    private Map<Integer, User> users = new HashMap<>();

    // We use so complicated parameters, because we need to store users and their products -- List<>
    // And also we need to have access to products by id -- Map<Integer, Product>
    private Map<User, List<Map<Integer, Product>>> userProducts = new HashMap<>();

    public static UserStorageCollection userStorageCollection;

    private UserStorageCollection() {
        User user1 = new User(1, "Taras", "Red", new BigDecimal("20000000"));
        users.putIfAbsent(user1.getId(), user1);
        User user2 = new User(2, "Inna", "Depp", new BigDecimal("15000"));
        users.putIfAbsent(user2.getId(), user2);
        User user3 = new User(3, "Bill", "Yellow", new BigDecimal("2500"));
        users.putIfAbsent(user3.getId(), user3);
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
                user.setAmountOfMoney(user.getAmountOfMoney().subtract(product.getPrice()));
                addProduct(user, product);
            }
        }
    }

    private void addProduct(User user, Product product) {
        if (!userProducts.containsKey(user)) {
            userProducts.putIfAbsent(user, new ArrayList<>());
        }
        HashMap<Integer, Product> idAndProductMap = new HashMap<>();
        idAndProductMap.putIfAbsent(product.getId(), product);
        userProducts.get(user).add(idAndProductMap);
    }

    public List<Map<Integer, Product>> getProductsByUserId(int userId) {
        User user = users.get(userId);
        return userProducts.get(user);
    }

    public List<User> getUsersByProductId(int productId) {
        List<User> result = new ArrayList<>();
        return null;
    }
}

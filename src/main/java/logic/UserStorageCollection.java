package logic;

import model.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserStorageCollection {

    // We use the Set to store unique objects in random order
    private Map<Integer, User> users = new HashMap<>();
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

    public void buy(int userId, int productId) throws ClassNotFoundException {

    }
}

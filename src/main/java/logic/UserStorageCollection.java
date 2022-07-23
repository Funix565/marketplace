package logic;

import model.User;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class UserStorageCollection {

    // We use the Set to store unique objects in random order
    private Set<User> users = new HashSet<>();
    public static UserStorageCollection userStorageCollection;

    private UserStorageCollection() {
        users.add(new User(1, "Taras", "Red", new BigDecimal("20000000")));
        users.add(new User(2, "Inna", "Depp", new BigDecimal("15000")));
        users.add(new User(3, "Bill", "Yellow", new BigDecimal("2500")));
    }

    // The Singleton because I want to have only one instance of user set created
    public static UserStorageCollection getUserStorageCollection() {
        if (userStorageCollection == null) {
            userStorageCollection = new UserStorageCollection();
        }
        return userStorageCollection;
    }

    public Set<User> getAll() {
        return users;
    }
}

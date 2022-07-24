package view;

import logic.NotEnoughMoneyException;
import logic.ProductStorageCollection;
import logic.UserStorageCollection;
import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private UserStorageCollection userStorage;
    private ProductStorageCollection productStorage;
    private Scanner sc = new Scanner(System.in);

    public Menu() {
        userStorage = UserStorageCollection.getUserStorageCollection();
        productStorage = ProductStorageCollection.getProductStorageCollection();
    }

    public void printOptions() {
        StringBuilder sb = new StringBuilder("Menu:\n");
        sb.append("1. Display list of all users\n");
        sb.append("2. Display list of all products\n");
        sb.append("3. Buy product\n");
        sb.append("4. Display list of user products by user id\n");
        sb.append("5. Display list of users that bought product by product id\n");
        sb.append("6. Quite\n\n");

        System.out.println(sb);

        System.out.print("Input: ");

        int input = sc.nextInt();
        switch (input) {
            case 1:
                displayUsers();
                break;
            case 2:
                displayProducts();
                break;
            case 3:
                buyProduct();
                break;
            case 4:
                displayProductsByUser();
                break;
            case 5:
                displayUsersByProduct();
                break;
            case 6:
                sc.close();
                System.exit(1);
        }
    }

    public void displayUsers() {
        Map<Integer, User> all = userStorage.getAll();
        for (User u : all.values()) {
            System.out.println(u);
        }

        printOptions();
    }

    public void displayProducts() {
        Map<Integer, Product> all = productStorage.getAll();
        for (Product p : all.values()) {
            System.out.println(p);
        }

        printOptions();
    }

    public void buyProduct() {
        System.out.print("Please, enter <user_id> <product_id>: ");

        int userId = sc.nextInt();
        int productId = sc.nextInt();
        try {
            userStorage.buy(userId, productId);
            System.out.println("INFO: Successful purchase");
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

        printOptions();
    }

    public void displayProductsByUser() {
        System.out.print("Please, enter <user_id>: ");
        int userId = sc.nextInt();
        ArrayList<Product> productsByUserId = userStorage.getProductsByUserId(userId);
        for (Product p : productsByUserId) {
            System.out.println(p);
        }

        printOptions();
    }

    public void displayUsersByProduct() {
        System.out.print("Please, enter <product_id>: ");
        int productId = sc.nextInt();
        List<User> usersByProductId = userStorage.getUsersByProductId(productId);
        for (User u : usersByProductId) {
            System.out.println(u);
        }

        printOptions();
    }
}

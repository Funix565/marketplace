package view;

import logic.ProductStorageCollection;
import logic.UserStorageCollection;
import model.Product;
import model.User;

import java.util.Scanner;
import java.util.Set;

public class Menu {
    private UserStorageCollection userStorage;
    private ProductStorageCollection productStorage;

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
        sb.append("5. Display list of users that bought product by product id\n\n");

        System.out.println(sb);

        System.out.print("Input: ");

        try (Scanner sc = new Scanner(System.in)) {
            int input = sc.nextInt();
            switch(input) {
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
                    displayUsersByproduct();
                    break;
            }
        }
    }

    public void displayUsers() {
        Set<User> all = userStorage.getAll();
        for (User u : all) {
            System.out.println(u);
        }

        printOptions();
    }

    public void displayProducts() {
        Set<Product> all = productStorage.getAll();
        for (Product p : all) {
            System.out.println(p);
        }

        printOptions();
    }

    public void buyProduct() {

    }

    public void displayProductsByUser() {

    }

    public void displayUsersByproduct() {

    }
}

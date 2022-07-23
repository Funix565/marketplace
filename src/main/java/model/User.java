package model;

import java.math.BigDecimal;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal amountOfMoney;

    // I plan not to use setters, because adding a new field will cause troubles
    // When we have a constructor, a missing argument will be highlighted
    public User(int id, String firstName, String lastName, BigDecimal amountOfMoney) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    // TODO: What getters do we need?
}

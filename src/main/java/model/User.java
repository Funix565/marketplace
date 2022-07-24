package model;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "ID: " + id +
                "\nFirst Name: " + firstName+
                "\nLast Name: " + lastName+
                "\nAmount of money: " + amountOfMoney + "\n\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        // It is better to use compareTo with BigDecimal
        return id == user.id && firstName.equals(user.firstName) && lastName.equals(user.lastName)
                && amountOfMoney.compareTo(user.amountOfMoney) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, amountOfMoney);
    }

    // TODO: What getters do we need?

    public int getId() {
        return id;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}

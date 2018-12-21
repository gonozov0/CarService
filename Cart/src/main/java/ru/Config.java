package ru;

public class Config {

    private String items;
    private String cart;
    private String balance;
    private String identity;

    public Config() {}

    public Config(String items, String cart, String balance, String identity) {
        this.items = items;
        this.cart = cart;
        this.balance = balance;
        this.identity = identity;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}

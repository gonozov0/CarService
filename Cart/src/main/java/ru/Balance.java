package ru;

public class Balance {

    private int user_id;
    private double money;

    public Balance() {}

    public Balance(int user_id, double money) {
        this.user_id = user_id;
        this.money = money;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

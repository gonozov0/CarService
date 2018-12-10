package ru;

public class CartItem {

    //private int id;
    //private int user_id;
    private int item_id;
    private int count;
    private int price;

    public CartItem() {}

    public CartItem(int item_id, int count) {
        this.item_id = item_id;
        this.count = count;
        price = -1;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

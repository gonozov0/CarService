package ru;

public class Cars {

    private String color;
    private int price;
    private String model;
    private String company;
    private int id;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Cars () {}

    public Cars(String company, String model, String color, int price) {
        this.id = -1;
        this.model = model;
        this.color = color;
        this.price = price;
        this.company = company;
    }

    public Cars(int id, String company, String model, String color, int price) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.price = price;
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

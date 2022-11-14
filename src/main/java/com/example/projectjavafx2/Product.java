package com.example.projectjavafx2;

public class Product {
    private int number;
    private String name;
    private double price;
    private int nbItems;

    public Product(String name, double price, int nbItems) {
        if (price <= 0) throw new IllegalArgumentException("Negative price!");
        if (nbItems <= 0) throw new IllegalArgumentException("Negative number of items!");
        this.name = name;
        this.price = price;
        this.nbItems = nbItems;
    }

    private static double income = 0;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Negative price!");
        this.price = price;
    }

    public int getNbItems() {
        return nbItems;
    }

    public void setNbItems(int nbItems) {
        if (nbItems <= 0) throw new IllegalArgumentException("Negative number of items!");
        this.nbItems = nbItems;
    }

    public static double getIncome() {
        return income;
    }

    public static void setIncome(double income) {
        Product.income = income;
    }

    @Override
    public String toString() {
        return this.name +
                ", " + this.price +
                "€, " + this.nbItems +
                ' ';
    }

    public void sell(int nbItems2){
        this.nbItems = this.nbItems - nbItems2;
        this.income = this.price * nbItems2;
    }

    public void purchase(int nbItems2){
        this.nbItems = this.nbItems + nbItems2;
    }
}

package com.example.projectjavafx2;

public class Accessories extends Product{

    public Accessories(String name, double price, int nbItems) {
        super(name, price, nbItems);
    }

    @Override
    public String toString() {
        return super.toString().substring(0,super.toString().length()-1) ;
    }
}

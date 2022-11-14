package com.example.projectjavafx2;

public class Clothes extends Product{

    private int size;

    public Clothes(String name, double price, int nbItems, int size) {
        super(name, price, nbItems);
        if (size < 34 && size >54) throw new IllegalArgumentException("Wrong size!");
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size < 34 && size >54) throw new IllegalArgumentException("Wrong size!");
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString().substring(0,super.toString().length()-1) + ", " + this.size;
    }
}

package com.example.projectjavafx2;

public class Shoes extends Product{

    private int shoeSize;

    public Shoes(String name, double price, int nbItems, int shoeSize) {
        super(name, price, nbItems);
        if (shoeSize < 36 && shoeSize >50) throw new IllegalArgumentException("Wrong shoe size!");
        this.shoeSize = shoeSize;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        if (shoeSize < 36 && shoeSize >50) throw new IllegalArgumentException("Wrong shoe size!");
        this.shoeSize = shoeSize;
    }

    @Override
    public String toString() {
        return super.toString().substring(0,super.toString().length()-1) + ", " + this.shoeSize;
    }
}

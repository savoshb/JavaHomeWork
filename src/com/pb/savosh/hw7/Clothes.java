package com.pb.savosh.hw7;

public abstract  class Clothes {
    Size size;
    double price;
    String color;
    String name;

    public Clothes(Size size, double price, String color, String name) {
        this.size = size;
        this.price = price;
        this.color = color;
        this.name = name;
    }
}

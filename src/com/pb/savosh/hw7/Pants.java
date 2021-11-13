package com.pb.savosh.hw7;

public class Pants extends Clothes implements ManClothes, WomanClothes {

    public Pants() {
        super(Size.XS,799.99,"black","штаны");
    }
    public void dressMan() {
        System.out.println("[Название: " + name + ", размер: " + size + ", " + size.getDescription() + ", евро: " + size.getEuroSize() + ", цена: " + price + ", цвет: " + color + "]");
    }
    public void dressWoman() {
        System.out.println("[Название: " + name + ", размер: " + size + ", " + size.getDescription() + ", евро: " + size.getEuroSize() + ", цена: " + price + ", цвет: " + color + "]");
    }
}

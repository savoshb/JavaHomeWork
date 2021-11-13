package com.pb.savosh.hw7;

public class Tshirt extends Clothes implements ManClothes, WomanClothes {

    public Tshirt() {
        super(Size.XXS,599.99,"white","футболка");
    }
    public void dressMan() {
        System.out.println("[Название: " + name + ", размер: " + size + ", " + size.getDescription() + ", евро: " + size.getEuroSize() + ", цена: " + price + ", цвет: " + color + "]");
    }
    public void dressWoman() {
        System.out.println("[Название: " + name + ", размер: " + size + ", " + size.getDescription() + ", евро: " + size.getEuroSize() + ", цена: " + price + ", цвет: " + color + "]");
    }


}

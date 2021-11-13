package com.pb.savosh.hw7;

public class Skirt extends Clothes implements WomanClothes {

    public Skirt() {
        super(Size.S,999.99,"yellow","юбка");
    }

    public void dressWoman() {
        System.out.println("[Название: " + name + ", размер: " + size + ", " + size.getDescription() + ", евро: " + size.getEuroSize() + ", цена: " + price + ", цвет: " + color + "]");
    }
}

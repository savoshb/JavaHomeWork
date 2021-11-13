package com.pb.savosh.hw7;

public class Tie extends Clothes implements ManClothes {

    public Tie() {
        super(Size.M,199.99,"red","галстук");
    }
    public void dressMan() {
        System.out.println("[Название: " + name + ", размер: " + size + ", " + size.getDescription() + ", евро: " + size.getEuroSize() + ", цена: " + price + ", цвет: " + color + "]");
    }

}

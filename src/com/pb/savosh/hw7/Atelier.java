package com.pb.savosh.hw7;


public class Atelier {
    public static void main(String[] args) {

        Tshirt tshirt = new Tshirt();
        Pants pants = new Pants();
        Skirt skirt = new Skirt();
        Tie tie = new Tie();

        Clothes[] clothes = new Clothes[] {tshirt, pants, skirt, tie};
        dressMan(clothes);
        dressWoman(clothes);

    }

    public static void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда:");
        for (Clothes cloth: clothes) {
            if (cloth instanceof ManClothes) {
                ManClothes manClothes = (ManClothes) cloth;
                manClothes.dressMan();
            }
        }
    }

    public static void dressWoman(Clothes[] clothes) {
        System.out.println("---------------");
        System.out.println("Женская одежда:");
        for (Clothes cloth: clothes) {
            if (cloth instanceof WomanClothes) {
                WomanClothes womanClothes = (WomanClothes) cloth;
                womanClothes.dressWoman();
            }
        }
    }
}


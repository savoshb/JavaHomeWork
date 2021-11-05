package com.pb.savosh.hw6;

public class Veterinarian {
    private String name;

    public Veterinarian (String name) {
    this.name = name;
    }

    public static void treatAnimal(Animal animal) {
        System.out.println("Еда: " + animal.getFood() + "; Местоположение: " + animal.getLocation());
    }
    public void heal (Animal animal) {
        System.out.println(name + " лечит животное типа: " + animal.getName());
    }

}

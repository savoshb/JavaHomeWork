package com.pb.savosh.hw6;

import java.lang.reflect.Constructor;

public class VetClinic {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat();
        cat.makeNoise();
        cat.eat();

        Dog dog = new Dog();
        dog.makeNoise();
        dog.eat();

        Horse horse = new Horse();
        horse.makeNoise();
        horse.eat();

        Animal[] animals = new Animal[]{cat, dog, horse};
        System.out.println("---------------------------");
        for (Animal j : animals) {
            Veterinarian.treatAnimal(j);
        }


        Class clazz = Class.forName("com.pb.savosh.hw6.Veterinarian");
        Constructor constr = clazz.getConstructor(new Class[]{String.class});
        Object obj = constr.newInstance("Петрович");
        ((Veterinarian) obj).heal(dog);
        System.out.println(obj.getClass());

    }
}


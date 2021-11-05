package com.pb.savosh.hw6;

import java.util.Objects;

public class Dog extends Animal {
    String type;
    float weight;

    public Dog () {
        super("Псина"," собачий корм", "собачий питомник");
    }

    @Override
    public void makeNoise() {
        System.out.println("---------------------------");
        super.makeNoise();
        System.out.print(" и пляшет" + "\n");
    }
    @Override
    public void eat() {
        super.eat();
        System.out.print(getFood() + "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(type, dog.type) && Objects.equals(weight, dog.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "type='" + type + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}

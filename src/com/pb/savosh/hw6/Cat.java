package com.pb.savosh.hw6;

import java.util.Objects;

public class Cat extends Animal {
    String type;
    float weight;

    public Cat() {
    super("Кот", " кошачий корм", "кошачий питомник");
    }


    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.print(" и плачет" + "\n");
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
        Cat cat = (Cat) o;
        return Objects.equals(type, cat.type) && Objects.equals(weight, cat.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "type='" + type + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}

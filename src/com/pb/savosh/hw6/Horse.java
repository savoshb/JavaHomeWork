package com.pb.savosh.hw6;

import java.util.Objects;

public class Horse extends Animal {
    String type;
    float weight;

    public Horse () {
        super("Конь", " конячий корм", "конячий питомник");
    }

    @Override
    public void makeNoise() {
        System.out.println("---------------------------");
        super.makeNoise();
        System.out.println(" и скачет");
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
        Horse horse = (Horse) o;
        return Objects.equals(type, horse.type) && Objects.equals(weight, horse.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "type='" + type + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}

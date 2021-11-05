package com.pb.savosh.hw6;

public class Animal {
    private String food;
    private String location;
    private String name;

    public Animal(String name, String food, String location) {
        this.name = name;
        this.food = food;
        this.location = location;
    }
    public Animal() {

    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeNoise() {
        System.out.print(name + " шумит");
    }

    public void eat() {
        System.out.print(name + " ест");
    }

    public void sleep() {
        System.out.println(name + " спит");
    }
}

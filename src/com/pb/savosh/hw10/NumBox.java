package com.pb.savosh.hw10;

public class NumBox<T extends Number> {
    private T[] numbers;
    private int size;

    public NumBox(int size) {
        numbers = (T[]) new Number[size];
        this.size = size;
    }

    public void add(T[] num) throws ArrayIndexOutOfBoundsException {
        this.numbers = num;
        if (num.length > size) {
            throw new ArrayIndexOutOfBoundsException("Ошибка! Массив уже полон!");
        }
    }

    public T get(int index) {
        return numbers[index];
    }

    public int length() {
        return numbers.length;
    }

    public double average() {
        double average = 0;
        for (T i : numbers) {
            average = sum() / length();
        }
        return average;
    }

    public double sum() {
        double sum = 0;
        for (T i : numbers) {
            sum += i.doubleValue();
        }
        return sum;
    }

    public T max() {
        T max = numbers[0];
        for (T i : numbers) {
            if (i.doubleValue() > max.doubleValue()) {
                max = i;
            }
        }
        return max;
    }
}








package com.pb.savosh.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        int[] array = new int[10];
        int sum = 0;
        int counter = 0;
        int change;
        boolean sort = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("Заполните массив:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println("Массив:");
        for (int j : array) {
            System.out.println(j);
        }
        for (int j : array) {
            sum += j;
        }
        System.out.println("Сумма элементов массива: " + sum);

        for (int j : array) {
            if (j > 0)
                counter += 1;
        }
        System.out.println("Кол-во положительных элементов: " + counter);
        System.out.println("Отсортированный массив:");
        while (!sort) {
            sort = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    sort = false;
                    change = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = change;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}





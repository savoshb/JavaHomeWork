package com.pb.savosh.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        System.out.println("Угадайте число от 0 до 100.");
        System.out.println("Для завершения игры введите 111.");
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int x = rand.nextInt(101);
        int attempt = 0;
        int y;


        while (true) {
            attempt++;
            System.out.println("Попытка № " + attempt + ":");
            y = scan.nextInt();

            if (y == 111) {
                break;
            }


            if (y < x) {
                System.out.println("Задуманное число больше вводимого!");
                continue;
            } else if (y > x) {
                System.out.println("Задуманное число меньше вводимого!");
                continue;
            }

            System.out.println("Поздравляем, Вы угадали число с " + attempt + "-й попытки!");
            break;
        }

        System.out.println("Game over!");
    }
}




package com.pb.savosh.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int x;
        Scanner in = new Scanner (System.in);
        System.out.println("Введите целое число:");
        x = in.nextInt();
        if ((x >= 0) && (x<= 14)) {
            System.out.println("Значение в интервале [0-14]");
        }
        else if ((x >= 15) && (x <= 35)) {
            System.out.println("Значение в интервале [15-35]");
        }
        else if ((x >= 36) && (x <= 50)) {
            System.out.println("Значение в интервале [36-50]");
        }
        else if ((x >= 51) && (x <= 100)) {
            System.out.println("Значение в интервале [51-100]");
        }
        else {
            System.out.println("Значение не принадлежит ни одному интервалу!");
        }

    }
}

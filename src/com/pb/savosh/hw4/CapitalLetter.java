package com.pb.savosh.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        String str;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите предложение:");
        str = scan.nextLine();
        System.out.println("Отформатированное предложение:");
        toUpperCase(str);

    }

    public static void toUpperCase(String str) {
        //String str = "привет как дела";
        char[] mass = str.toCharArray();
        for (int i = 0; i < mass.length; i++) {
            //System.out.println("Element [" + i + "]: " + mass[i]);
            if (mass[i] == ' ') {
                mass[i + 1] = Character.toUpperCase(mass[i + 1]);
            } else if (Character.isLowerCase(mass[0])) {
                mass[0] = Character.toUpperCase(mass[0]);
            }
            System.out.print(mass[i]);
        }
    }
}






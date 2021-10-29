package com.pb.savosh.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1;
        String str2;
        System.out.println("Введите первое предложение:");
        str1 = scan.nextLine();
        System.out.println("Введите второе предложение:");
        str2 = scan.nextLine();

        comparison(str1, str2);
    }

    public static void comparison(String str1, String str2) {
        String new1 = str1.replaceAll("\\p{Punct}|\\s", "");
        String new2 = str2.replaceAll("\\p{Punct}|\\s", "");
        new1 = new1.toLowerCase();
        new2 = new2.toLowerCase();

        char[] mass1 = new1.toCharArray();
        char[] mass2 = new2.toCharArray();
        int i = 0;
        int j = 0;
        Arrays.sort(mass1);
        Arrays.sort(mass2);
//        System.out.println(mass1);
//        System.out.println(mass2);

        if ((mass1[i] == mass2[j]) && (mass1.length == mass2.length)) {
            System.out.println("Это анаграмма!");
        } else {
            System.out.println("Это не анаграмма!");
        }
    }
}


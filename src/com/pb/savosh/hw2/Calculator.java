package com.pb.savosh.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int operand1;
        int operand2;

        System.out.println("Введите первое значение:");
            operand1 = in.nextInt();
        System.out.println("Введите второе значение:");
            operand2 = in.nextInt();
        System.out.println("Введите знак арифметической операции:");
            String sign = in.next();

    switch (sign) {
        case "+":
            System.out.println(operand1+operand2);
            break;
        case "-":
            System.out.println(operand1-operand2);
            break;
        case "/":
            if (operand2 == 0) {
                System.out.println("Делить на ноль низя!");
            } else {
                System.out.println(operand1 / operand2);
            }
            break;
        case "*":
            System.out.println(operand1*operand2);
            break;
        default:
            System.out.println("Неверный знак");
    }
    }
}

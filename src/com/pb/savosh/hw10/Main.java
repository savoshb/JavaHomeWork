package com.pb.savosh.hw10;

public class Main {
    public static void main(String[] args) {

        try {
            //Float
            System.out.println("Float:");

            NumBox<Float> numBox = new NumBox<>(3);
            numBox.add(new Float[]{0.5f, 25.3f, 3.7f});

            Number float1 = numBox.get(0);
            System.out.println("Элемент массива под выбранным индексом: " + float1.floatValue());

            Number float2 = numBox.length();
            System.out.println("Текущая длина массива: " + float2.floatValue());

            Number float3 = numBox.average();
            System.out.println("Среднее значение массива: " + float3.floatValue());

            Number float4 = numBox.sum();
            System.out.println("Сумма элементов массива: " + float4.floatValue());

            Number float5 = numBox.max();
            System.out.println("Максимальное значение массива: " + float5.floatValue());

            //Integer
            System.out.println("-----------------------------------\nInteger:");

            NumBox<Integer> num = new NumBox<>(2);
            num.add(new Integer[]{10, 25});

            Number int1 = num.get(1);
            System.out.println("Элемент массива под выбранным индексом: " + int1.intValue());

            Number int2 = num.length();
            System.out.println("Текущая длина массива: " + int2.intValue());

            Number int3 = num.average();
            System.out.println("Среднее значение массива: " + int3.intValue());

            Number int4 = num.sum();
            System.out.println("Сумма элементов массива: " + int4.intValue());

            Number int5 = num.max();
            System.out.println("Максимальное значение массива: " + int5.intValue());

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

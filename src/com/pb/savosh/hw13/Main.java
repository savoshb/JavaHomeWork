package com.pb.savosh.hw13;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        Producer producer = new Producer(list);
        Consumer consumer = new Consumer(list);
        Thread proThread = new Thread(producer);
        Thread consThread = new Thread(consumer);
        proThread.start();
        consThread.start();

    }
}


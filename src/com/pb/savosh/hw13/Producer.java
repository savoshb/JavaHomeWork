package com.pb.savosh.hw13;

import java.util.LinkedList;
import java.util.Random;

public class Producer implements Runnable {
    private final LinkedList<Integer> buffer;
    Random rand = new Random();


    public Producer(LinkedList<Integer> buffer) {
        this.buffer = buffer;

    }

    public void produce() {
        synchronized (buffer) {

            while (buffer.size() >= 5) {
                System.out.println("Буфер полон! " + buffer);
                try {
                    System.out.println("Ожидаем потребление буфера...");
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int buf = rand.nextInt(10);
            buffer.add(buf);
            System.out.println("В буфер добавлено: " + buf);
            System.out.println("Буфер: " + buffer);
            buffer.notifyAll();

        }
    }
    public void run() {
        System.out.println("Запуск производителя...");
        while(true) {
            produce();
            try {
                Thread.sleep(rand.nextInt(7000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

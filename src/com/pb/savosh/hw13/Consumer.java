package com.pb.savosh.hw13;

import java.util.LinkedList;
import java.util.Random;

public class Consumer implements Runnable {
    private final LinkedList<Integer> buffer;
    Random rand = new Random();


    public Consumer(LinkedList<Integer> buffer) {
        this.buffer = buffer;

    }

    public void consume() {
        synchronized (buffer) {
            while (buffer.isEmpty()) {
                System.out.println("Буфер пуст!");
                try {
                    System.out.println("Ожидаем наполнения буфера...");
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Потребляем элемент буфера...");

            int buf = buffer.getLast();
            System.out.println("Элемент " + buf + " потреблен.");
            buffer.removeLast();
            System.out.println("Буфер: " + buffer);
            buffer.notifyAll();
        }
    }
    public void run() {
        System.out.println("Запуск потребителя...");
        while(true) {
            consume();
            try {
                Thread.sleep(rand.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

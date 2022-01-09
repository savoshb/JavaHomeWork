package com.pb.savosh.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String clMessage;
                System.out.println("В ожидании сообщений...");
                while ((clMessage = in.readLine()) != null) {
                    if (clMessage.equalsIgnoreCase("bye")) {
                        in.close();
                        out.close();
                        socket.close();
                        break;
                    }
                    out.println(LocalDateTime.now() + " " + clMessage);
                    System.out.println(clMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int portNumber = 1777;
        ServerSocket servSocket = new ServerSocket(portNumber);
        System.out.println("Сервер запущен на порту " + portNumber);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clSocket = servSocket.accept();
            threadPool.submit(new Handler(clSocket));
        }
    }
}

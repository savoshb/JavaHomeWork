package com.pb.savosh.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int portNumber = 1234;
        System.out.println("Клиент запущен.");
        System.out.println("Подключение к " + host + ":" + portNumber);

        Socket socket = new Socket(host, portNumber);
        BufferedReader inServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outServer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

        String dataFromUser, dataFromServer;

        while ((dataFromUser = inConsole.readLine()) != null) {
            outServer.println(dataFromUser);
            dataFromServer = inServer.readLine();
            System.out.println(dataFromServer);
            if (dataFromUser.equalsIgnoreCase("bye")) {
                break;
            }
        }
        outServer.close();
        inServer.close();
        outServer.close();
        socket.close();
    }
}
package com.pb.savosh.hw15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GUIController {
    Socket socket = new Socket("localhost", 1777);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

    @FXML
    private TextArea server_field;

    @FXML
    private TextField clientMessageButton;

    @FXML
    private Button sendMessageButton;

    @FXML
    private TextField clientName_field;

    private String clientName = "Гость";

    public GUIController() throws IOException {
    }

    @FXML
    void initialize() {
        clientName_field.setOnAction(nameEvent -> clientName = clientName_field.getText());

        sendMessageButton.setOnAction(event -> {
            try {
                String dataFromUser,dataFromServer;
                dataFromUser = clientMessageButton.getText();
                out.println(dataFromUser);

                dataFromServer = in.readLine();
                server_field.setText(clientName + ": " + dataFromUser + "\n" + dataFromServer + "\n" + server_field.getText());
                clientMessageButton.clear();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

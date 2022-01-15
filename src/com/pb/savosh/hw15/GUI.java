package com.pb.savosh.hw15;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(Paths.get("src/com/pb/savosh/hw15/interface.fxml").toUri().toURL());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Messenger");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

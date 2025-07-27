package com.example.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)throws IOException {

        try {
            //opening the start window
            Parent root = FXMLLoader.load(getClass().getResource("choice.fxml"));
            Image vb = new Image(getClass().getResourceAsStream("/image/263700009_496808181560298_7603748063368441463_n (1).png"));
            Scene scene = new Scene(root, Color.BLACK);
            //adding an icon
            stage.getIcons().add(vb);
            //setting a title for the program
            stage.setTitle("VB CUP");
            //user can not resize the window of the program
            stage.setResizable(false);
            stage.setScene(scene);



            stage.show();

        }
        catch(Exception e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        launch();
    }
}
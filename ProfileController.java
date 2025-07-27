package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;




public class ProfileController {



    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Button DATABUTTON;

    int n = 0;





    @FXML

    public void LogOff(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choice.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML

    public void Leaderboard(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Leaderboards.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void statistics(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Statistics.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void checkIfAdmin(MouseEvent e) throws IOException{

        if (n == 0){
            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            User u = (User) stage.getUserData();
            //if the id of the logged in user is admin's id the data-editing button appears
            if(u.getID() == 0){
                DATABUTTON.setOpacity(1);
                DATABUTTON.setDisable(false);


            }
        }

        n++;
    }
    @FXML
    public void admin(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }







}

package com.example.login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;



public class AddUserController{



    @FXML
    private TextField pts;
    @FXML
    private TextField g;
    @FXML
    private TextField gw;
    @FXML
    private TextField mp;
    @FXML
    private TextField ast;
    @FXML
    private TextField rb;
    @FXML
    private TextField orb;
    @FXML
    private TextField drb;
    @FXML
    private TextField twpShot;
    @FXML
    private TextField twpScored;
    @FXML
    private TextField opShot;
    @FXML
    private TextField opScored;
    @FXML
    private TextField cap;
    @FXML
    private TextField pf;
    @FXML
    private TextField freeScored;
    @FXML
    private TextField freeShot;
    @FXML
    private TextField tov;
    @FXML
    private TextField stl;
    @FXML
    private TextField blk;
    @FXML
    private TextField team;
    @FXML
    private Button delete;
    @FXML
    private Label deleteLabel;
    @FXML
    private Rectangle deleteRect;

    int n = 0;

    private User us;


    public void sendUser(User us){
        this.us = us;

    }
    @FXML
    public void sendData(MouseEvent e){


        if(us != null && n == 0){
            //Setting the appropriate values from the selected user in the TextFields
            pts.setText(String.valueOf(us.getPoints()));
            g.setText(String.valueOf(us.getGamesPlayed()));
            gw.setText(String.valueOf(us.getGamesWon()));
            mp.setText(String.valueOf(us.getPlaytime()));
            ast.setText(String.valueOf(us.getAssists()));
            rb.setText(String.valueOf(us.getRebounds()));
            orb.setText(String.valueOf(us.getORebounds()));
            drb.setText(String.valueOf(us.getDRebounds()));
            twpShot.setText(String.valueOf(us.getTwoPointsShot()));
            twpScored.setText(String.valueOf(us.getTwoPointsScored()));
            opShot.setText(String.valueOf(us.getOnePointShot()));
            opScored.setText(String.valueOf(us.getOnePointScored()));
            cap.setText(String.valueOf(us.getCaptain()));
            pf.setText(String.valueOf(us.getPersonalFouls()));
            freeScored.setText(String.valueOf(us.getFreeThrowsScored()));
            freeShot.setText(String.valueOf(us.getFreeThrowsShot()));
            tov.setText(String.valueOf(us.getTurnovers()));
            stl.setText(String.valueOf(us.getSteals()));
            blk.setText(String.valueOf(us.getBlocks()));
            team.setText(us.getTeam());
            n++;
        }
        if(us.getID() == 0){
            //If the selected user is an admin the "delete user" button is disabled
            delete.setDisable(true);
            delete.setOpacity(0);
            deleteLabel.setOpacity(0);
            deleteRect.setOpacity(0);
        }


    }

    @FXML
    private void save(ActionEvent event) throws SQLException, ClassNotFoundException {


            String query = "UPDATE [aplikacija].[dbo].[VBCUP_TABLE1] " +
                    "SET [Points] = " + pts.getText() +", [Gamesplayed] = " + g.getText() + ", [Gameswon] = " + gw.getText() + ", [Playtime] = " + mp.getText() + ", [Assists] = " +
                    ast.getText() + ", [Rebounds] = " + rb.getText() + ", [ORebounds] = " + orb.getText() + ", [DRebounds] = " + drb.getText() + ", [TwoPointsShot] = " + twpShot.getText() +
                    ", [TwoPointsScored] = " + twpScored.getText() + ", [OnePointShot] = " + opShot.getText()  + ", [OnePointScored] = " + opScored.getText() + ", [Captain] = " + cap.getText() +
                    ", [PersonalFouls] = " + pf.getText() + ", [FreeThrowsScored] = " + freeScored.getText() + ", [FreeThrowsShot] = " + freeShot.getText() + ", [Turnovers] = " + tov.getText() +
                    ", [Steals] = " + stl.getText() + ", [Blocks] = " + blk.getText() + ", [Team] = '" + team.getText() + "'" + "\n" + "WHERE Id = " + Integer.toString(us.getID());

        CreateStatement().executeQuery(query);



    }
    @FXML
    private void reassurance(ActionEvent e){
        try {

            //when the user presses "delete user" button the reassurance window pops up
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reassurance.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            ReassuranceController controller = loader.getController();
            controller.sendUserReassurance(us);
            Stage currentStage = (Stage) pts.getScene().getWindow();
            currentStage.close();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(pts.getScene().getWindow());
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    private Statement CreateStatement() throws SQLException {
        Statement statement1 = getConnectionDB().createStatement();
        return statement1;
    }
    private Connection getConnectionDB() throws SQLException{
        Connection connectionDB = null;
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://82.135.199.140:4568;databaseName=aplikacija;encrypt=true;trustServerCertificate=true";
            String username = "Kostas";
            String password = "CENSORED";
            connectionDB = DriverManager.getConnection(url, username, password);

        }
        catch(ClassNotFoundException ex){

            ex.printStackTrace();
        }

        return connectionDB;
    }


}
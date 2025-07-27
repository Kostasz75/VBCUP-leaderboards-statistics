package com.example.login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ReassuranceController {
    @FXML
    private Button ButtonNO;

    private User use;
    public void sendUserReassurance(User us){
        this.use = us;

    }

    @FXML
    private void yesChosen(ActionEvent event)throws SQLException{
        //deleting the chosen player
        String SQL = "DELETE FROM [aplikacija].[dbo].[VBCUP_TABLE1]  " + "WHERE Id = " + use.getID();
        Stage stage = (Stage) ButtonNO.getScene().getWindow();
        stage.close();
        CreateStatement().executeQuery(SQL);


    }
    @FXML
    private void noChosen(ActionEvent event)throws SQLException{

        Stage stage = (Stage) ButtonNO.getScene().getWindow();
        stage.close();



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
            String password = "Kostela777";
            connectionDB = DriverManager.getConnection(url, username, password);

        }
        catch(ClassNotFoundException ex){

            ex.printStackTrace();
        }

        return connectionDB;
    }
}

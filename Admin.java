package com.example.login;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;


public class Admin {


    @FXML
    private Scene scene;
    @FXML
    private TableView<ObservableList> table;
    @FXML
    private Button editButton;


    int count = 0;
    private ObservableList<ObservableList> data = FXCollections.observableArrayList();

    @FXML
    public void ComebackToAfterLogin(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterLogin.fxml")));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void refreshButton(ActionEvent event) {


        int n = 1;
        ObservableList<ObservableList> dataUpdated = FXCollections.observableArrayList();
        table.setItems(dataUpdated);

        while (n <= getHighestID()) {
            try {

                //selecting all the data that corresponds with "n" id of the registered user
                String SQL = ("SELECT * FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Id = " + n);

                ResultSet rs = CreateStatement().executeQuery(SQL);

                //adding data to the observable list
                while (rs.next()) {
                    //Iterate Row

                    ObservableList<String> row = FXCollections.observableArrayList();

                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        //Iterate Column
                        row.add(rs.getString(i));
                        System.out.println(i);

                    }

                    dataUpdated.add(row);


                }
                table.setItems(dataUpdated);

            } catch (Exception e) {
                e.printStackTrace();

            }

            n++;



        }


    }

    @FXML
    private void receiveData(MouseEvent event) throws SQLException, IOException {

        //the execution of this method is counted so that it does not repeat continuously
        if (count == 0) {
            int n = 1;


            while (n <= getHighestID()) {
                try {
                    String SQL = ("SELECT * FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Id = " + n);
                    ResultSet rs = CreateStatement().executeQuery(SQL);

                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {

                        final int j = i;

                        TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                        col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                            public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                                return new SimpleStringProperty(param.getValue().get(j).toString());
                            }
                        });
                        table.getColumns().addAll(col);
                    }
                    //Adding data to the observable list
                    while (rs.next()) {
                        //Iterating Row
                        ObservableList<String> row = FXCollections.observableArrayList();
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                            //Iterating Column
                            row.add(rs.getString(i));
                        }
                        //adding row to the observable list
                        data.add(row);
                    }
                    //setting the observable list with all the rows in the table.
                    table.setItems(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                n++;
                count++;
            }
        }
    }

    @FXML
    private void selectedRow(MouseEvent e) throws IOException {
        ObservableList<String> selectedRow = table.getSelectionModel().getSelectedItem();

        User us = fromStringToUser(selectedRow);

        if (selectedRow != null) {
            //edit button does not function if the user does not select a row

            editButton.setDisable(false);


        }
    }

    @FXML
    private void editButtonPressed(ActionEvent e) {
        try {


    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddUser.fxml"));

    Parent root = loader.load();

    Scene scene = new Scene(root);


    AddUserController controller = loader.getController();

    ObservableList<String> selectedRow = table.getSelectionModel().getSelectedItem();

    User us = fromStringToUser(selectedRow);

            controller.sendUser(us);


    Stage stage = new Stage();


            stage.setScene(scene);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(table.getScene().getWindow());
            stage.show();
} catch (IOException ex) {
        ex.printStackTrace();
        }
        }

private int getHighestID() {
        int ans = 0;
        int count = 0;

        try {

        //getting the id of last registered user
        String SQL = ("SELECT [Id], MAX (Id) \n" +
        "FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
        "GROUP BY [Id], [Id]\n" +
        "ORDER BY MAX(Id) DESC; ");
        ResultSet rs = CreateStatement().executeQuery(SQL);

        while (rs.next() && count == 0) {
        ans = rs.getInt("Id");

        count++;
        }


        } catch (Exception e) {
        e.printStackTrace();

        }


        return ans;
        }

public User fromStringToUser(ObservableList<String> changeThisToUser) {


        //creating a user object from string, since rows of ObservableList<String> data type
        int id = Integer.parseInt(changeThisToUser.get(0));
        String username = changeThisToUser.get(1);
        String password = changeThisToUser.get(2);
        int points = Integer.parseInt(changeThisToUser.get(3));
        int gamesPlayed = Integer.parseInt(changeThisToUser.get(4));
        int gamesWon = Integer.parseInt(changeThisToUser.get(5));
        int playtime = Integer.parseInt(changeThisToUser.get(6));
        int assists = Integer.parseInt(changeThisToUser.get(7));
        int rebounds = Integer.parseInt(changeThisToUser.get(8));
        int ORebounds = Integer.parseInt(changeThisToUser.get(9));
        int DRebounds = Integer.parseInt(changeThisToUser.get(10));
        int twoPointsShot = Integer.parseInt(changeThisToUser.get(11));
        int twoPointsScored = Integer.parseInt(changeThisToUser.get(12));
        int onePointShot = Integer.parseInt(changeThisToUser.get(13));
        int onePointScored = Integer.parseInt(changeThisToUser.get(14));
        int captain = Integer.parseInt(changeThisToUser.get(15));
        int personalFouls = Integer.parseInt(changeThisToUser.get(16));
        int freeThrowsScored = Integer.parseInt(changeThisToUser.get(17));
        int freeThrowsShot = Integer.parseInt(changeThisToUser.get(18));
        int turnovers = Integer.parseInt(changeThisToUser.get(19));
        int steals = Integer.parseInt(changeThisToUser.get(20));
        int blocks = Integer.parseInt(changeThisToUser.get(21));
        String firstName = changeThisToUser.get(22);
        String lastName = changeThisToUser.get(23);
        String team = changeThisToUser.get(24);
        double efficiency = Double.parseDouble(changeThisToUser.get(25));

        User user = new User(id, username, password, points, gamesPlayed, gamesWon, playtime, assists, rebounds, ORebounds, DRebounds, twoPointsShot, twoPointsScored, onePointShot, onePointScored, captain, personalFouls, freeThrowsScored, freeThrowsShot, turnovers, steals, blocks, firstName, lastName, team, efficiency);


        return user;


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




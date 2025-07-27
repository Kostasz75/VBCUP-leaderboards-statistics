package com.example.login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;




public class LeaderboardsController{



    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Label FirstPlace;
    @FXML
    private Label SecondPlace;
    @FXML
    private Label ThirdPlace;
    @FXML
    private Label FourthPlace;
    @FXML
    private Label FifthPlace;
    @FXML
            private Label FirstPlaceText;
    @FXML
            private Rectangle FirstPlaceRect;
    @FXML
            private Label SecondPlaceText;
    @FXML
            private Rectangle SecondPlaceRect;
    @FXML
            private Label ThirdPlaceText;
    @FXML
            private Rectangle ThirdPlaceRect;
    @FXML
            private Label FourthPlaceText;
    @FXML
            private Rectangle FourthPlaceRect;
    @FXML
            private Label FifthPlaceText;
    @FXML
            private Rectangle FifthPlaceRect;
    @FXML
            private Label MVP;
    @FXML
            private Label Strategas;
    @FXML
            private Label Ilgauskas;
    @FXML
            private Label Stogas;
    @FXML
            private Label Baudejas;
    @FXML
            private Label GOAT;
    @FXML
            private Label Magnet;
    @FXML
            private Label JavtokoSvajone;
    @FXML
            private Label TaiklusisDzo;
    @FXML
            private Label Realizuotojas;




    int n = 0;
    @FXML
    public String[] GetRankingArray() {
        int count = 0;
        String A[] = new String[5];
        String ans = "";
        try {

            //getting sorted teams by the number of games won
            String SQL = ("SELECT [Team], MAX(Gameswon) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [Team], [Gameswon]\n" +
                    "  ORDER BY MAX(Gameswon) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next()){
                ans = rs.getString(1);

                //inserting the sorted teams to an array
                A[count] = ans;
                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return A;

    }

    @FXML
    private void setData(MouseEvent e)  {
        if (n == 0){
            String Teams[] = GetRankingArray();

            //if the team is a default name it does not display on the rankings

            if (!Objects.equals(Teams[0], "Komanda")){
                FirstPlace.setText(Teams[0]);
                FirstPlaceText.setText(stringPreparing(Teams[0]));
            }

            if (!Objects.equals(Teams[1], "Komanda")){
                SecondPlace.setText(Teams[1]);
                SecondPlaceText.setText(stringPreparing(Teams[1]));
            }

            if (!Objects.equals(Teams[2], "Komanda")){
                ThirdPlace.setText(Teams[2]);
                ThirdPlaceText.setText(stringPreparing(Teams[2]));
            }

            if (!Objects.equals(Teams[3], "Komanda")){
                FourthPlace.setText(Teams[3]);
                FourthPlaceText.setText(stringPreparing(Teams[3]));
            }

            if (!Objects.equals(Teams[4], "Komanda")){
                FifthPlace.setText(Teams[4]);
                FifthPlaceText.setText(stringPreparing(Teams[4]));
            }

            //setting up the display of the top players

            MVP.setText(getMVP());
            Strategas.setText(getMostAssistsPlayer());
            Ilgauskas.setText(getMostReboundsPlayer());
            Stogas.setText(getMostBlocksPlayer());
            Baudejas.setText(getMostPersonalFoulsPlayer());
            GOAT.setText(getMostPointsPlayer());
            Magnet.setText(getMostStealsPlayer());
            JavtokoSvajone.setText(getMostFreeThrowsScoredPlayer());
            TaiklusisDzo.setText(getMostTwoPointsScoredPlayer());
            Realizuotojas.setText(getMostOnePointScoredPlayer());


            n++;
        }



    }
    @FXML
    public String getMVP() {

            int count = 0;
            String FirstNameAns = "";
            String LastNameAns = "";
            try {
                String SQL = ("SELECT [FirstName], MAX(Efficiency) \n" +
                        "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                        "                                       GROUP BY [FirstName], [Efficiency]\n" +
                        "  ORDER BY MAX(Efficiency) DESC;");
                ResultSet rs = CreateStatement().executeQuery(SQL);



                while (rs.next() && count == 0){
                    FirstNameAns = rs.getString(1);


                    count++;
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            int countLast = 0;
        try {
            String SQL = ("SELECT [LastName], MAX(Efficiency) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [LastName], [Efficiency]\n" +
                    "  ORDER BY MAX(Efficiency) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && countLast == 0){
                LastNameAns = rs.getString(1);


                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (!checkIfInTheSameRow(FirstNameAns, LastNameAns)){

            return FirstNameAns + " " + getLastNameByFirstName(FirstNameAns) + ", " + getFirstNameByLastName(LastNameAns) + " " + LastNameAns + ".";
        }

            return FirstNameAns + " " + LastNameAns;

        }
    @FXML
    public String getMostAssistsPlayer() {

        int count = 0;
        String FirstNameAns = "";
        String LastNameAns = "";
        try {

            String SQL = ("SELECT [FirstName], MAX(Assists) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [FirstName], [Assists]\n" +
                    "  ORDER BY MAX(Assists) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && count == 0){
                FirstNameAns = rs.getString(1);


                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int countLast = 0;
        try {

            String SQL = ("SELECT [LastName], MAX(Assists) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [LastName], [Assists]\n" +
                    "  ORDER BY MAX(Assists) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && countLast == 0){
                LastNameAns = rs.getString(1);


                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (!checkIfInTheSameRow(FirstNameAns, LastNameAns)){

            return FirstNameAns + " " + getLastNameByFirstName(FirstNameAns) + ", " + getFirstNameByLastName(LastNameAns) + " " + LastNameAns + ".";
        }

        return FirstNameAns + " " + LastNameAns;

    }
    @FXML
    public String getMostPersonalFoulsPlayer() {

        int count = 0;
        String FirstNameAns = "";
        String LastNameAns = "";
        try {

            String SQL = ("SELECT [FirstName], MAX(PersonalFouls) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [FirstName], [PersonalFouls]\n" +
                    "  ORDER BY MAX(PersonalFouls) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && count == 0){
                FirstNameAns = rs.getString(1);


                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int countLast = 0;
        try {
            String SQL = ("SELECT [LastName], MAX(PersonalFouls) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [LastName], [PersonalFouls]\n" +
                    "  ORDER BY MAX(PersonalFouls) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && countLast == 0){
                LastNameAns = rs.getString(1);


                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (!checkIfInTheSameRow(FirstNameAns, LastNameAns)){

            return FirstNameAns + " " + getLastNameByFirstName(FirstNameAns) + ", " + getFirstNameByLastName(LastNameAns) + " " + LastNameAns + ".";
        }

        return FirstNameAns + " " + LastNameAns;

    }
    @FXML
    public String getMostReboundsPlayer() {

        int count = 0;
        String FirstNameAns = "";
        String LastNameAns = "";
        try {
            String SQL = ("SELECT [FirstName], MAX(Rebounds) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [FirstName], [Rebounds]\n" +
                    "  ORDER BY MAX(Rebounds) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && count == 0){
                FirstNameAns = rs.getString(1);


                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int countLast = 0;
        try {
            String SQL = ("SELECT [LastName], MAX(Rebounds) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [LastName], [Rebounds]\n" +
                    "  ORDER BY MAX(Rebounds) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && countLast == 0){
                LastNameAns = rs.getString(1);


                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (!checkIfInTheSameRow(FirstNameAns, LastNameAns)){

            return FirstNameAns + " " + getLastNameByFirstName(FirstNameAns) + ", " + getFirstNameByLastName(LastNameAns) + " " + LastNameAns + ".";
        }

        return FirstNameAns + " " + LastNameAns;

    }
    @FXML
    public String getMostBlocksPlayer() {

        int count = 0;
        String FirstNameAns = "";
        String LastNameAns = "";
        try {

            String SQL = ("SELECT [FirstName], MAX(Blocks) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [FirstName], [Blocks]\n" +
                    "  ORDER BY MAX(Blocks) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && count == 0){
                FirstNameAns = rs.getString(1);


                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int countLast = 0;
        try {

            String SQL = ("SELECT [LastName], MAX(Blocks) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [LastName], [Blocks]\n" +
                    "  ORDER BY MAX(Blocks) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && countLast == 0){
                LastNameAns = rs.getString(1);


                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (!checkIfInTheSameRow(FirstNameAns, LastNameAns)){

            return FirstNameAns + " " + getLastNameByFirstName(FirstNameAns) + ", " + getFirstNameByLastName(LastNameAns) + " " + LastNameAns + ".";
        }

        return FirstNameAns + " " + LastNameAns;

    }
    
    @FXML
    public String getMostPointsPlayer() {

        int count = 0;
        String FirstNameAns = "";
        String LastNameAns = "";
        try {
            String SQL = ("SELECT [FirstName], MAX(Points) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [FirstName], [Points]\n" +
                    "  ORDER BY MAX(Points) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && count == 0){
                FirstNameAns = rs.getString(1);


                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int countLast = 0;
        try {

            String SQL = ("SELECT [LastName], MAX(Points) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [LastName], [Points]\n" +
                    "  ORDER BY MAX(Points) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && countLast == 0){
                LastNameAns = rs.getString(1);


                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (!checkIfInTheSameRow(FirstNameAns, LastNameAns)){

            return FirstNameAns + " " + getLastNameByFirstName(FirstNameAns) + ", " + getFirstNameByLastName(LastNameAns) + " " + LastNameAns + ".";
        }

        return FirstNameAns + " " + LastNameAns;

    }
    @FXML
    public String getMostStealsPlayer() {

        int count = 0;
        String FirstNameAns = "";
        String LastNameAns = "";
        try {

            String SQL = ("SELECT [FirstName], MAX(Steals) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [FirstName], [Steals]\n" +
                    "  ORDER BY MAX(Steals) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && count == 0){
                FirstNameAns = rs.getString(1);


                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int countLast = 0;
        try {

            String SQL = ("SELECT [LastName], MAX(Steals) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [LastName], [Steals]\n" +
                    "  ORDER BY MAX(Steals) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && countLast == 0){
                LastNameAns = rs.getString(1);


                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (!checkIfInTheSameRow(FirstNameAns, LastNameAns)){

            return FirstNameAns + " " + getLastNameByFirstName(FirstNameAns) + ", " + getFirstNameByLastName(LastNameAns) + " " + LastNameAns + ".";
        }

        return FirstNameAns + " " + LastNameAns;

    }
    @FXML
    public String getMostFreeThrowsScoredPlayer() {

        int count = 0;
        String FirstNameAns = "";
        String LastNameAns = "";
        try {
            String SQL = ("SELECT [FirstName], MAX(FreeThrowsScored) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [FirstName], [FreeThrowsScored]\n" +
                    "  ORDER BY MAX(FreeThrowsScored) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && count == 0){
                FirstNameAns = rs.getString(1);


                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int countLast = 0;
        try {
            String SQL = ("SELECT [LastName], MAX(FreeThrowsScored) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [LastName], [FreeThrowsScored]\n" +
                    "  ORDER BY MAX(FreeThrowsScored) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && countLast == 0){
                LastNameAns = rs.getString(1);


                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (!checkIfInTheSameRow(FirstNameAns, LastNameAns)){

            return FirstNameAns + " " + getLastNameByFirstName(FirstNameAns) + ", " + getFirstNameByLastName(LastNameAns) + " " + LastNameAns + ".";
        }

        return FirstNameAns + " " + LastNameAns;

    }
    @FXML
    public String getMostTwoPointsScoredPlayer() {

        int count = 0;
        String FirstNameAns = "";
        String LastNameAns = "";
        try {
            String SQL = ("SELECT [FirstName], MAX(TwoPointsScored) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [FirstName], [TwoPointsScored]\n" +
                    "  ORDER BY MAX(TwoPointsScored) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && count == 0){
                FirstNameAns = rs.getString(1);


                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int countLast = 0;
        try {
            String SQL = ("SELECT [LastName], MAX(TwoPointsScored) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [LastName], [TwoPointsScored]\n" +
                    "  ORDER BY MAX(TwoPointsScored) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && countLast == 0){
                LastNameAns = rs.getString(1);


                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (!checkIfInTheSameRow(FirstNameAns, LastNameAns)){

            return FirstNameAns + " " + getLastNameByFirstName(FirstNameAns) + ", " + getFirstNameByLastName(LastNameAns) + " " + LastNameAns + ".";
        }

        return FirstNameAns + " " + LastNameAns;

    }

    @FXML
    public String getMostOnePointScoredPlayer() {

        int count = 0;
        String FirstNameAns = "";
        String LastNameAns = "";
        try {
            String SQL = ("SELECT [FirstName], MAX(OnePointScored) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [FirstName], [OnePointScored]\n" +
                    "  ORDER BY MAX(OnePointScored) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && count == 0){
                FirstNameAns = rs.getString(1);


                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int countLast = 0;
        try {
            String SQL = ("SELECT [LastName], MAX(OnePointScored) \n" +
                    "                                FROM [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "                                       GROUP BY [LastName], [OnePointScored]\n" +
                    "  ORDER BY MAX(OnePointScored) DESC;");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && countLast == 0){
                LastNameAns = rs.getString(1);


                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (!checkIfInTheSameRow(FirstNameAns, LastNameAns)){

            return FirstNameAns + " " + getLastNameByFirstName(FirstNameAns) + ", " + getFirstNameByLastName(LastNameAns) + " " + LastNameAns + ".";
        }

        return FirstNameAns + " " + LastNameAns;

    }



    @FXML
    public void ShowFirstPopUp (MouseEvent e)  {



        FirstPlaceRect.setOpacity(0.9);

        FirstPlaceText.setOpacity(0.9);


    }
    @FXML
    public void ShowSecondPopUp (MouseEvent e)  {



        SecondPlaceRect.setOpacity(0.9);

        SecondPlaceText.setOpacity(0.9);


    }
    @FXML
    public void ShowThirdPopUp (MouseEvent e)  {



        ThirdPlaceRect.setOpacity(0.9);

        ThirdPlaceText.setOpacity(0.9);


    }
    @FXML
    public void ShowFourthPopUp (MouseEvent e)  {



        FourthPlaceRect.setOpacity(0.9);

        FourthPlaceText.setOpacity(0.9);


    }
    @FXML
    public void ShowFifthPopUp (MouseEvent e)  {



        FifthPlaceRect.setOpacity(0.9);

        FifthPlaceText.setOpacity(0.9);


    }
    @FXML
    public void HideAllPopUps (MouseEvent e)  {
        FirstPlaceRect.setOpacity(0);
        FirstPlaceText.setOpacity(0);
        SecondPlaceRect.setOpacity(0);
        SecondPlaceText.setOpacity(0);
        ThirdPlaceRect.setOpacity(0);
        ThirdPlaceText.setOpacity(0);
        FourthPlaceRect.setOpacity(0);
        FourthPlaceText.setOpacity(0);
        FifthPlaceRect.setOpacity(0);
        FifthPlaceText.setOpacity(0);
    }
    @FXML
    public int getGamesWon(String team) {
        int ans = 0;
        try {

        String SQL = ("SELECT [Gameswon] FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Team = '" + team + "';");
        ResultSet rs = CreateStatement().executeQuery(SQL);



        while (rs.next()){
            ans = rs.getInt(1);
        }
    }
    catch (Exception ex){
        ex.printStackTrace();
    }
        return ans;
    }
    @FXML
    public int getGamesplayed(String team) {
        int ans = 0;
        try {
            String SQL = ("SELECT [Gamesplayed] FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Team = '" + team + "';");
            ResultSet rs = CreateStatement().executeQuery(SQL);


            while (rs.next()){
                ans = rs.getInt(1);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ans;
    }
    @FXML
    public int getSizeOfTeam(String team) {
        int row = 0;
        try {
            String SQL = ("SELECT [FirstName], MAX(Efficiency)\n" +
                    "                             FROM [aplikacija].[dbo].[VBCUP_TABLE1] " + " WHERE Team = '" + team + "'\n" +
                    "            GROUP BY [FirstName], [Efficiency]\n" +
                    "            ORDER BY MAX(Efficiency) DESC;");
            ResultSet FirstNameRs = CreateStatement().executeQuery(SQL);


            while (FirstNameRs.next()){
                row++;
            }
        }
             catch (Exception ex){
                ex.printStackTrace();
            }

        return row;

    }

    @FXML
    public String[][] getPlayersOfTeam(String team) {
        int row = 0;
        int SizeOfTheTeam = getSizeOfTeam(team);
        String Names[][] = new String[SizeOfTheTeam][2];
        try {
            String SQL = ("SELECT [FirstName], MAX(Efficiency)\n" +
                    "                             FROM [aplikacija].[dbo].[VBCUP_TABLE1] " + " WHERE Team = '" + team + "'\n" +
                    "            GROUP BY [FirstName], [Efficiency]\n" +
                    "            ORDER BY MAX(Efficiency) DESC;");
            ResultSet FirstNameRs = CreateStatement().executeQuery(SQL);

            while (FirstNameRs.next()){
                Names[row][0] = FirstNameRs.getString(1);
                row++;
            }
            String SQL1 = ("SELECT [LastName], MAX(Efficiency)\n" +
                    "                              FROM [aplikacija].[dbo].[VBCUP_TABLE1] " + " WHERE Team = '" + team + "'\n" +
                    "            GROUP BY [LastName], [Efficiency]\n" +
                    "            ORDER BY MAX(Efficiency) DESC;");

            ResultSet LastNameRs = CreateStatement().executeQuery(SQL1);




            row = 0;
            while (LastNameRs.next()){
                Names[row][1] = LastNameRs.getString(1);
                row++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return Names;

    }
    @FXML
    public boolean checkIfInTheSameRow(String FirstNameAns, String LastNameAns){
        boolean correct = true;
        int Id1 = 0;
        int Id2 = 0;
        int count = 0;

        try {
            String SQL = ("SELECT [Id] FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE [FirstName] = '" + FirstNameAns + "'");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            while (rs.next() && count == 0){
                Id1 = rs.getInt(1);


                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int countLast = 0;
        try {
            String SQL = ("SELECT [Id] FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE [LastName] = '" + LastNameAns + "'");

            ResultSet rs = CreateStatement().executeQuery(SQL);


            while (rs.next() && countLast == 0){
                Id2 = rs.getInt(1);

                countLast++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if (Id1 != Id2){
            correct = false;
        }

        return correct;
    }
    @FXML
    public String stringPreparing (String team) {
        String PlayersOfTeam[][] = getPlayersOfTeam(team);
        int row = 0;
        int col = 0;
        int SizeOfTheTeam = getSizeOfTeam(team);
        //preparing strings for the popups
        String unpreparedString = "G: " + getGamesplayed(team) + " GW: " + getGamesWon(team) + " Žaidėjai: ";
        String preparedString = unpreparedString + "";
        while (row < SizeOfTheTeam){
            preparedString = preparedString + PlayersOfTeam[row][col] + " ";
                    col++;
            while(col > 0){
                if (row + 1 == SizeOfTheTeam){
                    preparedString = preparedString + PlayersOfTeam[row][col] + ".";
                }
                else{
                    preparedString = preparedString + PlayersOfTeam[row][col] + ", ";
                }

                        col = 0;
            }

            row++;
        }

        return preparedString;
    }
    @FXML
    public String getFirstNameByLastName (String LastName){

        String FirstName = "";
        try {
            String SQL = ("SELECT [FirstName] FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE [LastName] = '" + LastName + "'");
            ResultSet FirstNameRs = CreateStatement().executeQuery(SQL);

            while (FirstNameRs.next()){
                FirstName = FirstNameRs.getString(1);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return FirstName;


    }
    @FXML
    public String getLastNameByFirstName (String FirstName){

        String LastName = "";
        try {
            String SQL = ("SELECT [LastName] FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE [FirstName] = '" + FirstName + "'");
            ResultSet LastNameRs = CreateStatement().executeQuery(SQL);


            while (LastNameRs.next()){
                LastName = LastNameRs.getString(1);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return LastName;


    }
    private Statement CreateStatement() throws SQLException{
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
    @FXML
    public void ComebackToAfterLogin (ActionEvent e) throws IOException {
        //returning to the previous scene
        Parent root = FXMLLoader.load(getClass().getResource("afterLogin.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

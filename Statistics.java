package com.example.login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;


public class Statistics {


    @FXML
    public Label PlayerName;
    @FXML
    public Label PlayerTeam;
    @FXML
    public Label Tashkai;
    @FXML
    public Label SuzhaistiZhaidimai;
    @FXML
    public Label LaimetiZhaidimai;
    @FXML
    public Label LaikoPrazhaista;
    @FXML
    public Label RezultatyvusPerdavimai;
    @FXML
    public Label AtkovotiKamuoliai;
    @FXML
    public Label AtliktosPrazhangos;
    @FXML
    public Label PrarastiKamuoliai;
    @FXML
    public Label PerimtiKamuoliai;
    @FXML
    public Label BlokuotiMetimai;
    @FXML
    public Label NaudingumoTashkai;
    @FXML
    public Label CaptainOrNot;
    @FXML
    public Label VienoMesti;
    @FXML
    public Label VienoPelnyti;
    @FXML
    public Label VienoVidurkis;
    @FXML
    public Label DviejuMesti;
    @FXML
    public Label DviejuPelnyti;
    @FXML
    public Label DviejuVidurkis;
    @FXML
    public Label BauduMesti;
    @FXML
    public Label BauduPelnyti;
    @FXML
    public Label BauduVidurkis;
    @FXML
    public Label AtakojeAtkovotiKamuoliai;
    @FXML
    public Label GynybojeAtkovotiKamuoliai;
    @FXML
    public Rectangle PelnytiRect;
    @FXML
    public Label PelnytiText;
    @FXML
    public Rectangle SuzhaistiRect;
    @FXML
    public Label SuzhaistiText;
    @FXML
    public Rectangle LaimetiRect;
    @FXML
    public Label LaimetiText;
    @FXML
    public Rectangle LaikasRect;
    @FXML
    public Label LaikasText;
    @FXML
    public Rectangle RezultatyvusRect;
    @FXML
    public Label RezultatyvusText;
    @FXML
    public Rectangle AtkovotiRect;
    @FXML
    public Label AtkovotiText;
    @FXML
    public Rectangle AtkovotiGynRect;
    @FXML
    public Label AtkovotiGynText;
    @FXML
    public Rectangle AtkovotiPuolimRect;
    @FXML
    public Label AtkovotiPuolimText;
    @FXML
    public Rectangle PrarastiRect;
    @FXML
    public Label PrarastiText;
    @FXML
    public Rectangle BlokuotiRect;
    @FXML
    public Label BlokuotiText;
    @FXML
    public Rectangle AsmeninesRect;
    @FXML
    public Label AsmeninesText;
    @FXML 
    public Rectangle PerimtiRect;
    @FXML
    public Label PerimtiText;
    @FXML
    public Rectangle NaudingumoRect;
    @FXML
    public Label NaudingumoText;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private ImageView MVPBadge;
    @FXML
    private Text AKA;


    int n = 0;
    int c = 0;


@FXML
    private void receiveData(MouseEvent event) throws IOException{
    if (n == 0){

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        User u = (User) stage.getUserData();
        String FullName = u.getFirstName() + " " + u.getLastName();
        String preparedAKA = "";

        //setting all the corresponding data of the logged in user
        int Points = u.getPoints();
        String PointsText = String.valueOf(Points);
        int GamesPlayed = u.getGamesPlayed();
        String GamesPlayedText = String.valueOf(GamesPlayed);
        int GamesWon = u.getGamesWon();
        String GamesWonText = String.valueOf(GamesWon);
        int Playtime = u.getPlaytime();
        String PlaytimeText = String.valueOf(Playtime);
        int Assists = u.getAssists();
        String AssistsText = String.valueOf(Assists);
        int Rebounds = u.getRebounds();
        String ReboundsText = String.valueOf(Rebounds);
        int ORebounds = u.getORebounds();
        String OReboundsText = String.valueOf(ORebounds);
        int DRebounds = u.getDRebounds();
        String DReboundsText = String.valueOf(DRebounds);
        double TwoPointsShot = u.getTwoPointsShot();
        String TwoPointsShotText = String.valueOf((int)TwoPointsShot);
        double TwoPointsScored = u.getTwoPointsScored();
        String TwoPointsScoredText = String.valueOf((int)TwoPointsScored);
        double TwoPointsAccuracy = TwoPointsScored/TwoPointsShot * 100;
        double RoundedTwoPointsAccuracy = Math.round(TwoPointsAccuracy*100.0)/100.0;
        String TwoPointsAccuracyText = String.valueOf(RoundedTwoPointsAccuracy);
        double OnePointShot = u.getOnePointShot();
        String OnePointShotText = String.valueOf((int)OnePointShot);
        double OnePointScored = u.getOnePointScored();
        String OnePointScoredText = String.valueOf((int)OnePointScored);
        double OnePointAccuracy = OnePointScored/OnePointShot * 100;
        double RoundedOnePointAccuracy = Math.round(OnePointAccuracy*100.0)/100.0;
        String OnePointAccuracyText = String.valueOf(RoundedOnePointAccuracy);
        int Captain = u.getCaptain();
        int PersonalFouls = u.getPersonalFouls();
        String PersonalFoulsText = String.valueOf(PersonalFouls);
        double FreeThrowsScored = u.getFreeThrowsScored();
        String FreeThrowsScoredText = String.valueOf((int)FreeThrowsScored);
        double FreeThrowsShot = u.getFreeThrowsShot();
        String FreeThrowsShotText = String.valueOf((int)FreeThrowsShot);
        double FreeThrowsAccuracy = FreeThrowsScored/FreeThrowsShot * 100;
        double RoundedFreeThrowsAccuracy = Math.round(FreeThrowsAccuracy*100.0)/100.0;
        String FreeThrowsAccuracyText = String.valueOf(RoundedFreeThrowsAccuracy);
        int Turnovers = u.getTurnovers();
        String TurnoversText = String.valueOf(Turnovers);
        int Steals = u.getSteals();
        String StealsText = String.valueOf(Steals);
        int Blocks = u.getBlocks();
        String BlocksText = String.valueOf(Blocks);
        double FieldGoalsMade = TwoPointsScored + OnePointScored;
        double FieldGoalsAttempted = TwoPointsShot + OnePointShot;
        double Efficiency = (Points + Rebounds + Assists + Steals + Blocks - ((FieldGoalsAttempted - FieldGoalsMade) + (FreeThrowsShot - FreeThrowsScored) + Turnovers));
        String EfficiencyText = String.valueOf((int)Efficiency);
        String FirstName = u.getFirstName();
        String LastName = u.getLastName();
        String Team = u.getTeam();
        if (Efficiency >= 0 && Efficiency < 10){
            EfficiencyText = " " + EfficiencyText;
        }
        PlayerName.setText(FirstName + " " + LastName);
        PlayerTeam.setText(Team);
        if (Captain == 1){
            CaptainOrNot.setText("TAIP");
        }
        else {
            CaptainOrNot.setText("NE");
        }
        if (!Tashkai.getText().equals(PointsText)){
            Tashkai.setText(PointsText);
        }

        if (!SuzhaistiZhaidimai.getText().equals(GamesPlayedText)){
            SuzhaistiZhaidimai.setText(GamesPlayedText);
        }
        if (!LaimetiZhaidimai.getText().equals(GamesWonText)){
            LaimetiZhaidimai.setText(GamesWonText);
        }
        if (!LaikoPrazhaista.getText().equals(PlaytimeText)){
            LaikoPrazhaista.setText(PlaytimeText);
        }
        if (!RezultatyvusPerdavimai.getText().equals(AssistsText)){
            RezultatyvusPerdavimai.setText(AssistsText);
        }
        if (!AtkovotiKamuoliai.getText().equals(ReboundsText)){
            AtkovotiKamuoliai.setText(ReboundsText);
        }
        if (!GynybojeAtkovotiKamuoliai.getText().equals(DReboundsText)){
            GynybojeAtkovotiKamuoliai.setText(DReboundsText);
        }
        if (!AtakojeAtkovotiKamuoliai.getText().equals(OReboundsText)){
            AtakojeAtkovotiKamuoliai.setText(OReboundsText);
        }

        if (!AtliktosPrazhangos.getText().equals(PersonalFoulsText)){
            AtliktosPrazhangos.setText(PersonalFoulsText);
        }
        if (!PrarastiKamuoliai.getText().equals(TurnoversText)){
            PrarastiKamuoliai.setText(TurnoversText);
        }
        if (!PerimtiKamuoliai.getText().equals(StealsText)){
            PerimtiKamuoliai.setText(StealsText);
        }
        if (!BlokuotiMetimai.getText().equals(BlocksText)){
            BlokuotiMetimai.setText(BlocksText);
        }
        if (!NaudingumoTashkai.getText().equals(EfficiencyText)){
            NaudingumoTashkai.setText(EfficiencyText);
        }
        if (!VienoMesti.getText().equals(OnePointShotText)){
            VienoMesti.setText(OnePointShotText);
        }
        if (!VienoPelnyti.getText().equals(OnePointScoredText)){
            VienoPelnyti.setText(OnePointScoredText);
        }
        if (!VienoVidurkis.getText().equals(OnePointAccuracyText)){
            VienoVidurkis.setText(OnePointAccuracyText + " %");
        }
        if (!DviejuMesti.getText().equals(TwoPointsShotText)){
            DviejuMesti.setText(TwoPointsShotText);
        }
        if (!DviejuPelnyti.getText().equals(TwoPointsScoredText)){
            DviejuPelnyti.setText(TwoPointsScoredText);
        }
        if (!DviejuVidurkis.getText().equals(TwoPointsAccuracyText)){
            DviejuVidurkis.setText(TwoPointsAccuracyText + " %");
        }
        if (!BauduMesti.getText().equals(FreeThrowsShotText)){
            BauduMesti.setText(FreeThrowsShotText);
        }
        if (!BauduPelnyti.getText().equals(FreeThrowsScoredText)){
            BauduPelnyti.setText(FreeThrowsScoredText);
        }
        if (!BauduVidurkis.getText().equals(FreeThrowsAccuracyText)){
            BauduVidurkis.setText(FreeThrowsAccuracyText + " %");

        }
        if (checkIfMVP(u)){
            MVPBadge.setOpacity(1);
        }
        if (getMostAssistsPlayer().equalsIgnoreCase(FullName)){
            preparedAKA = preparedAKA + "\"Strategas\" " + " ";
        }
        if (getMostReboundsPlayer().equalsIgnoreCase(FullName)){
            preparedAKA = preparedAKA + "\"Ilgauskas\" " + " ";
        }
        if (getMostBlocksPlayer().equalsIgnoreCase(FullName)){
            preparedAKA = preparedAKA + "\"Stogas\" " + " ";
        }
        if (getMostPersonalFoulsPlayer().equalsIgnoreCase(FullName)){
            preparedAKA = preparedAKA + "\"Baudėjas\" " + " ";
        }
        if (getMostPointsPlayer().equalsIgnoreCase(FullName)){
            preparedAKA = preparedAKA + "\"G.O.A.T\" " + " ";
        }
        if (getMostStealsPlayer().equalsIgnoreCase(FullName)){
            preparedAKA = preparedAKA + "\"Kamuolių magnetas\" " + " ";
        }
        if (getMostFreeThrowsScoredPlayer().equalsIgnoreCase(FullName)){
            preparedAKA = preparedAKA + "\"Javtoko svajonė\" " + " ";
        }
        if (getMostTwoPointsScoredPlayer().equalsIgnoreCase(FullName)){
            preparedAKA = preparedAKA + "\"Snaiperis\" " + " ";
        }
        if (getMostOnePointScoredPlayer().equalsIgnoreCase(FullName)){
            preparedAKA = preparedAKA + "\"Realizuotojas\" " + " ";
        }

        AKA.setText(preparedAKA);


        n++;

    }




    }
    public void ComebackToAfterLogin (ActionEvent e)throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterLogin.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void HidePopUps (MouseEvent e){

    
         
           PelnytiRect.setOpacity(0);
         
           PelnytiText.setOpacity(0);
         
           SuzhaistiRect.setOpacity(0);
         
           SuzhaistiText.setOpacity(0);
         
           LaimetiRect.setOpacity(0);
         
           LaimetiText.setOpacity(0);
         
           LaikasRect.setOpacity(0);
         
           LaikasText.setOpacity(0);
         
           RezultatyvusRect.setOpacity(0);
         
           RezultatyvusText.setOpacity(0);
         
           AtkovotiRect.setOpacity(0);
         
           AtkovotiText.setOpacity(0);
         
           AtkovotiGynRect.setOpacity(0);
         
           AtkovotiGynText.setOpacity(0);
         
           AtkovotiPuolimRect.setOpacity(0);
         
           AtkovotiPuolimText.setOpacity(0);
         
           PrarastiRect.setOpacity(0);
         
           PrarastiText.setOpacity(0);
         
           BlokuotiRect.setOpacity(0);
         
           BlokuotiText.setOpacity(0);
         
           AsmeninesRect.setOpacity(0);
         
           AsmeninesText.setOpacity(0);
         
           PerimtiRect.setOpacity(0);
         
           PerimtiText.setOpacity(0);

           NaudingumoRect.setOpacity(0);

           NaudingumoText.setOpacity(0);
    
    }

    public void ShowPelnyti (MouseEvent e){



        PelnytiRect.setOpacity(0.9);

        PelnytiText.setOpacity(0.9);

        
    }
    public void ShowSuzhaisti (MouseEvent e){



        SuzhaistiRect.setOpacity(0.9);

        SuzhaistiText.setOpacity(0.9);


    }
    public void ShowLaimeti (MouseEvent e){



        LaimetiRect.setOpacity(0.9);

        LaimetiText.setOpacity(0.9);


    }
    public void ShowLaikas (MouseEvent e){



        LaikasRect.setOpacity(0.9);

        LaikasText.setOpacity(0.9);


    }
    public void ShowRezultatyvus (MouseEvent e){


        RezultatyvusRect.setOpacity(0.9);

        RezultatyvusText.setOpacity(0.9);


    }
    public void ShowAtkovoti (MouseEvent e){



        AtkovotiRect.setOpacity(0.9);

        AtkovotiText.setOpacity(0.9);


    }
    public void ShowAtkovotiGyn (MouseEvent e){



        AtkovotiGynRect.setOpacity(0.9);

        AtkovotiGynText.setOpacity(0.9);


    }
    public void ShowAtkovotiPuolim (MouseEvent e){



        AtkovotiPuolimRect.setOpacity(0.9);

        AtkovotiPuolimText.setOpacity(0.9);


    }
    public void ShowPrarasti (MouseEvent e) {



        PrarastiRect.setOpacity(0.9);

        PrarastiText.setOpacity(0.9);


    }
    public void ShowBlokuoti (MouseEvent e){



        BlokuotiRect.setOpacity(0.9);

        BlokuotiText.setOpacity(0.9);


    }
    public void ShowAsmenines (MouseEvent e){



        AsmeninesRect.setOpacity(0.9);

        AsmeninesText.setOpacity(0.9);


    }
    public void ShowPerimti (MouseEvent e){



        PerimtiRect.setOpacity(0.9);

        PerimtiText.setOpacity(0.9);


    }
    public void ShowNaudingumas (MouseEvent e){



        NaudingumoRect.setOpacity(0.9);

        NaudingumoText.setOpacity(0.9);


    }
    @FXML
    public boolean checkIfMVP (User u){

        boolean correct = true;

        String FirstName = u.getFirstName();
        String LastName = u.getLastName();
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
        if (FirstName.equalsIgnoreCase(FirstNameAns) && LastName.equalsIgnoreCase(LastNameAns)){
            correct = true;
        }
        else {
            correct = false;
        }

        return correct;

    }

    @FXML
    public void SendEff (MouseEvent event) {
    if (c == 0){
        String eff = NaudingumoTashkai.getText();

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        User u = (User) stage.getUserData();
        String email = u.getEmail();
        try {
            String SQL = ( "UPDATE [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                    "SET [Efficiency] = " +eff+"\n" +
                    "WHERE Username = '" + email + "';");
            CreateStatement().execute(SQL);




        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        c++;
    }




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

        return FirstNameAns + " " + LastNameAns;

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
}

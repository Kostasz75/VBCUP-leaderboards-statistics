package com.example.login;


import java.sql.*;



public class User {
    private int id;
    private String email;
    private String password;
    private int Points;
    private int GamesPlayed;
    private int GamesWon;
    private int Playtime;
    private int Assists;
    private int Rebounds;
    private int ORebounds;
    private int DRebounds;
    private int TwoPointsShot;
    private int TwoPointsScored;
    private int OnePointShot;
    private int OnePointScored;
    private int Captain;
    private int PersonalFouls;
    private int FreeThrowsScored;
    private int FreeThrowsShot;
    private int Turnovers;
    private int Steals;
    private int Blocks;
    private String FirstName;
    private String LastName;
    private String Team;
    private double Efficiency;



    public User(int id, String email, String password, int Points,
                int GamesPlayed, int GamesWon, int Playtime, int Assists, int Rebounds,
                int ORebounds, int DRebounds, int TwoPointsShot, int TwoPointsScored,
                int OnePointShot, int OnePointScored, int Captain, int PersonalFouls,
                int FreeThrowsScored, int FreeThrowsShot, int Turnovers, int Steals,
                int Blocks, String FirstName, String LastName, String Team, double Efficiency){


        this.email = email;
        this.id = id;
        this.password = password;
        this.Points = Points;
        this.GamesPlayed = GamesPlayed;
        this.GamesWon = GamesWon;
        this.Playtime = Playtime;
        this.Assists = Assists;
        this.Rebounds = Rebounds;
        this.ORebounds = ORebounds;
        this.DRebounds = DRebounds;
        this.TwoPointsShot = TwoPointsShot;
        this.TwoPointsScored = TwoPointsScored;
        this.OnePointShot = OnePointShot;
        this.OnePointScored = OnePointScored;
        this.Captain = Captain;
        this.PersonalFouls = PersonalFouls;
        this.FreeThrowsScored = FreeThrowsScored;
        this.FreeThrowsShot = FreeThrowsShot;
        this.Turnovers = Turnovers;
        this.Steals = Steals;
        this.Blocks = Blocks;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Team = Team;
        this.Efficiency = Efficiency;

    }
    public User(String email){
        this.email = email;
    }
 
    public String getEmail(){
        return email;
    }
    public int getID(){
        int ans = 0;
        try {
            String SQL = ("SELECT Id FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getPoints (){

        
        int ans = 0;
        try {
            String SQL = ("SELECT Points FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getGamesPlayed (){
        
        
        int ans = 0;
        try {
            String SQL = ("SELECT Gamesplayed FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getGamesWon (){
        
        int ans = 0;
        try {
            String SQL = ("SELECT Gameswon FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getPlaytime (){
        
        int ans = 0;
        try {
            String SQL = ("SELECT Playtime FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getAssists (){
        
        int ans = 0;
        try {
            String SQL = ("SELECT Assists FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getRebounds (){
        
        int ans = 0;
        try {
            String SQL = ("SELECT Rebounds FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getORebounds (){
        
        int ans = 0;
        try {
            String SQL = ("SELECT ORebounds FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getDRebounds (){
        
        int ans = 0;
        try {
            String SQL = ("SELECT DRebounds FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getTwoPointsShot (){
        
        int ans = 0;
        try {
            String SQL = ("SELECT TwoPointsShot FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getTwoPointsScored (){
        
        int ans = 0;
        try {
            String SQL = ("SELECT TwoPointsScored FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getOnePointShot (){
        
        int ans = 0;
        try {
            String SQL = ("SELECT OnePointShot FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getOnePointScored (){
        
        int ans = 0;
        try {

            String SQL = ("SELECT OnePointScored FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getCaptain() {
        
        int ans = 0;
        try {
            String SQL = ("SELECT Captain FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getPersonalFouls() {

        
        int ans = 0;
        try {
            String SQL = ("SELECT PersonalFouls FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getFreeThrowsScored() {

        
        int ans = 0;
        try {
            String SQL = ("SELECT FreeThrowsScored FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getFreeThrowsShot() {

        
        int ans = 0;
        try {
            String SQL = ("SELECT FreeThrowsShot FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getTurnovers() {

        
        int ans = 0;
        try {
            String SQL = ("SELECT Turnovers FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public int getSteals() {

        
        int ans = 0;
        try {
            String SQL = ("SELECT Steals FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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

    public int getBlocks() {

        
        int ans = 0;
        try {
            String SQL = ("SELECT Blocks FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
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
    public String getFirstName() {

        
        String ans = "";
        try {
            String SQL = ("SELECT FirstName FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
            ResultSet rs = CreateStatement().executeQuery(SQL);
             
            while (rs.next()){
                ans = rs.getString(1);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ans;
    }
    public String getLastName() {

        
        String ans = "";
        try {
            String SQL = ("SELECT LastName FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
            ResultSet rs = CreateStatement().executeQuery(SQL);
             
            while (rs.next()){
                ans = rs.getString(1);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ans;
    }
    public String getTeam() {


        String ans = "";
        try {
            String SQL = ("SELECT Team FROM [aplikacija].[dbo].[VBCUP_TABLE1]  WHERE Username='" + email + "'");
            ResultSet rs = CreateStatement().executeQuery(SQL);
             
            while (rs.next()){
                ans = rs.getString(1);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ans;
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

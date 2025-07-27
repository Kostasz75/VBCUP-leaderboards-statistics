package com.example.login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;



public class RegisterController{

@FXML
private Stage stage;
@FXML
private Scene scene;
@FXML
public PasswordField Password;
@FXML
public TextField RegEmail;
@FXML
public TextField LogEmail;
@FXML
public Text Message;
@FXML
public Rectangle Rectangle;
@FXML
public Text PasswordRequirements;
@FXML
public Rectangle PasswordRequirementsRectangle;
@FXML
public Polygon PasswordsRequirementsTriangle;
@FXML
public TextField Vardas;
@FXML
public TextField Pavarde;






@FXML
    public void register(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void login (ActionEvent e)throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private void sendData(MouseEvent event) {

    String Gmail = LogEmail.getText();
        User u = new User(Gmail);

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        try {
            // Step 4
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));

            stage.setUserData(u);

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));

        }
    }


    public void loginSubmit(ActionEvent e) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        String email = LogEmail.getText();
        User u = new User(email);

        Node node = (Node) e.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        int n = 0;

        String password = Password.getText();
        boolean right = DuplicateEmailChecker(email);
        if (right){
            n++;

        }
        boolean rightt = DuplicateHashedPasswordChecker(password, passwordHashing(password), email);
        if (rightt){
            n++;
        }
        if (n == 2){

            try {

                 Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterLogin.fxml")));
                 stage.setUserData(u);
                 scene = new Scene(root);
                 stage.setScene(scene);
                 stage.show();
            } catch (IOException er) {
                System.err.println(String.format("Error: %s", er.getMessage()));

            }


        }
        if (n < 2){

            String text = "Neteisingas El.pašto adresas/slaptažodis";
            Message.setText(text);
            Rectangle.setFill(Color.RED);
            Rectangle.setOpacity(1);

        }
    }



    public void comeback (ActionEvent e)throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choice.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void passwordRequirements (ActionEvent e){

    String requirements = "Slaptažodis privalo:\n" +
            "-Turėti bent vieną didžiają raidę\n" +
            "-Turėti bent du skaitmenis\n" +
            "-Susidaryti iš nemažiau kaip 8 simbolių\n" +
            "-Susidaryti tik iš raidžių ir skaitmenų";
    PasswordRequirements.setText(requirements);
    PasswordsRequirementsTriangle.setOpacity(0.75);
    PasswordRequirementsRectangle.setOpacity(0.75);


    }
    @FXML
    public void registerSubmit (ActionEvent e){
        Message.setText(" ");
        Rectangle.setOpacity(0);


        String email = RegEmail.getText();
        String password = Password.getText();
        String firstName = Vardas.getText();
        String lastName = Pavarde.getText();

        boolean firstNameChecker = checkIfNamesFirstLetterIsUpperCase(firstName);
        boolean lastNameChecker = checkIfNamesFirstLetterIsUpperCase(lastName);
        boolean bothNamesChecker = firstNameChecker && lastNameChecker;
        System.out.println(bothNamesChecker);

        if (!bothNamesChecker){
            String text = "Vardas ir pavardė turi prasidėti iš didžiosios raidės.";
            Message.setText(text);
            Rectangle.setFill(Color.RED);
            Rectangle.setOpacity(1);
        }
        boolean right = DuplicateEmailChecker(email);
        if (right) {
            String text = "Jau yra sukurta paskyra su šiuo El.pašto adresu.";
            Message.setText(text);
            Rectangle.setFill(Color.RED);
            Rectangle.setOpacity(1);

        }
        boolean correct = checkEmail(email);
        int size = passwordLength(password);
        boolean LettersAndDigits = onlyLettersAndDigits(password, size);
        boolean NumberOfDigits = checkNumberOfDigits(password, size);
        boolean MustBeEight = checkSize(size);
        boolean Four = false;
        if (LettersAndDigits && NumberOfDigits && MustBeEight && checkIfPasswordIsUpperCase(password)){
            Four = true;
        }
        if (!right && correct && Four && bothNamesChecker) {


            String text = "Sėkmingai prisiregistravote :)";
            Message.setText(text);
            Rectangle.setFill(Color.GREEN);
            Rectangle.setOpacity(1);

            boolean c = true;

            try {

                String SQL = ("\n" +
                        "INSERT INTO [aplikacija].[dbo].[VBCUP_TABLE1] \n" +
                        "   ([Id], [Username], [Password], [Points], [Gamesplayed], [Gameswon], [Playtime], [Assists], [Rebounds], [ORebounds], [DRebounds], [TwoPointsShot], [TwoPointsScored], [OnePointShot], [OnePointScored], [Captain], [PersonalFouls], [FreeThrowsScored], [FreeThrowsShot], [Turnovers], [Steals], [Blocks], [Team], [FirstName], [LastName], [Efficiency])\n" +
                        "VALUES\n" +
                        "   ("+ getHighestID() + ", '" + email + "', '" + passwordHashing(password) + "', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "+ "'Komanda', "+  "'" + firstName + "', '"  + lastName + "'" + ", 0) ");
                boolean b = CreateStatement().execute(SQL);




            }
            catch (Exception ex){
                ex.printStackTrace();
            }



        }
        if (correct && !Four){
            String text = "Netinkamas slaptažodis, paspauskite slaptažodžių reikalavimų mygtuką";
            Message.setText(text);
            Rectangle.setFill(Color.RED);
            Rectangle.setOpacity(1);
        }
        if(!correct && Four){
            String text = "Netinkamas El.pašto adresas";
            Message.setText(text);
            Rectangle.setFill(Color.RED);
            Rectangle.setOpacity(1);
        }
        if(!correct && !Four){
            String text = "Netinkamas El.pašto adresas ir slaptažodis";
            Message.setText(text);
            Rectangle.setFill(Color.RED);
            Rectangle.setOpacity(1);
        }


    }



   private static int passwordLength (String password){
        return password.length();
    }
    private String passwordHashing (String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
    int n = 0;
    String hashedPassword = "";
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String encodedHash = Base64.getEncoder().encodeToString(hash);
        hashedPassword = encodedSalt + ":" + encodedHash;
        return hashedPassword;
    }

   private static boolean onlyLettersAndDigits (String password, int size){
        int n = 0;
        int count = 0;
        boolean c = true;
        while (n < size){
            char k = password.charAt(n);

            if (k == '0' || k == '1' || k == '2' || k == '3' || k == '4' || k == '5' || k == '6' || k == '7' || k == '8' || k == '9'){
                count++;
            }
            if ((int) k > 64 && (int) k < 91 || (int) k > 96 && (int) k < 122){
                count++;


            }

            n++;
        }
        if (count != size){
            c = false;
        }
        else {
            c = true;
        }
        return c;

    }
    private int getHighestID() {
        int ans = 0;
        int count = 0;

        try {

            //getting the id of last registered user
            String SQL = ("SELECT [Id], MAX (Id) \n" +
                    "FROM [aplikacija].[dbo].[VBCUP_TABLE1]\n" +
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
        System.out.println(ans);


        return ans + 1;
    }
    private static boolean checkIfNamesFirstLetterIsUpperCase (String name){

    boolean correct = true;

    if ((int)name.charAt(0) >= 65 && (int)name.charAt(0) <= 90 || (int)name.charAt(0) >= 181 && (int)name.charAt(0) <= 184 || (int)name.charAt(0) == 189 || (int)name.charAt(0) == 190 || (int)name.charAt(0) == 198 || (int)name.charAt(0) == 199 || (int)name.charAt(0) == 207 || (int)name.charAt(0) == 'Ž' || (int)name.charAt(0) == 'Č' || (int)name.charAt(0) == 'Į'){
        correct = true;
    }
    else {
        correct = false;
    }

    return correct;
    }
    private static boolean checkNumberOfDigits (String password, int size){
        int n = 0;
        int count = 0;
        boolean c = false;

        while (n < size){
            char k = password.charAt(n);
            if (k == '1' || k == '2' || k == '3' || k == '4' || k == '5' || k == '6' || k == '7' || k == '8' || k == '9') {
                count++;

            }
            n++;
        }
        if (count < 2){
            c = false;
        }
        if (count >= 2) {
            c = true;
        }

        return c;

    }

   private static boolean checkSize (int size){
        boolean c = true;
        if (size >= 8){
            c = true;
        }
        else {
            c = false;
        }

        return c;
    }

   private static boolean checkEmail (String email){
        int x = email.indexOf("@");
        if (x == -1){
            return false;
        }
        else {
            return true;
        }

    }

    private boolean DuplicateEmailChecker (String email){

    boolean c = true;


        try {
            String SQL = ("SELECT * FROM [aplikacija].[dbo].[VBCUP_TABLE1] WHERE Username='" + email + "'");
            ResultSet rs = CreateStatement().executeQuery(SQL);



            if (rs.isBeforeFirst()){
                c = true;

            }
            else{
                c = false;

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }


        return c;

    }




    private boolean usernameBelongsToPassword(String email, String password){
        boolean c = false;
        try {


            String SQL = "SELECT [Username] FROM [aplikacija].[dbo].[VBCUP_TABLE1] WHERE password='" + password + "'";
            ResultSet rs = CreateStatement().executeQuery(SQL);

            if (rs.next() && email.equals(rs.getString(1))){
                c = true;
            }
            else{
                c = false;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return c;
    }
    private boolean DuplicateHashedPasswordChecker(String password, String hashedPassword, String email) throws InvalidKeySpecException, NoSuchAlgorithmException {

   if(usernameBelongsToPassword(email, hashedPassword));{
            String[] parts = hashedPassword.split(":");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid hashed password format");
            }
            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] expectedHash = Base64.getDecoder().decode(parts[1]);
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] actualHash = factory.generateSecret(spec).getEncoded();
            return Arrays.equals(expectedHash, actualHash);
        }



    }
   private static boolean checkIfPasswordIsUpperCase (String password){

        boolean correct = false;

        int size = password.length();
        int n = 0;
        int count = 0;

            while (n < size) {
                if ((int) password.charAt(n) >= 65 && (int) password.charAt(n) <= 90){
                    count++;
                }
                n++;
            }
            if (count > 0){
                correct = true;
            }
            else {
                correct = false;
            }



        return correct;
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
            String password = "Kostela777";
            connectionDB = DriverManager.getConnection(url, username, password);

        }
        catch(ClassNotFoundException ex){

            ex.printStackTrace();
        }
        return connectionDB;
    }

    }


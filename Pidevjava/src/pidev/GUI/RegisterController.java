package pidev.GUI;





import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.entities.user;
import pidev.utils.myconnexionpi;


public class RegisterController implements Initializable{
    
    Connection cn = myconnexionpi.getInstance().getConnection();
    String Admin = "ADMIN";
    String Client = "CLIENT";
    String Vendeur = "VENDEUR";
   

    @FXML
    private AnchorPane rootpane;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton registerButton;
    @FXML
    private JFXPasswordField rpassword;
    @FXML
    private JFXComboBox<String> roles;
    @FXML
    private JFXDatePicker birthday;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXButton loginButton;
    
    
    
    
    
    
    @FXML
    private void goToLoginAction(ActionEvent event){
 
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("souklemdinafinal/GUI/Login.fxml"));
            Scene scene = new Scene(root);
            stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }   
    }
    
    @FXML
    private void chooseFileAction(ActionEvent actionEvent) throws MalformedURLException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg")
        );
         
        File file = fileChooser.showOpenDialog(new Stage());
        if(file != null){
 
            String imageFile = file.toURI().toURL().toString();
            System.out.println(imageFile);
        }
    }
    
    
    @FXML
    private void resgiterAction(ActionEvent event) throws SQLException, FileNotFoundException, IOException{
        
        String recupererRole = roles.getValue();
        String role = "";
        if(recupererRole.contains("ADMIN")){
            role = "a:1:{i:0;s:10:\"ROLE_ADMIN\";}";
        }
        if(recupererRole.contains("CLIENT")){
            role =  "a:0:{}";
        }
        if(recupererRole.contains("VENDEUR")){
            role = "a:1:{i:0;s:25:\"VENDEUR\";}";
        }
        
        
        user user = new user();
        UserService uss = new UserService();
        boolean verif;
        
        if(uss.verifierUsername(username.getText()) == 0 && uss.verifierEmail(email.getText()) == 0 && email.getText().matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]{2,}\\.[a-z]{1,4}$")){
            
           
            
            String requete = "INSERT INTO fos_user (username,username_canonical,email,email_canonical,enabled,password,roles,nom,prenom,date_naissance,adresse,imgBlob) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(requete);

            st.setString(1, username.getText());
            st.setString(2, username.getText());
            st.setString(3, email.getText());
            st.setString(4, email.getText());
            st.setString(5, "1");
            st.setString(6, UserService.hashPassword(password.getText()));
            st.setString(7, role);
            st.setString(8, nom.getText());
            st.setString(9, prenom.getText());
            st.setString(10, String.valueOf(birthday.getValue()));
            st.setString(11, adresse.getText());
        
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            st.setBinaryStream(12, fis, (int)file.length());
            
            st.executeUpdate();
            
            System.out.println("Compte Creer");
            
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("souklemdinafinal/GUI/Login.fxml"));
            Scene scene = new Scene(root);
            stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
            
        }
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options = FXCollections.observableArrayList(
                Admin,
                Client,
                Vendeur
        );
        roles.setItems(options);
        
    }
    
    
    
    @FXML
    private void colorEmail(KeyEvent event) throws SQLException {
        System.out.println("12");
        UserService ss = new UserService();
        System.out.println(ss.verifierEmail(email.getText()));
        if( ss.verifierEmail(email.getText()) == 1 || !email.getText().matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]{2,}\\.[a-z]{1,4}$") ){
            email.setStyle("-fx-background-color: red");
        }
        else{
            email.setStyle("-fx-background-color: green");
        }
    }

    @FXML
    private void colorUsername(KeyEvent event) throws SQLException {
        UserService ss = new UserService();
        if( ss.verifierUsername(username.getText()) == 1 ){
            //when it not matches the pattern (1.0 - 6.0)
            //set the textField empty
            username.setStyle("-fx-background-color: red");
        }
        else{
            username.setStyle("-fx-background-color: green");
        }
    }

    @FXML
    private void checkPass(KeyEvent event) {
        if( (password.getText() == null ? rpassword.getText() == null : password.getText().equals(rpassword.getText())) ){
         rpassword.setStyle("-fx-background-color: green");
        }
        else{
         rpassword.setStyle("-fx-background-color: red");
        }
    }

}



/**
*@Lau82 © 2018
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pidev.entities.boutique;
import pidev.services.myservicespi;

/**
 * FXML Controller class
 *
 * @author MBM info
 */
public class AjoutboutiqueController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private TextField nombout;
    @FXML
    private TextField add;
    @FXML
    private TextField numtel;
    @FXML
    private TextField im;
    @FXML
    private Label nomlab;
    @FXML
    private Label adrlab;
    @FXML
    private Label numlab;
    @FXML
    private Label imlab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterBoutique(ActionEvent event) {
        boutique b =new boutique(nombout.getText(),numtel.getText(),add.getText(),im.getText());
        myservicespi sp=new myservicespi();
   sp.ajouterBoutique(b);}
    
//    FXMLLoader loader=new FXMLLoader(getClass().getResource("AffichageFXML.fxml"));
//    Parent root;
//        try {
//            root = loader.load();
//             AffichageFXMLController personneConroller=loader.getController();
//    personneConroller.setNomaff(Nom.getText());
//     personneConroller.setPrenomaff(Prenom.getText());
//     Nom.getScene().setRoot(root);
//    
//            
//        } catch (IOException ex) {
//            Logger.getLogger(WorkshopjavaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
}

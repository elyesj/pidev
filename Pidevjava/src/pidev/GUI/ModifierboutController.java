/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import static org.omg.CORBA.AnySeqHelper.id;
import pidev.entities.boutique;
import pidev.services.myservicespi;

/**
 * FXML Controller class
 *
 * @author MBM info
 */
public class ModifierboutController implements Initializable {

    @FXML
    private Button btnmod;
    @FXML
    private TextField nomboutmod;
    @FXML
    private TextField addmod;
    @FXML
    private TextField numtelmod;
    @FXML
    private TextField immod;
    @FXML
    private Label nomlab;
    @FXML
    private Label adrlab;
    @FXML
    private Label numlab;
    @FXML
    private Label imlab;
public int id1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierBoutique(ActionEvent event) {
   boutique b=new boutique();
        myservicespi sp=new myservicespi();
        b.setId(id1);
        b.setNombout(nomboutmod.getText());
                b.setAdresse(addmod.getText());

                        b.setNumtel(numtelmod.getText());
        b.setImage(immod.getText());
        int id = 0;

     sp.ModifierBoutique(b, id);
   
        
 }
    
}

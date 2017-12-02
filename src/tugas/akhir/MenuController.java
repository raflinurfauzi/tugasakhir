/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.akhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RAFLI NUR FAUZI P
 */
public class MenuController implements Initializable {

    @FXML
    private JFXTextField tempe;
    @FXML
    private JFXTextField tahu;
    @FXML
    private JFXTextField ayam;
    @FXML
    private JFXTextField telor;
    @FXML
    private JFXTextField lele;
    @FXML
    private JFXTextField jeroan;
    @FXML
    private JFXTextField teh;
    @FXML
    private JFXTextField jeruk;
    @FXML
    private JFXTextField blewah;
    @FXML
    private JFXTextField kopi;
    @FXML
    private JFXTextField josua;
    @FXML
    private JFXTextField ice;
    @FXML
    private JFXButton reset;
    @FXML
    private JFXButton bayar;

    int tempe1 = 0,tahu1 = 0,ayam1 = 0,telor1 = 0,lele1 = 0,jeroan1 = 0,teh1 = 0,jeruk1 = 0,blewah1 = 0,kopi1 = 0,josua1 = 0,ice1 = 0;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        // TODO
    }    

    @FXML
    private void reset(ActionEvent event) {
     tempe.setText("");
     tahu.setText("");
     ayam.setText("");
     telor.setText("");
     lele.setText("");
     jeroan.setText("");
     teh.setText("");
     jeruk.setText("");
     blewah.setText("");
     kopi.setText("");
     josua.setText("");
     ice.setText("");
        
     
    }

    @FXML
    private void bayar(ActionEvent event) {
       
            
        String Hmakanan = "";
        String Hminum = "";
        int tootal = 0;
        if(tempe.getText().equals("")){
            tempe1 = 0;
        }else{
            tempe1=Integer.parseInt(tempe.getText())*1000;
            Hmakanan +="Tempe         ="+tempe1+"\n";
            tootal +=tempe1;
        }
        
        if(tahu.getText().equals("")){
            tahu1 = 0;
        }else{
            tahu1=Integer.parseInt(tahu.getText())*1000;
            Hmakanan +="Tahu            ="+tahu1+"\n";
            tootal +=tahu1;
        }
        if(ayam.getText().equals("")){
            ayam1 = 0;
        }else{
            ayam1=Integer.parseInt(ayam.getText())*2500;
            Hmakanan +="Ayam           ="+ayam1+"\n";
            tootal +=ayam1;
        }
        if(telor.getText().equals("")){
            telor1 = 0;
        }else{
            telor1=Integer.parseInt(telor.getText())*1500;
            Hmakanan +="Telor            ="+telor1+"\n";
            tootal +=telor1;
        }
        if(lele.getText().equals("")){
            lele1 = 0;
        }else{
            lele1=Integer.parseInt(lele.getText())*3000;
            Hmakanan +="Lele              ="+lele1+"\n";
            tootal +=lele1;
        }
        if(jeroan.getText().equals("")){
            jeroan1 = 0;
        }else{
            jeroan1=Integer.parseInt(jeroan.getText())*1000;
            Hmakanan +="Jeroan         ="+jeroan1+"\n";
            tootal +=jeroan1;
        }
        if(teh.getText().equals("")){
            teh1 = 0;
        }else{
            teh1=Integer.parseInt(teh.getText())*2000;
            Hminum +="Es Teh         ="+teh1+"\n";
            tootal +=teh1;
        }
        if(jeruk.getText().equals("")){
            jeruk1 = 0;
        }else{
            jeruk1=Integer.parseInt(jeruk.getText())*2500;
            Hminum +="Es Jeruk      ="+jeruk1+"\n";
            tootal +=jeruk1;
        }
        if(blewah.getText().equals("")){
            blewah1 = 0;
        }else{
            blewah1=Integer.parseInt(blewah.getText())*3000;
            Hminum +="Es Blewah  ="+blewah1+"\n";
            tootal +=blewah1;
        }
        if(kopi.getText().equals("")){
            kopi1 = 0;
        }else{
            kopi1=Integer.parseInt(kopi.getText())*4000;
            Hminum +="Kopi            ="+kopi1+"\n";
            tootal +=kopi1;
        }
        if(josua.getText().equals("")){
            josua1 = 0;
        }else{
            josua1=Integer.parseInt(josua.getText())*5000;
            Hminum +="Es Josua     ="+josua1+"\n";
            tootal +=josua1;
        }
        if(ice.getText().equals("")){
            ice1 = 0;
        }else{
            ice1=Integer.parseInt(ice.getText())*5000;
            Hminum +="Pop Ice      ="+ice1+"\n";
            tootal +=ice1;
        }
        
        int bayar= tempe1+tahu1+ayam1+telor1+lele1+jeroan1+teh1+jeruk1+blewah1+kopi1+josua1+ice1;
        
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("nota.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("WARTEG");
            stage.show();
            
            NotaController nota = new NotaController();
            nota= fxmlLoader.getController();
            
            nota.databayar(Hmakanan,Hminum,tootal);
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }
    
}

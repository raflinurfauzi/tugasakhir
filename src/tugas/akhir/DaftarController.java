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
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RAFLI NUR FAUZI P
 */
public class DaftarController implements Initializable {

    @FXML
    private JFXTextField user1;
    @FXML
    private JFXTextField pass1;
    @FXML
    private JFXTextField lahir;
    @FXML
    private JFXButton buat;
    @FXML
    private JFXButton login1;
    @FXML
    private Label isi;

    /**
     *  the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buat(ActionEvent event) {
        String user = user1.getText();
        String p = pass1.getText();
        String lhr = lahir.getText();
        
        try{
            if(user1.getText().equals("")&&pass1.getText().equals("")&&lahir.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Lengkapi data anda");
            }else if(pass1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Lengkapi data anda");
            }else if(lahir.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Lengkapi data anda");
            }else if(user1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Lengkapi data anda");}
            else{
                try(Statement statement = (Statement) koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO admin VALUES ('"+user+"', '"+p+"','"+lhr+"')");
                isi.setText("Berhasil daftar");
        } catch (Exception ex) {
        }
    }}
        catch (Exception ex) {
        }}
    @FXML
    private void login1(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("WARTEG");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }
    
}

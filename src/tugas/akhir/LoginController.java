/*
 * To change this license header, choose Licen  se Headers in Project Properties.
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
import javafx.fxml.Initializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.control.Label;
/**
 * FXML Controller class
 *
 * @author RAFLI NUR FAUZI P
 */
public class LoginController implements Initializable {

 
    /**
     *  the controller class.admin  
     */
     @FXML
    private JFXTextField user;

    @FXML
    private JFXTextField pass;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnDaftar;

    @FXML
    private Label isinya2;
    
    @FXML
    void daftar(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("daftar.fxml"));
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

    @FXML
    void login(ActionEvent event) {
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ta? zeroDateTimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `admin` WHERE `user` = ? AND `password` = ?");
            ps.setString(1, user.getText());
            ps.setString(2, pass.getText());
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("WARTEG");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
            } else {
                isinya2.setText("SILAHKAN DAFTAR");
                pass.setText("");
                user.requestFocus();
            }
        } catch (SQLException ex) {
            isinya2.setText("SILAHKAN DAFTAR");
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    
    
}

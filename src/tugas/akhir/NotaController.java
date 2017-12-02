/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.akhir;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RAFLI NUR FAUZI P
 */
public class NotaController implements Initializable {

    @FXML
    private TextArea nota;
    @FXML
    private Button kembali;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private TextArea nota2;

    @FXML
    private Label total;

    @FXML
    void btnkembali(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader=new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("Menu.fxml"));
                        Scene scene=new Scene(fxmlLoader.load(),600,400);
                        Stage stage= new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Menu");
                        stage.show();
    }
    
    public void databayar(String Bmakanan,String Bminuman, int totall){
        nota.setText(Bmakanan);
        nota2.setText(Bminuman);
        total.setText(String.valueOf(totall));
    }

    private void Stage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

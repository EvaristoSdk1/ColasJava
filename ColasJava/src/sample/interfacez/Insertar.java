package sample.interfacez;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Cola;
import sample.Nodo;

import java.net.URL;
import java.util.ResourceBundle;

public class Insertar implements Initializable{

    @FXML TextField txtRango;
    @FXML Button btnContinuar;

    Cola cola = new Cola();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnContinuar.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int rango = Integer.parseInt(txtRango.getText());
                for (int i =0; i < rango; i++){

                }
            }
        });
    }
}

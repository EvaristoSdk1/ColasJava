package sample.interfacez;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Cola;
import sample.Controller;
import sample.Nodo;

import java.net.URL;
import java.util.ResourceBundle;

public class DatosController implements Initializable{

    @FXML TextField txtDatos;
    @FXML Button btnSiguienteNumero;

    int valor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Controller controller = new Controller();
        btnSiguienteNumero.setOnAction(new javafx.event.EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                valor = Integer.parseInt(txtDatos.getText());
                controller.insertar(valor);
                txtDatos.setText("");

                controller.mostrar();

            }
        });
    }

}

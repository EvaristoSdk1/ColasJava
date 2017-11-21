package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sample.interfacez.Insertar;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    Cola cola = new Cola();

    @FXML ComboBox listaMenu;
    @FXML Button continuarBtn;
    @FXML ListView <Integer> listElementos;
    @FXML Label lblDatos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.listaMenu.getItems().addAll("Insertar Elementos","Mostrar elementos", "Buscar elemento", "Extraer elemento"
        ,"Obtener tamano de la cola", "Vaciar la cola");

        //listaMenu.getSelectionModel().select(0);
        listaMenu.setOnAction(event -> {
            String value = (String) listaMenu.getValue();
            switch (value) {
                case "Insertar Elementos":

                    cola.insertar(1);
                    cola.insertar(2);
                    cola.insertar(3);
                    cola.insertar(4);
                    cola.insertar(5);
                    cola.insertar(6);


                    break;
                case "Mostrar elementos":


                    cola.mostrar();

                    break;
                case "Buscar elemento":
                    System.out.println("opcion1");
                    break;
                case "Extraer elemento":
                    System.out.println("opcion1");
                    break;
                case "Obtener tamano de la cola":
                    System.out.println("opcion1");
                    break;
                case "Vaciar la cola":
                    System.out.println("opcion1");
                    break;
                default: break;
            }
        });

    }


}

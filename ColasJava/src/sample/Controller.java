package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sample.interfacez.DatosController;
import javax.swing.JOptionPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private Nodo frente;//el inicio de la cola

    @FXML ComboBox listaMenu;
    @FXML ListView <Integer> list;
    @FXML Label lblDatos;

    public Controller() {
        this.frente = null;
    }

    MostrarVentanas mostrarVentanas = new MostrarVentanas();
    DatosController datosController = new DatosController();

    ObservableList<Integer> items1 =FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        this.listaMenu.getItems().addAll("Insertar Elementos","Mostrar elementos", "Buscar elemento", "Extraer elemento"
                                                    ,"Obtener tamano de la cola", "Vaciar la cola");

        //listaMenu.getSelectionModel().select(0);
        listaMenu.setOnAction(event -> {
            String value = (String) listaMenu.getValue();
            switch (value) {
                case "Insertar Elementos":

                    int rango = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tamano de elementos de la cola"));
                    for (int i = 0; i < rango; i++){
                        int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrse un valor"));
                        insertar(valor);
                    }

                    break;
                case "Mostrar elementos":

                    mostrar();
                    break;
                case "Buscar elemento":

                    int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar el valor a buscar"));
                    buscar(buscar);
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

    //Método para insertar siguiente elemento (nodo), el elemento debe colocarse detrás del último nodo
    public void insertar(int valor){
        Nodo nuevo = new Nodo(valor);

        if(frente == null){
            frente = nuevo;
        }else{
            Nodo temp = frente;
            while(temp.getProximo() != null){
                temp = temp.getProximo();
            }
            temp.setProximo(nuevo);
        }
    }


    public void buscar(int busqueda) {

        try {
            Nodo temp = frente;
            int posicion = 1;

            if (temp.getValor() == busqueda) {
                System.out.println("El valor esta en la posición 0");
            } else {
                while (temp != null) {
                    if (temp.getProximo().getValor() == busqueda) {

                        System.out.println("valor en la posicion:" + posicion);

                        break;
                    }
                    posicion++;
                    temp = temp.getProximo();
                }}
        }
        catch (Exception ex)
        {
            System.out.println("El elemento no se encuentra");
        }
    }

    public void mostrar(){

        if( frente != null){
            Nodo temp = frente;
            System.out.println("Los valores de la cola son: ");

            while(temp != null){

                System.out.println(temp.getValor());
                items1.addAll(temp.getValor());
                temp = temp.getProximo();
            }

            list.setItems(items1);

        }else{
            System.out.println("La cola está vacía.");
        }
    }

}

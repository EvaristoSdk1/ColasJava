package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javax.swing.JOptionPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private Nodo frente;//el inicio de la cola

    @FXML ComboBox listaMenu;
    @FXML ListView <Integer> list;

    public Controller() {
        this.frente = null;
    }

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

                    if  (frente == null){
                        int rango = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tamano de elementos de la cola"));
                        for (int i = 0; i < rango; i++){
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrse un valor"));
                            insertar(valor);
                        }
                    }else{
                        int rango = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tamano de elementos de la cola"));
                        for (int i = 0; i < rango; i++){
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrse un valor"));
                            insertar(valor);
                        }

                        items1.clear();
                        list.setItems(items1);
                        mostrar();

                    }
                    listaMenu.getSelectionModel().clearSelection();
                    break;
                case "Mostrar elementos":
                    mostrar();
                    listaMenu.getSelectionModel().clearSelection();
                    break;
                case "Buscar elemento":

                    int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar el valor a buscar"));
                    buscar(buscar);
                    listaMenu.getSelectionModel().clearSelection();
                    break;
                case "Extraer elemento":
                    //int extraerNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar el valor a extraer de la cola"));
                    items1.clear();
                    list.setItems(items1);
                    extraer();
                    mostrar();
                    listaMenu.getSelectionModel().clearSelection();
                    break;
                case "Obtener tamano de la cola":
                    JOptionPane.showMessageDialog(null,"El tamano de la cola es: " + tamano());
                    listaMenu.getSelectionModel().clearSelection();
                    break;
                case "Vaciar la cola":
                    borrarElementos();
                    listaMenu.getSelectionModel().clearSelection();
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
                JOptionPane.showMessageDialog(null,"El valor esta en la posición 0");
            } else {
                while (temp != null) {
                    if (temp.getProximo().getValor() == busqueda) {

                        JOptionPane.showMessageDialog(null,"valor en la posicion:" + posicion);

                        break;
                    }
                    posicion++;
                    temp = temp.getProximo();
                }}
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,"El elemento no se encuentra");
        }
    }

    public void mostrar(){

        if( frente != null){
            Nodo temp = frente;

            while(temp != null){
                items1.addAll(temp.getValor());
                temp = temp.getProximo();
            }

            list.setItems(items1);

        }else{
            JOptionPane.showMessageDialog(null,"La cola está vacía.");
        }
    }

    public int extraer(){
        if(frente == null){
            return 0;
        }else{
            int valorExtraer = frente.getValor(); //variable temporal
            JOptionPane.showMessageDialog(null,"Valor extraído: "+ frente.getValor());
            frente = frente.getProximo(); //cambiar el frente por el siguiente
            return valorExtraer ; //devolver el valor extraído de la cola
        }
    }

    public void borrarElementos(){
        if(vacia() == true){
            JOptionPane.showMessageDialog(null,"La cola ya esta vacia");
        }else{
            while(vacia() == false){
                frente.getValor();
                frente = frente.getProximo();
            }
            items1.clear();
            list.setItems(items1);
            mostrar();
            JOptionPane.showMessageDialog(null,"La elementos de la cola han sido eliminados");
        }
    }

    public int tamano (){
        Nodo aux = null;
        int i=0;
        aux = frente;
        while(aux != null){
            aux = aux.getProximo();
            i++;
        }
        return i;
    }

    public boolean vacia (){
        return ( frente == null);
    }

}

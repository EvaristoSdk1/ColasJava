package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Aplicacion Colas en Java");
        primaryStage.setScene(new Scene(root, 501, 354));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

        Cola cola = new Cola();

        cola.insertar(1);
        cola.insertar(2);
        cola.insertar(3);
        cola.insertar(4);
        cola.insertar(5);
        cola.insertar(6);
        cola.mostrar();
        cola.extraer();
        cola.mostrar();
        cola.extraer();
        cola.mostrar();
        cola.buscar(4);
        System.out.println("El tamano de la cola es: " + cola.tamano());

        if (!cola.vacia()){
            System.out.println("La cola no esta vacia");
        }else{
            System.out.println("La cola esta vacia");
        }

    }
}

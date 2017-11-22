package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.interfacez.DatosController;

import java.io.IOException;

/**
 * Created by UchihaMadara on 22/11/2017 0022.
 */
public class MostrarVentanas {

    public void clickShow2() {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(
                    DatosController.class.getResource("datos.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.setTitle("My modal window");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
}

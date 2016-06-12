package presentacion.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;
import presentacion.control.ControladorCasoDeUso;


public class ControladorConfiguracion extends ControladorCasoDeUso {

   

    @FXML
    private Button AñadirDirector;

    @FXML
    private Button AñadirPelicula;

    @FXML
    private Button AñadirUsuario;

    @FXML
    private Button AñadirGenero;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Configuracion");
    }
}

package presentacion.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;
import presentacion.control.ControladorCasoDeUso;


public class ControladorAdministracion extends ControladorCasoDeUso {

    private static final String MENU_CREAR_PELICULA = "/presentacion/vista/CrearPelicula.fxml";
    private static final String MENU_CREAR_GENERO = "/presentacion/vista/CrearGenero.fxml";

    @FXML
    private Stage primaryStage;

    @FXML
    private Button anadirUsuario;

    @FXML
    private Button anadirPelicula;

    @FXML
    private Button anadirGenero;

    @FXML
    private Button anadirDirector;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Configuracion");

        anadirPelicula.setOnMouseClicked(event -> initCasoDeUso(MENU_CREAR_PELICULA, ControladorCrearPelicula.class).show());
        anadirGenero.setOnMouseClicked(event -> initCasoDeUso(MENU_CREAR_GENERO, ControladorCrearGenero.class).show());
    }

    private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass) {
        return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass, primaryStage, this);
    }

}

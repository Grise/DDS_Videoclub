package presentacion.vista;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import presentacion.control.ControladorCasoDeUso;

public class ControladorPrincipal {
    private static final String PERSON_OVERVIEW = "../vista/MenuPrincipalEmpleado.fxml";

    private Stage primaryStage;

    @FXML
    void setPersonOverview(ActionEvent event) {
        initCasoDeUso(PERSON_OVERVIEW, ControladorMenuPrincipalEmpleado.class).show();
    }

    @FXML
    void salir(ActionEvent event) {
        Platform.exit();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass) {
        return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass, primaryStage, ControladorPrincipal.this);
    }
}

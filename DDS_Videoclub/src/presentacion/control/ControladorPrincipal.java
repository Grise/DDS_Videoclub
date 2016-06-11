package presentacion.control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ControladorPrincipal {
    private static final String MENU_EMPLEADO = "../vista/MenuPrincipalEmpleado.fxml";
    private static final String MENU_RESERVA = "../vista/CrearReserva.fxml";
    private static final String MENU_RESERVA_PELICULA = "../vista/CrearReservaPelicula.fxml";
    private Stage primaryStage;

    @FXML
    void setPersonOverview(ActionEvent event) {
        initCasoDeUso(MENU_EMPLEADO, ControladorMenuPrincipalEmpleado.class).show();
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

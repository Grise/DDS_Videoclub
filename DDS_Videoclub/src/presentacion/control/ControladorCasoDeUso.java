package presentacion.control;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ControladorCasoDeUso implements Initializable {
    protected Stage stage;
    protected ControladorMenuPrincipalEmpleado controladorMenuPrincipalEmpleado;
    protected ControladorAdministracion controladorAdministracion;
    protected static ControladorCrearReserva controladorCrearReservaBackup;

    public void setControladorPrincipal(ControladorMenuPrincipalEmpleado controladorMenuPrincipalEmpleado) {
        this.controladorMenuPrincipalEmpleado = controladorMenuPrincipalEmpleado;
    }

    public Stage getStage() {
        return stage;
    }

    public void show() {
        stage.show();
    }

    public static <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass, Stage owner, ControladorMenuPrincipalEmpleado controladorMenuPrincipalEmpleado) {
        FXMLLoader fxmlLoader = new FXMLLoader(ControladorCasoDeUso.class.getResource(urlVista));
        T controlador = null;
        try {
            Parent parent = fxmlLoader.load();
            controlador = fxmlLoader.getController();
            controlador.stage.setScene(new Scene(parent));
            controlador.stage.initOwner(owner);
            controlador.setControladorPrincipal(controladorMenuPrincipalEmpleado);
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return controlador;
    }

    public static <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass, Stage owner, ControladorCrearReserva controladorCrearReserva) {
        controladorCrearReservaBackup = controladorCrearReserva;
        FXMLLoader fxmlLoader = new FXMLLoader(ControladorCasoDeUso.class.getResource(urlVista));
        T controlador = null;
        try {
            Parent parent = fxmlLoader.load();
            controlador = fxmlLoader.getController();
            controlador.stage.setScene(new Scene(parent));
            controlador.stage.initOwner(owner);
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return controlador;
    }

    public static <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass, Stage owner, ControladorAdministracion controladorAdministracion) {
        FXMLLoader fxmlLoader = new FXMLLoader(ControladorCasoDeUso.class.getResource(urlVista));
        T controlador = null;
        try {
            Parent parent = fxmlLoader.load();
            controlador = fxmlLoader.getController();
            controlador.stage.setScene(new Scene(parent));
            controlador.stage.initOwner(owner);
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return controlador;
    }
}
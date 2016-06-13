package presentacion.control;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMenuPrincipalEmpleado extends ControladorCasoDeUso {
    private static final String MENU_RESERVA = "/presentacion/vista/CrearReserva.fxml";
    private static final String MENU_MODIFICAR_USUARIOS = "/presentacion/vista/GestionarUsuarios.fxml";
    private static final String MENU_GESTIONAR_RESERVAS = "/presentacion/vista/GestionarReservas.fxml";
    private static final String MENU_ADMINISTRACION = "/presentacion/vista/Administracion.fxml";

    @FXML
    private Stage primaryStage;

    @FXML
    private ImageView imagenCrearReserva;

    @FXML
    private ImageView imagenAdministracion;

    @FXML
    private ImageView imagenGestionarReservas;

    @FXML
    private ImageView imagenModificarUsuarios;

    @FXML
    private Label textoCrearReserva;

    @FXML
    private Label textoModificarUsuarios;

    @FXML
    private Label textoGestionarReservas;

    @FXML
    private Label textoAdministracion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Menú principal");

        /**********************************************************************************************
         * CAMBIAMOS EL COMPORTAMIENTO DEL CURSOR AL PASAR POR ENCIMA DE LAS IMAGENES O LAS ETIQUETAS *
         **********************************************************************************************/
        imagenCrearReserva.setCursor(Cursor.HAND);
        imagenAdministracion.setCursor(Cursor.HAND);
        imagenGestionarReservas.setCursor(Cursor.HAND);
        imagenModificarUsuarios.setCursor(Cursor.HAND);
        textoCrearReserva.setCursor(Cursor.HAND);
        textoAdministracion.setCursor(Cursor.HAND);
        textoGestionarReservas.setCursor(Cursor.HAND);
        textoModificarUsuarios.setCursor(Cursor.HAND);

        /***************************************************************
         * DEFINIMOS EL COMPORTAMIENTO DE LAS IMAGENES Y LAS ETIQUETAS *
         ***************************************************************/
        imagenCrearReserva.setOnMouseClicked(event -> initCasoDeUso(MENU_RESERVA, ControladorCrearReserva.class).show());
        textoCrearReserva.setOnMouseClicked(event -> initCasoDeUso(MENU_RESERVA, ControladorCrearReserva.class).show());

        imagenModificarUsuarios.setOnMouseClicked(event -> initCasoDeUso(MENU_MODIFICAR_USUARIOS, ControladorGestionarUsuarios.class).show());
        textoModificarUsuarios.setOnMouseClicked(event -> initCasoDeUso(MENU_MODIFICAR_USUARIOS, ControladorGestionarUsuarios.class).show());

        imagenGestionarReservas.setOnMouseClicked(event -> initCasoDeUso(MENU_GESTIONAR_RESERVAS, ControladorGestionarReservas.class).show());
        textoGestionarReservas.setOnMouseClicked(event -> initCasoDeUso(MENU_GESTIONAR_RESERVAS, ControladorGestionarReservas.class).show());

        
        imagenAdministracion.setOnMouseClicked(event -> initCasoDeUso(MENU_ADMINISTRACION, ControladorAdministracion.class).show());
        textoAdministracion.setOnMouseClicked(event -> initCasoDeUso(MENU_ADMINISTRACION, ControladorAdministracion.class).show());
        
    }

    private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass) {
        return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass, primaryStage, ControladorMenuPrincipalEmpleado.this);
    }
}
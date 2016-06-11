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
    private static final String MENU_RESERVA = "../vista/CrearReserva.fxml";
    //TODO AÑADIR LOS MENÚS QUE FALTAN

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
        imagenCrearReserva.setOnMouseClicked(event -> {
            initCasoDeUso(MENU_RESERVA, ControladorCrearReserva.class).show();
        });

        textoCrearReserva.setOnMouseClicked(event -> {
            //initCasoDeUso();
        });
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass) {
        return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass, primaryStage, ControladorMenuPrincipalEmpleado.this);
    }
}
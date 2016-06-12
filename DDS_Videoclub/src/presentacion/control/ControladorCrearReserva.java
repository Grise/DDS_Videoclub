package presentacion.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerPeliculas;
import logica.Cliente;
import logica.Pelicula;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class ControladorCrearReserva extends ControladorCasoDeUso {
    private static final String MENU_RESERVA_PELICULA = "/presentacion/vista/CrearReservaPelicula.fxml";

    public Pelicula pelicula;

    @FXML
    private Stage primaryStage;
    @FXML
    private DatePicker datePickerDesde;

    @FXML
    private DatePicker datePickerHasta;

    @FXML
    private Button botonEscogerPelicula;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonAceptar;

    @FXML
    public Label textoEscogerPelicula;

    @FXML
    private ComboBox<String> comboBoxDNI;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Crear reserva");

        rellenarComboBoxGeneros();

        /**********************************************
         * DEFINIMOS EL COMPORTAMIENTO DE LOS BOTONES *
         **********************************************/
        botonAceptar.setOnMouseClicked(event -> {
            //TODO
            AlquilerPeliculas.dameAlquilerPeliculasLogica().
        });

        botonCancelar.setOnMouseClicked(event -> {
            Stage stageActual = (Stage) botonCancelar.getScene().getWindow();
            stageActual.close();
        });

        botonEscogerPelicula.setOnMouseClicked(event -> initCasoDeUso(MENU_RESERVA_PELICULA, ControladorCrearReservaPelicula.class).show());
    }

    private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass) {
        return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass, primaryStage, this);
    }

    public void rellenarComboBoxGeneros() {
        Iterator<Cliente> iterador = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaClientes().iterator();
        while (iterador.hasNext()) {
            Cliente cliente = iterador.next();
            String dniNombre = cliente.getDni() + " - " + cliente.getNombre();
            comboBoxDNI.getItems().add(dniNombre);
        }
    }
}

package presentacion.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorCrearReserva extends ControladorCasoDeUso {
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
    private Text textoEscogerPelicula;

    @FXML
    private TextField inputDNI;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**********************************************
         * DEFINIMOS EL COMPORTAMIENTO DE LOS BOTONES *
         **********************************************/
        botonAceptar.setOnMouseClicked(event -> {
            //TODO TIENE QUE GUARDAR LA RESERVA, ES JODIDO
        });
        botonCancelar.setOnMouseClicked(event -> {
            Stage stageActual = (Stage) botonCancelar.getScene().getWindow();
            stageActual.close();
        });
        botonEscogerPelicula.setOnMouseClicked(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/presentacion/vista/CrearReservaPelicula.fxml"));
                Parent root = fxmlLoader.load();
                Stage nuevoStage = new Stage();
                nuevoStage.initModality(Modality.APPLICATION_MODAL);
                nuevoStage.setTitle("Buscador de pel\u00edculas");
                nuevoStage.setScene(new Scene(root));
                nuevoStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

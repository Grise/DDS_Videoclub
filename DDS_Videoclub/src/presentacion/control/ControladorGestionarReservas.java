package presentacion.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;


public class ControladorGestionarReservas extends ControladorCasoDeUso {

    @FXML
    private TextField peliculaTextField;

    @FXML
    private Button botonCancelar;

    @FXML
    private TableView<?> tableViewReservas;

    @FXML
    private Button botonEliminar;

    @FXML
    private ComboBox<?> dniComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Gestionar reservas");
    }
}

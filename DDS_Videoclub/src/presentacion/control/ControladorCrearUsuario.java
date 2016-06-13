package presentacion.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerPeliculas;

import java.net.URL;
import java.util.ResourceBundle;


public class ControladorCrearUsuario extends ControladorCasoDeUso {

    @FXML
    private ComboBox<String> tipoUsuarioComboBox;

    @FXML
    private TextField inputNombre;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonAceptar;

    @FXML
    private TextField inputDni;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Crear Usuario");

        tipoUsuarioComboBox.getItems().addAll(
                "CLIENTE",
                "EMPLEADO"
        );

        /*********************************
         * COMPORTAMIENTO DE LOS BOTONES *
         *********************************/

        botonAceptar.setOnMouseClicked(event -> {
            int id = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaPersonas().size();
            if (tipoUsuarioComboBox.getValue() != null && inputDni.getText() != null && inputNombre.getText() != null) {
                AlquilerPeliculas.dameAlquilerPeliculasLogica().crearPersona(id, inputDni.getText(), inputNombre.getText(), tipoUsuarioComboBox.getValue());
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText("Éxito al crear el nuevo usuario");
                alert.setContentText("Se ha añadido el nuevo usuario con éxito");

                alert.showAndWait();
                stage.close();

            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error al crear el usuario");
                alert.setContentText("Se deben rellenar todos los campos para crear el nuevo usuario");

                alert.showAndWait();
            }
        });

        botonCancelar.setOnAction(event -> stage.close());
    }
}

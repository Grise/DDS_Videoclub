package presentacion.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerPeliculas;
import logica.Genero;
import logica.Persona;
import logica.PersonaFabrica;
import presentacion.control.ControladorCasoDeUso;

import java.net.URL;
import java.util.ResourceBundle;


public class ControladorCrearDirector extends ControladorCasoDeUso {

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonAceptar;

    @FXML
    private TextField inputDirector;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Crear Director");

        /*********************************
         * COMPORTAMIENTO DE LOS BOTONES *
         *********************************/

        botonAceptar.setOnMouseClicked(event -> {
            int id = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaPersonas().size();
            if (inputDirector.getText() != null) {
                AlquilerPeliculas.dameAlquilerPeliculasLogica().crearPersona(id, "UNKNOWN", inputDirector.getText(), "DIRECTOR");
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText("Éxito al añadir el nuevo director");
                alert.setContentText("Se ha añadido el nuevo director con éxito");

                alert.showAndWait();
                stage.close();

            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error al crear el director");
                alert.setContentText("Se debe introducir un nombre para el nuevo director");

                alert.showAndWait();
            }
        });

        botonCancelar.setOnAction(event -> stage.close());
    }
}

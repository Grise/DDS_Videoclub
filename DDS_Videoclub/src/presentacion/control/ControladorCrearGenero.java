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

import java.net.URL;
import java.util.ResourceBundle;


public class ControladorCrearGenero extends ControladorCasoDeUso {

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonAceptar;

    @FXML
    private TextField inputGenero;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Crear Genero");

        /*********************************
         * COMPORTAMIENTO DE LOS BOTONES *
         *********************************/

        botonAceptar.setOnMouseClicked(event -> {
            int id = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaGeneros().size();
            if (inputGenero.getText() != null) {
                if (AlquilerPeliculas.dameAlquilerPeliculasLogica().buscarGenero(inputGenero.getText()) == null) {
                    Genero genero = new Genero(id, inputGenero.getText());
                    AlquilerPeliculas.dameAlquilerPeliculasLogica().crearGenero(genero);
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al crear el género");
                    alert.setContentText("Ya existe un género con el mismo nombre introducido");

                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error al crear el género");
                alert.setContentText("Se debe introducir un nombre para el nuevo género");

                alert.showAndWait();
            }
        });

        botonCancelar.setOnAction(event -> stage.close());
    }
}

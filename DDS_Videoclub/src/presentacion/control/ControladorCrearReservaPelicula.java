package presentacion.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;


public class ControladorCrearReservaPelicula extends ControladorCasoDeUso {
    @FXML
    private TextField inputGenero;

    @FXML
    private TextField inputDirector;

    @FXML
    private TextField inputPelicula;

    @FXML
    private TableView<?> tableViewPeliculas;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonAceptar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("LISTADO DE SUCURSALES");
        botonCancelar.setOnAction(event -> stage.close());
    }
}

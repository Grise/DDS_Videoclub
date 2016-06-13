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
import logica.Director;
import logica.Genero;
import logica.Pelicula;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;


public class ControladorCrearPelicula extends ControladorCasoDeUso {

    @FXML
    private TextField inputStock;

    @FXML
    private Button botonCancelar;

    @FXML
    private ComboBox<String> directorComboBox;

    @FXML
    private TextField inputAno;

    @FXML
    private ComboBox<String> generoComboBox;

    @FXML
    private Button botonAceptar;

    @FXML
    private TextField inputTitulo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Crear Pel\u00edcula");

        rellenarComboBoxDirectores();
        rellenarComboBoxGeneros();

        /*********************************
         * COMPORTAMIENTO DE LOS BOTONES *
         *********************************/

        // TODO revisar suciedad para parchear de String a Integer por si hay solucion mejor

        botonAceptar.setOnMouseClicked(event -> {
            int aux;
            int aux2;
            int id = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaPeliculas().size();
            if(inputTitulo.getText()!=null && inputAno.getText()!=null &&
                    inputStock.getText()!=null && generoComboBox.getValue()!=null && directorComboBox.getValue()!=null){
                aux = Integer.parseInt(inputAno.getText());
                aux2 = Integer.parseInt(inputStock.getText());
                Pelicula pel = new Pelicula(id, inputTitulo.getText(), aux,
                        (AlquilerPeliculas.dameAlquilerPeliculasLogica().buscarDirector(directorComboBox.getValue())),
                        (AlquilerPeliculas.dameAlquilerPeliculasLogica().buscarGenero(generoComboBox.getValue())), aux2);
                AlquilerPeliculas.dameAlquilerPeliculasLogica().crearPelicula(pel);
                stage.close();
            }else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("Rellenar todos los campos");

                alert.showAndWait();
            }
        });

        botonCancelar.setOnAction(event -> stage.close());
    }

    public void rellenarComboBoxGeneros() {
        Iterator<Genero> iterador = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaGeneros().iterator();
        while (iterador.hasNext()) {
            String nombreGenero = iterador.next().getNombre();
            generoComboBox.getItems().add(nombreGenero);
        }
    }

    public void rellenarComboBoxDirectores() {
        Iterator<Director> iterador = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaDirectores().iterator();
        while (iterador.hasNext()) {
            String nombreDirector = iterador.next().getNombre();
            directorComboBox.getItems().add(nombreDirector);
        }
    }
}

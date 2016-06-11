package presentacion.control;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.adapter.ReadOnlyJavaBeanObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import logica.AlquilerPeliculas;
import logica.Pelicula;
import logica.Reserva;


public class ControladorCrearReservaPelicula extends ControladorCasoDeUso {
    @FXML
    private TextField inputGenero;

    @FXML
    private TextField inputDirector;

    @FXML
    private TextField inputPelicula;

    @FXML
    private TableView<Pelicula> tableViewPeliculas;

    @FXML
    private TableColumn<Pelicula, String> tableColumnTitulo;

    @FXML
    private TableColumn<Pelicula, Integer> tableColumnAnno;

    @FXML
    private TableColumn<Pelicula, String> tableColumnGenero;

    @FXML
    private TableColumn<Pelicula, String> tableColumnDirector;

    @FXML
    private TableColumn<Pelicula, String> tableColumnDisponible;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonAceptar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Pel\u00edculas");
        botonCancelar.setOnAction(event -> stage.close());

        rellenarTableView();
    }

    private void rellenarTableView(){
        tableColumnTitulo.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
        tableColumnAnno.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getAnno()));
        tableColumnGenero.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getGenero().getNombre()));
        tableColumnDirector.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDirector().getNombre()));
        tableColumnDisponible.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getStockBooleano()));

        List<Pelicula> listaPeliculas = AlquilerPeliculas.dameAlquilerPeliculasLogica().listarPeliculas();
        this.tableViewPeliculas.getItems().addAll(listaPeliculas);
    }
}

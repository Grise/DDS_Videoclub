package presentacion.control;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerPeliculas;
import logica.Genero;
import logica.Pelicula;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;


public class ControladorCrearReservaPelicula extends ControladorCasoDeUso {
    @FXML
    private ComboBox<String> comboBoxGenero;

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

    private ObservableList<Pelicula> masterData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Pel\u00edculas");

        rellenarComboBoxGeneros();
        rellenarTableView();

        FilteredList<Pelicula> filteredData = new FilteredList<>(masterData, p -> true);

        inputDirector.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(eventoDirector -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (eventoDirector.getDirector().getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        inputPelicula.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(eventoPelicula -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (eventoPelicula.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        comboBoxGenero.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(eventoGenero -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (eventoGenero.getGenero().getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        System.out.println(filteredData);
        SortedList<Pelicula> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableViewPeliculas.comparatorProperty());

        tableViewPeliculas.setItems(sortedData);
        /*********************************
         * COMPORTAMIENTO DE LOS BOTONES *
         *********************************/
        botonCancelar.setOnAction(event -> stage.close());

        tableViewPeliculas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            botonAceptar.setDisable(false);
        });

        botonAceptar.setDisable(true);
        botonAceptar.setOnAction(event -> {
                    Pelicula peliculaElegida= tableViewPeliculas.getSelectionModel().getSelectedItem();
                    controladorCrearReservaBackup.pelicula = peliculaElegida;
                    controladorCrearReservaBackup.textoEscogerPelicula.setText(peliculaElegida.getNombre());
                    stage.close();
        });
    }

    public void rellenarComboBoxGeneros() {
        Iterator<Genero> iterador = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaGeneros().iterator();
        while (iterador.hasNext()) {
            String nombreGenero = iterador.next().getNombre();
            comboBoxGenero.getItems().add(nombreGenero);
        }
    }

    private void rellenarTableView() {
        tableColumnTitulo.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
        tableColumnAnno.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getAnno()));
        tableColumnGenero.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getGenero().getNombre()));
        tableColumnDirector.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDirector().getNombre()));
        tableColumnDisponible.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getStockBooleano()));

        masterData = FXCollections.observableArrayList(AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaPeliculas());
        //this.tableViewPeliculas.getItems().addAll(listaPeliculas);
    }
}

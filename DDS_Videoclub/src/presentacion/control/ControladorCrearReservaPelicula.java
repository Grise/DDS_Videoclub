package presentacion.control;

import javafx.beans.property.ReadOnlyObjectWrapper;
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
import java.util.List;
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

    @FXML
    private Button botonBuscar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Pel\u00edculas");

        rellenarComboBoxGeneros();
        rellenarTableView();

        comboBoxGenero.valueProperty().addListener(observable -> {
            botonBuscar.fire();
        });


        /*********************************
         * COMPORTAMIENTO DE LOS BOTONES *
         *********************************/
        botonCancelar.setOnAction(event -> stage.close());

        botonAceptar.setOnAction(event -> {
                    Pelicula peliculaElegida= tableViewPeliculas.getSelectionModel().getSelectedItem();
                    controladorCrearReservaBackup.pelicula = peliculaElegida;
                    controladorCrearReservaBackup.textoEscogerPelicula.setText(peliculaElegida.getNombre());
                    stage.close();
        });

        botonBuscar.setOnAction(event -> {
            tableViewPeliculas.getItems().clear();
            String titulo = inputPelicula.getText();
            String director = inputDirector.getText();
            //TODO: HAY QUE BUSCAR EL GÉNERO PILLANDOLO DE LA ETIQUETA COMO STRING EN LA MEMORIA
            Genero genero = null;
            rellenarTableView(titulo, genero, director);
        });
    }

    public void rellenarComboBoxGeneros() {
        Iterator<Genero> iterador = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaGeneros().values().iterator();
        while (iterador.hasNext()) {
            String nombreGenero = iterador.next().getNombre();
            comboBoxGenero.getItems().add(nombreGenero);
        }
    }

    //
    private void rellenarTableView() {
        tableColumnTitulo.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
        tableColumnAnno.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getAnno()));
        tableColumnGenero.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getGenero().getNombre()));
        tableColumnDirector.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDirector().getNombre()));
        tableColumnDisponible.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getStockBooleano()));

        List<Pelicula> listaPeliculas = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaPeliculas();
        this.tableViewPeliculas.getItems().addAll(listaPeliculas);
    }

    //TODO EL TABLE VIEW TIENE QUE MOSTRAR LA INFORMACIÓN SELECCIONADA EN LOS FILTROS
    private void rellenarTableView(String titulo, Genero genero, String director) {
        System.out.println("SOY ESPECIAL");

        tableColumnTitulo.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
        tableColumnAnno.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getAnno()));
        tableColumnGenero.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getGenero().getNombre()));
        tableColumnDirector.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDirector().getNombre()));
        tableColumnDisponible.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getStockBooleano()));

        List<Pelicula> listaPeliculas = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaPeliculas();
        this.tableViewPeliculas.getItems().addAll(listaPeliculas);
    }
}

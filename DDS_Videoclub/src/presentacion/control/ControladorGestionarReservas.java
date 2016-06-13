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
import logica.Cliente;
import logica.Reserva;

import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;


public class ControladorGestionarReservas extends ControladorCasoDeUso {

    private static final String MENU_FINALIZAR_RESERVA = "/presentacion/vista/FinalizarReserva.fxml";

    public Reserva reservaSeleccionada;
    @FXML
    private Stage primaryStage;

    @FXML
    private TextField peliculaTextField;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonFin;

    @FXML
    private TableView<Reserva> tableViewReservas;

    @FXML
    private TableColumn<Reserva, Date> tableColumnFechaFin;

    @FXML
    private TableColumn<Reserva, String> tableColumnUsuario;

    @FXML
    private TableColumn<Reserva, String> tableColumnDni;

    @FXML
    private TableColumn<Reserva, String> tableColumnPelicula;

    @FXML
    private TableColumn<Reserva, Date> tableColumnFechaInicio;

    @FXML
    private Button botonEliminar;

    @FXML
    private ComboBox<String> dniComboBox;

    public ObservableList<Reserva> masterData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Gestionar reservas");

        rellenarComboBoxDni();
        rellenarTableView();

        FilteredList<Reserva> filteredData = new FilteredList<>(masterData, p -> true);

        peliculaTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(eventoPelicula -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (eventoPelicula.getPelicula().getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        dniComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(eventoDni -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (eventoDni.getCliente().getDni().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Reserva> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableViewReservas.comparatorProperty());

        tableViewReservas.setItems(sortedData);

        /*********************************
         * COMPORTAMIENTO DE LOS BOTONES *
         *********************************/

        botonCancelar.setOnAction(event -> stage.close());

        tableViewReservas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            botonEliminar.setDisable(false);
        });

        botonEliminar.setOnAction(event -> {
            Reserva reservaElegida = tableViewReservas.getSelectionModel().getSelectedItem();
            AlquilerPeliculas.dameAlquilerPeliculasLogica().eliminarReserva(reservaElegida.getId());
            masterData.remove(reservaElegida);
        });

        botonFin.setOnAction(event -> {
            reservaSeleccionada = tableViewReservas.getSelectionModel().getSelectedItem();
            initCasoDeUso(MENU_FINALIZAR_RESERVA, ControladorFinalizarReserva.class).show();
        });
    }

    public void rellenarComboBoxDni() {
        Iterator<Cliente> iterador = AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaClientes().iterator();
        while (iterador.hasNext()) {
            String dni = iterador.next().getDni();
            dniComboBox.getItems().add(dni);
        }
    }

    private void rellenarTableView() {
        tableColumnPelicula.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPelicula().getNombre()));
        tableColumnUsuario.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCliente().getNombre()));
        tableColumnDni.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCliente().getDni()));
        tableColumnFechaInicio.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaInicio()));
        tableColumnFechaFin.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaFin()));

        masterData = FXCollections.observableArrayList(AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaReservasActivas());
    }

    private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass) {
        return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass, primaryStage, this);
    }
}

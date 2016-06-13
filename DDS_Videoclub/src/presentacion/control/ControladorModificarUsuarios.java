package presentacion.control;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerPeliculas;
import logica.Cliente;
import logica.Empleado;
import logica.Persona;

import java.net.URL;
import java.util.ResourceBundle;


public class ControladorModificarUsuarios extends ControladorCasoDeUso {


    @FXML
    private Button butonNuevo;

    @FXML
    private TextField inputNombre;

    @FXML
    private Button butonEliminar;

    @FXML
    private TableView<Empleado> tableViewEmpleados;

    @FXML
    private TableColumn<Empleado, String> tableColumnEmpleadoNombre;

    @FXML
    private TableColumn<Empleado, String> tableColumnEmpleadoDni;

    @FXML
    private TableColumn<Empleado, Integer> tableColumnEmpleadoId;

    @FXML
    private TableView<Cliente> tableViewClientes;

    @FXML
    private TableColumn<Cliente, String> tableColumnClienteNombre;

    @FXML
    private TableColumn<Cliente, String> tableColumnClienteDni;

    @FXML
    private TableColumn<Cliente, Integer> tableColumnClienteId;

    @FXML
    private Button butonCancelar;

    @FXML
    private TextField inputDNI;

    private ObservableList<Empleado> masterData = FXCollections.observableArrayList();

    private ObservableList<Cliente> masterData2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Gestionar usuarios");

        rellenarTableViewEmpelado();
        rellenarTableViewCliente();

        FilteredList<Empleado> filteredData = new FilteredList<>(masterData, p -> true);

        inputNombre.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(eventoNombre -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (eventoNombre.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        inputDNI.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(eventoDni -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (eventoDni.getDni().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        FilteredList<Cliente> filteredData2 = new FilteredList<>(masterData2, p -> true);

        inputNombre.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(eventoNombre2 -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (eventoNombre2.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        inputDNI.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(eventoDni2 -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (eventoDni2.getDni().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Cliente> sortedData2 = new SortedList<>(filteredData2);
        sortedData2.comparatorProperty().bind(tableViewClientes.comparatorProperty());
        tableViewClientes.setItems(sortedData2);

        SortedList<Empleado> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableViewEmpleados.comparatorProperty());
        tableViewEmpleados.setItems(sortedData);

        /*********************************
         * COMPORTAMIENTO DE LOS BOTONES *
         *********************************/
        // TODO poder eliminar usuarios creando eliminar en PersonaDAOImp y eliminarlos de las tablas



    }

    private void rellenarTableViewEmpelado() {

        tableColumnEmpleadoNombre.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
        tableColumnEmpleadoDni.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDni()));
        tableColumnEmpleadoId.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));

        masterData = FXCollections.observableArrayList(AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaEmpleados());

    }

    private void rellenarTableViewCliente() {

        tableColumnClienteNombre.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
        tableColumnClienteDni.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDni()));
        tableColumnClienteId.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));

        masterData2 = FXCollections.observableArrayList(AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaClientes());

    }
}

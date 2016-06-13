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

import java.net.URL;
import java.util.ResourceBundle;


public class ControladorGestionarUsuarios extends ControladorCasoDeUso {

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

    private ObservableList<Empleado> masterDataEmpleado = FXCollections.observableArrayList();

    private ObservableList<Cliente> masterDataCliente = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Gestionar usuarios");

        rellenarTableViewEmpelado();
        rellenarTableViewCliente();

        FilteredList<Empleado> filteredData = new FilteredList<>(masterDataEmpleado, p -> true);

        FilteredList<Cliente> filteredData2 = new FilteredList<>(masterDataCliente, p -> true);

        SortedList<Cliente> sortedData2 = new SortedList<>(filteredData2);
        sortedData2.comparatorProperty().bind(tableViewClientes.comparatorProperty());
        tableViewClientes.setItems(sortedData2);

        SortedList<Empleado> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableViewEmpleados.comparatorProperty());
        tableViewEmpleados.setItems(sortedData);


        tableViewClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null)
                tableViewEmpleados.getSelectionModel().clearSelection();
        });

        tableViewEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null)
                tableViewClientes.getSelectionModel().clearSelection();
        });
        /*********************************
         * COMPORTAMIENTO DE LOS BOTONES *
         *********************************/
        butonCancelar.setOnAction(event -> stage.close());

        butonEliminar.setOnAction(event -> {
            Cliente clienteElegido = tableViewClientes.getSelectionModel().getSelectedItem();
            if (clienteElegido == null) {
                Empleado empleadoElegido = tableViewEmpleados.getSelectionModel().getSelectedItem();
                AlquilerPeliculas.dameAlquilerPeliculasLogica().eliminarPersona(empleadoElegido);
                masterDataEmpleado.remove(empleadoElegido);
                empleadoElegido = null;
            } else {
                AlquilerPeliculas.dameAlquilerPeliculasLogica().eliminarPersona(clienteElegido);
                masterDataCliente.remove(clienteElegido);
                clienteElegido = null;
            }
        });


    }

    private void rellenarTableViewEmpelado() {

        tableColumnEmpleadoNombre.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
        tableColumnEmpleadoDni.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDni()));
        tableColumnEmpleadoId.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));

        masterDataEmpleado = FXCollections.observableArrayList(AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaEmpleados());

    }

    private void rellenarTableViewCliente() {

        tableColumnClienteNombre.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getNombre()));
        tableColumnClienteDni.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDni()));
        tableColumnClienteId.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));

        masterDataCliente = FXCollections.observableArrayList(AlquilerPeliculas.dameAlquilerPeliculasLogica().getListaClientes());

    }
}

package presentacion.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMenuPrincipalEmpleado extends ControladorCasoDeUso {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button nuevoAlquiler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("MIERDA SECA");
        nuevoAlquiler.setOnAction((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(""));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setOpacity(1);
                stage.setTitle("Alquiler");
                stage.setScene(new Scene(root, 450, 450));
                stage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
//      cancelar.setOnAction(event -> stage.close());
/*      aceptar.setOnAction(event -> {
            if (dni.getText() != null && alquilerVehiculo.buscarCliente(dni.getText()) != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("El Cliente con DNI: " + dni.getText() + " ya existe.");
                alert.showAndWait();
            } else {
                try {

                    nuevoCliente = new Cliente(dni.getText(), nombreApellidos.getText(),
                            direccion.getText(),
                            poblacion.getText(), codigoPostal.getText(),
                            fechaCarnet.getValue(), digitosTC.getText(),
                            Integer.parseInt(mesTC.getText()),
                            Integer.parseInt(añoTC.getText()),
                            Integer.parseInt(cvc.getText()), tipoTarjeta.getText());
                } catch (Exception e) {
                }

                if (nuevoCliente != null) {
                    //Invocamos el servicio encargado de Crear un nuevo cliente

                    AlquilerVehiculos.dameAlquilerVehiculos().crearCliente(nuevoCliente);
                    LOG.log(Level.INFO, "Se ha creado un nuevo Cliente: " +
                            nuevoCliente);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Información");
                    alert.setHeaderText(null);
                    alert.setContentText("Se he creado un nuevo cliente con DNI " + nuevoCliente.getDni());
                    alert.showAndWait();

                } else {
                    LOG.log(Level.INFO, "No se ha podido crear un nuevo cliente.");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Ha habido un error y no se ha podido crear un nuevo cliente !");
                    alert.showAndWait();
                }
                stage.close();
            }
        });*/
    }
}

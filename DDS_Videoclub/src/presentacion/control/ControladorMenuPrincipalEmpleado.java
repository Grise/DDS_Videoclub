package presentacion.control;

import java.io.IOException;
import presentacion.control.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import logica.MainApp;
import presentacion.control.ControladorCasoDeUso;
import presentacion.control.ControladorCasoDeUso;

public class ControladorMenuPrincipalEmpleado extends ControladorCasoDeUso {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private void nuevoAlquiler() {
     try {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("../presentacion/vista/AlquilerPelicula.fxml"));
     AnchorPane page = (AnchorPane) loader.load();
     } catch (IOException e) {
        e.printStackTrace();
        
    }

    
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("MIERDA SECA");
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

package presentacion.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMenuPrincipalEmpleado extends ControladorCasoDeUso {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imagenCrearReserva;

    @FXML
    private ImageView imagenAdministracion;

    @FXML
    private ImageView imagenGestionarReservas;

    @FXML
    private ImageView imagenModificarUsuarios;

    @FXML
    private Label textoCrearReserva;

    @FXML
    private Label textoModificarUsuarios;

    @FXML
    private Label textoGestionarReservas;

    @FXML
    private Label textoAdministracion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Menú principal");

        /**********************************************************************************************
         * CAMBIAMOS EL COMPORTAMIENTO DEL CURSOR AL PASAR POR ENCIMA DE LAS IMAGENES O LAS ETIQUETAS *
         **********************************************************************************************/
        imagenCrearReserva.setCursor(Cursor.HAND);
        imagenAdministracion.setCursor(Cursor.HAND);
        imagenGestionarReservas.setCursor(Cursor.HAND);
        imagenModificarUsuarios.setCursor(Cursor.HAND);
        textoCrearReserva.setCursor(Cursor.HAND);
        textoAdministracion.setCursor(Cursor.HAND);
        textoGestionarReservas.setCursor(Cursor.HAND);
        textoModificarUsuarios.setCursor(Cursor.HAND);

        /***************************************************************
         * DEFINIMOS EL COMPORTAMIENTO DE LAS IMAGENES Y LAS ETIQUETAS *
         ***************************************************************/

        imagenCrearReserva.setOnMouseClicked(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/presentacion/vista/CrearReserva.fxml"));
                Parent root = fxmlLoader.load();
                Stage nuevoStage = new Stage();
                nuevoStage.initModality(Modality.APPLICATION_MODAL);
                nuevoStage.setTitle("Crear reserva");
                nuevoStage.setScene(new Scene(root));
                nuevoStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
//        /*nuevoAlquiler.setOnAction((event) -> {
//            try {
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(""));
//                Parent root = fxmlLoader.load();
//                Stage stage = new Stage();
//                stage.initModality(Modality.APPLICATION_MODAL);
//                stage.setOpacity(1);
//                stage.setTitle("Alquiler");
//                stage.setScene(new Scene(root, 450, 450));
//                stage.showAndWait();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });*/
////      cancelar.setOnAction(event -> stage.close());
///*      aceptar.setOnAction(event -> {
//            if (dni.getText() != null && alquilerVehiculo.buscarCliente(dni.getText()) != null) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Error");
//                alert.setHeaderText(null);
//                alert.setContentText("El Cliente con DNI: " + dni.getText() + " ya existe.");
//                alert.showAndWait();
//            } else {
//                try {
//
//                    nuevoCliente = new Cliente(dni.getText(), nombreApellidos.getText(),
//                            direccion.getText(),
//                            poblacion.getText(), codigoPostal.getText(),
//                            fechaCarnet.getValue(), digitosTC.getText(),
//                            Integer.parseInt(mesTC.getText()),
//                            Integer.parseInt(añoTC.getText()),
//                            Integer.parseInt(cvc.getText()), tipoTarjeta.getText());
//                } catch (Exception e) {
//                }
//
//                if (nuevoCliente != null) {
//                    //Invocamos el servicio encargado de Crear un nuevo cliente
//
//                    AlquilerVehiculos.dameAlquilerVehiculos().crearCliente(nuevoCliente);
//                    LOG.log(Level.INFO, "Se ha creado un nuevo Cliente: " +
//                            nuevoCliente);
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Información");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Se he creado un nuevo cliente con DNI " + nuevoCliente.getDni());
//                    alert.showAndWait();
//
//                } else {
//                    LOG.log(Level.INFO, "No se ha podido crear un nuevo cliente.");
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Ha habido un error y no se ha podido crear un nuevo cliente !");
//                    alert.showAndWait();
//                }
//                stage.close();
//            }
//        });*/
//    }
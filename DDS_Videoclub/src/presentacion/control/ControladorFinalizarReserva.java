package presentacion.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerPeliculas;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorFinalizarReserva extends ControladorCasoDeUso{

    @FXML
    private TextArea textAreaComentarios;

    @FXML
    private CheckBox checkBoxDanno;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonAceptar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Finalizar reserva");

        /*********************************
         * COMPORTAMIENTO DE LOS BOTONES *
         *********************************/

        botonCancelar.setOnAction(event -> stage.close());

        botonAceptar.setOnAction(event -> {
            //TODO HACER CON GETTERS Y SETTERS PARA LA LISTA Y EL TEXT AREA
            Boolean devolucionDannada = checkBoxDanno.isSelected();
            if(!devolucionDannada){
                AlquilerPeliculas.dameAlquilerPeliculasLogica().finalizarReserva(controladorGestionarReservas.reservaSeleccionada, textAreaComentarios.getText());
                controladorGestionarReservas.masterData.remove(controladorGestionarReservas.reservaSeleccionada);
            }
            else{
                AlquilerPeliculas.dameAlquilerPeliculasLogica().finalizarReservaDannada(controladorGestionarReservas.reservaSeleccionada, textAreaComentarios.getText());
                controladorGestionarReservas.masterData.remove(controladorGestionarReservas.reservaSeleccionada);
            }
            stage.close();
        });
    }

}
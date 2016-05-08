
package presentacion.controlador;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Dispatcher {

    public Dispatcher() {
    }

    public String enalce;

    public void dispatch(String request, Scene scene) {
        try {
            FXMLLoader loader;
            if (request.equalsIgnoreCase("EMPLEADO")) {
                String enlace = "EmpleadoView.fxml";
                loader = new FXMLLoader(getClass().getResource(enlace));

                EmpleadoViewController controller = loader.getController();
                //TODO Esto hay que revisar que hostias es: controller.initSessionID(this, sessionID);
            } else {
                String enlace = "ClienteView.fxml";
                loader = new FXMLLoader(getClass().getResource(enlace));

                ClienteViewController controller = loader.getController();
                //TODO Esto hay que revisar que hostias es: controller.initSessionID(this, sessionID);
            }
            scene.setRoot(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

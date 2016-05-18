package presentacion.controlador;

import java.io.IOException;
import java.util.logging.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;

/**
 * Manages control flow for logins
 */
public class LoginManager {

    private Scene scene;

    public LoginManager(Scene scene) {
        this.scene = scene;
    }

    /**
     * Callback method invoked to notify that a user has been authenticated.
     * Will show the main application screen.
     */
    public void authenticated(String sessionID) {
        showMainView(sessionID);
    }

    /**
     * Callback method invoked to notify that a user has logged out of the main
     * application. Will show the login application screen.
     */
    public void logout() {
        showLoginScreen();
    }

    public void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("login.fxml")
            );
            scene.setRoot((Parent) loader.load());
            LoginController controller
                    = loader.<LoginController>getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // TODO https://gist.github.com/jewelsea/4631319
    private void showMainView(String sessionID) {
        FrontController frontController = new FrontController(scene);
        //TODO Comprobar el tipo de cuenta para pasar la información en el dispatchRequest según toque
        frontController.dispatchRequest("EMPLEADO");

    }
}

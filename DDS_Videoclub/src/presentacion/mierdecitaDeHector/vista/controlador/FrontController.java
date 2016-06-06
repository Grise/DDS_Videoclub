
package presentacion.mierdecitaDeHector.vista.controlador;

import javafx.scene.Scene;

public class FrontController {
    
    private Dispatcher dispatcher;
    private Scene scene;

    public FrontController(Scene scene) {
        this.scene = scene;
        dispatcher = new Dispatcher();
    }
    
    public void dispatchRequest(String request){
        dispatcher.dispatch(request, scene);
    }
}

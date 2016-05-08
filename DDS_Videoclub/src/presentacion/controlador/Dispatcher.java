
package presentacion.controlador;

public class Dispatcher {

    public Dispatcher() {
    }
    
    public String enalce;
    
    public void dispatch(String request){
        if(request.equalsIgnoreCase("EMPLEADO")){
            String enlace = "EmpleadoView.fxml";
        }
        else{
            String enlace = "ClienteView.fxml";
        }
    }
}

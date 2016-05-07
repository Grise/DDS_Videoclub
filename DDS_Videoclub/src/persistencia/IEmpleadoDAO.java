
package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.EmpleadoDTO;

public interface IEmpleadoDAO {
    
    public EmpleadoDTO buscarEmpleado(int id)throws DAOExcepcion;
    
    public void crearEmpleado(EmpleadoDTO empleado) throws DAOExcepcion;
    
}


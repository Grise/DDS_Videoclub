
package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.EmpleadoDTO;

public interface IEmpleadoDAO {

    EmpleadoDTO buscarEmpleado(int id) throws DAOExcepcion;

    void crearEmpleado(EmpleadoDTO empleado) throws DAOExcepcion;

}


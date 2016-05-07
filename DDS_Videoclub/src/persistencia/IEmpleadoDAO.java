
package persistencia;

public interface IEmpleadoDAO {
    
    public EmpleadoDTO buscarEmpleado(int id)throws DAOExcepcion;
    
    public void crearCliente(EmpleadoDTO empleado) throws DAOExcepcion;
    
}


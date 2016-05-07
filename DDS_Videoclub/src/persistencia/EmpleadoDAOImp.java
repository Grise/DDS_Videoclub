package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.EmpleadoDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAOImp implements IEmpleadoDAO {

    private ConnectionManager connectionManager;

    public EmpleadoDAOImp() throws DAOExcepcion {
        super();
        try {
            connectionManager = new ConnectionManager("dbvideoclub");
        } catch (ClassNotFoundException e) {
            throw new DAOExcepcion(e);
        }
    }

    public EmpleadoDTO buscarEmpleado(int id) throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet rs = connectionManager.queryDB("select * from EMPLEADO where ID= '" + id + "'");
            connectionManager.close();

            if (rs.next())
                return new EmpleadoDTO(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"));
            else
                return null;
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        }
    }

    public void crearEmpleado(EmpleadoDTO empleado) throws DAOExcepcion {
        try {
            connectionManager.connect();
            connectionManager
                    .updateDB("insert into EMPLEADO (NOMBRE) values('"
                            + empleado.getNombre() + "')");
            connectionManager.close();
        } catch (Exception e) {
            throw new DAOExcepcion(e);
        }
    }
}
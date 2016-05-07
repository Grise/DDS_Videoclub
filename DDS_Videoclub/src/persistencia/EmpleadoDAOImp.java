
package persistencia;

import excepciones.DAOExcepcion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import persistencia.dto.EmpleadoDTO;

public class EmpleadoDAOImp implements IEmpleadoDAO {
	
	protected ConnectionManager connectionManager;
	protected LocalDateTime dateTime;

	public EmpleadoDAOImp() throws DAOExcepcion {
		super();
		try{
		connectionManager = new ConnectionManager("dbvideoclub");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
	
	public EmpleadoDTO buscarEmpleado(int id) throws DAOExcepcion {
		try{
			connectionManager.connect();
			ResultSet rs=connectionManager.queryDB("select * from EMPLEADO where ID= '"+id+"'");
			connectionManager.close();
		
			if (rs.next())
				return new EmpleadoDTO(
							rs.getInt("ID"),
							rs.getString("NOMBRE"));
			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}
	
	public void crearEmpleado(EmpleadoDTO empleado) throws DAOExcepcion {
		try {
			connectionManager.connect();
			connectionManager
					.updateDB("insert into EMPLEADO (ID, NOMBRE) values('"
							+ empleado.getId()
							+ "','"
							+ empleado.getNombre() + "')");
			connectionManager.close();
		} catch (Exception e) {
			throw new DAOExcepcion(e);
		}
	}
}

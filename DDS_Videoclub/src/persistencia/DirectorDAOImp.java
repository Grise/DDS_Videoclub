
package persistencia;

import excepciones.DAOExcepcion;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.dto.DirectorDTO;

public class DirectorDAOImp implements IDirectorDAO {
	
	protected ConnectionManager connectionManager;

	public DirectorDAOImp() throws DAOExcepcion {
		super();
		try{
		connectionManager = new ConnectionManager("dbvideoclub");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
	
	public DirectorDTO buscarDirector(int id) throws DAOExcepcion {
		try{
			connectionManager.connect();
			ResultSet rs=connectionManager.queryDB("select * from DIRECTOR where ID= '"+id+"'");
			connectionManager.close();
		
			if (rs.next())
				return new DirectorDTO(
							rs.getInt("ID"),
							rs.getString("NOMBRE"));
			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}
}

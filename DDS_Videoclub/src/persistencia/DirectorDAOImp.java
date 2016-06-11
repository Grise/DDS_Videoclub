package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.DirectorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAOImp implements IDirectorDAO {

    private ConnectionManager connectionManager;

    public DirectorDAOImp() throws DAOExcepcion {
        super();
        try {
            connectionManager = new ConnectionManager("dbvideoclub");
        } catch (ClassNotFoundException e) {
            throw new DAOExcepcion(e);
        }
    }

    public DirectorDTO buscarDirector(int id) throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet rs = connectionManager.queryDB("select * from DIRECTOR where ID= '" + id + "'");
            connectionManager.close();

            if (rs.next())
                return new DirectorDTO(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"));
            else
                return null;
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        }
    }
    
    public List<DirectorDTO> obtenerDirectores() throws DAOExcepcion {
		try{
			connectionManager.connect();
			ResultSet rs=connectionManager.queryDB("select * from DIRECTOR");						
			connectionManager.close();
	  	  
			List<DirectorDTO> listaDirectorDTO = new ArrayList<DirectorDTO>();
				
			try{				
				while (rs.next()){

					DirectorDTO directorDTO = new DirectorDTO(
							rs.getInt("ID"),
							rs.getString("NOMBRE"));	 
					listaDirectorDTO.add(directorDTO);
				}
				return listaDirectorDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}
}
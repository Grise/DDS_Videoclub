package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.GeneroDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneroDAOImp implements IGeneroDAO {

    private ConnectionManager connectionManager;

    public GeneroDAOImp() throws DAOExcepcion {
        super();
        try {
            connectionManager = new ConnectionManager("dbvideoclub");
        } catch (ClassNotFoundException e) {
            throw new DAOExcepcion(e);
        }
    }

    public GeneroDTO buscarGenero(int id) throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet rs = connectionManager.queryDB("select * from GENERO where ID= '" + id + "'");
            connectionManager.close();

            if (rs.next())
                return new GeneroDTO(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"));
            else
                return null;
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        }
    }
}
package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.PeliculaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeliculaDAOImp implements IPeliculaDAO {

    private ConnectionManager connectionManager;

    public PeliculaDAOImp() throws DAOExcepcion {
        super();
        try {
            connectionManager = new ConnectionManager("dbvideoclub");
        } catch (ClassNotFoundException e) {
            throw new DAOExcepcion(e);
        }
    }

    public PeliculaDTO buscarPelicula(int id) throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet rs = connectionManager.queryDB("select * from PELICULA where ID= '" + id + "'");
            connectionManager.close();

            if (rs.next())
                return new PeliculaDTO(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getInt("DIRECTOR"),
                        rs.getInt("GENERO"),
                        rs.getInt("STOCK"));
            else
                return null;
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        }
    }
}
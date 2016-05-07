
package persistencia;

import excepciones.DAOExcepcion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import persistencia.dto.ReservaDTO;

public class ReservaDAOImp implements IReservaDAO {

    private ConnectionManager connectionManager;
    protected LocalDateTime dateTime;

    public ReservaDAOImp() throws DAOExcepcion {
        super();
        try {
            connectionManager = new ConnectionManager("dbvideoclub");
        } catch (ClassNotFoundException e) {
            throw new DAOExcepcion(e);
        }
    }

    public ReservaDTO buscarReserva(int id) throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet rs = connectionManager.queryDB("select * from RESERVA where ID= '" + id + "'");
            connectionManager.close();

            if (rs.next())
                return new ReservaDTO(
                        rs.getInt("ID"),
                        dateTime =
			LocalDateTime.of(rs.getDate("FECHA").toLocalDate(),
			rs.getTime("FECHA").toLocalTime()),
                        rs.getInt("PELICULA"),
                        rs.getInt("CLIENTE"),
                        rs.getInt("EMPLEADO"));
            else
                return null;
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        }
    }

    public void crearReserva(ReservaDTO reserva) throws DAOExcepcion {
		try {
			connectionManager.connect();
			connectionManager
					.updateDB("insert into RESERVA (ID, FECHA, PELICULA, CLIENTE, EMPLEADO) values('"
							+ reserva.getFecha()
							+ "','"
							+ reserva.getPelicula()
							+ "','"
							+ reserva.getCliente()
							+ "', '"
							+ reserva.getEmpleado() + "')");
			connectionManager.close();
		} catch (Exception e) {
			throw new DAOExcepcion(e);
		}
	}
}

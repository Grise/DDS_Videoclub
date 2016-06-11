package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.ReservaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAOImp implements IReservaDAO {

    private ConnectionManager connectionManager;
    private LocalDateTime dateTime;

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
                        dateTime = LocalDateTime.of(rs.getDate("FECHA").toLocalDate(), rs.getTime("FECHA").toLocalTime()),
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

    public List<ReservaDTO> obtenerReservas() throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet rs = connectionManager.queryDB("select * from RESERVA");
            connectionManager.close();

            List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();

            try {
                while (rs.next()) {

                    ReservaDTO reservaDTO = new ReservaDTO(
                            rs.getInt("ID"),
                            dateTime = LocalDateTime.of(rs.getDate("FECHA").toLocalDate(), rs.getTime("FECHA").toLocalTime()),
                            rs.getInt("PELICULA"),
                            rs.getInt("CLIENTE"),
                            rs.getInt("EMPLEADO"));
                    listaReservaDTO.add(reservaDTO);
                }
                return listaReservaDTO;
            } catch (Exception e) {
                throw new DAOExcepcion(e);
            }
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        } catch (DAOExcepcion e) {
            throw e;
        }

    }
}
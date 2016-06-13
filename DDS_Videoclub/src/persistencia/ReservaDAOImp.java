package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.ReservaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAOImp implements IReservaDAO {

    private ConnectionManager connectionManager;

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
                        rs.getDate("FECHA_INICIO"),
                        rs.getDate("FECHA_FIN"),
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
            connectionManager.updateDB("insert into RESERVA (FECHA_INICIO, FECHA_FIN, PELICULA, CLIENTE, EMPLEADO) values('"
                            + reserva.getFechaInicio()
                            + "','"
                            + reserva.getFechaFin()
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

    public List<ReservaDTO> obtenerReservasFinalizadas() throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet rs = connectionManager.queryDB("select * from RESERVA WHERE DEVOLUCION_DANNADA IS NOT NULL");
            connectionManager.close();

            List<ReservaDTO> listaReservaDTO = new ArrayList<>();

            try {
                while (rs.next()) {

                    ReservaDTO reservaDTO = new ReservaDTO(
                            rs.getInt("ID"),
                            rs.getDate("FECHA_INICIO"),
                            rs.getDate("FECHA_FIN"),
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
        }
    }

    public List<ReservaDTO> obtenerReservasActivas() throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet rs = connectionManager.queryDB("select * from RESERVA WHERE DEVOLUCION_DANNADA IS NULL");
            connectionManager.close();

            List<ReservaDTO> listaReservaDTO = new ArrayList<>();

            try {
                while (rs.next()) {

                    ReservaDTO reservaDTO = new ReservaDTO(
                            rs.getInt("ID"),
                            rs.getDate("FECHA_INICIO"),
                            rs.getDate("FECHA_FIN"),
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
        }
    }

    public void eliminarReserva(int id) throws DAOExcepcion {
        try {
            connectionManager.connect();
            connectionManager.updateDB("delete from RESERVA where ID= '" + id + "'");
            connectionManager.close();
        } catch (Exception e) {
            throw new DAOExcepcion(e);
        }
    }

    @Override
    public void finalizarReservaSinDannos(int id, String comentarios) throws DAOExcepcion {
        try {
            connectionManager.connect();
            connectionManager.updateDB("update RESERVA set DEVOLUCION_DANNADA='0', COMENTARIOS='" + comentarios + "' where id=" + id);
            connectionManager.close();
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        }
    }

    @Override
    public void finalizarReservaConDannos(int id, String comentarios) throws DAOExcepcion {
        try {
            connectionManager.connect();
            connectionManager.updateDB("update RESERVA set DEVOLUCION_DANNADA='1', COMENTARIOS='" + comentarios + "' where id=" + id);
            connectionManager.close();
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        }
    }
}
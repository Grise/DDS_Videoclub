package persistencia;

import excepciones.DAOExcepcion;
import java.util.List;
import persistencia.dto.ReservaDTO;

public interface IReservaDAO {

    ReservaDTO buscarReserva(int id) throws DAOExcepcion;

    void crearReserva(ReservaDTO reserva) throws DAOExcepcion;
    
    List <ReservaDTO> obtenerReservasFinalizadas() throws DAOExcepcion;

    List <ReservaDTO> obtenerReservasActivas() throws DAOExcepcion;

    void eliminarReserva(int id) throws DAOExcepcion;

    void finalizarReservaSinDannos(int id, String comentarios) throws DAOExcepcion;

    void finalizarReservaConDannos(int id, String comentarios) throws DAOExcepcion;
}
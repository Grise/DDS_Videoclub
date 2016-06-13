package persistencia;

import excepciones.DAOExcepcion;
import java.util.List;
import persistencia.dto.ReservaDTO;

public interface IReservaDAO {

    ReservaDTO buscarReserva(int id) throws DAOExcepcion;

    void crearReserva(ReservaDTO reserva) throws DAOExcepcion;
    
    public List <ReservaDTO> obtenerReservas() throws DAOExcepcion;

    void eliminarReserva(int id) throws DAOExcepcion;

}
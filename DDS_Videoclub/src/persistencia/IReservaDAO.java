package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.ReservaDTO;

public interface IReservaDAO {

    ReservaDTO buscarReserva(int id) throws DAOExcepcion;

    void crearReserva(ReservaDTO empleado) throws DAOExcepcion;

}
package persistencia;

import excepciones.DAOExcepcion;
import java.util.List;
import persistencia.dto.ReservaDTO;

public interface IReservaDAO {

    ReservaDTO buscarReserva(int id) throws DAOExcepcion;

    void crearReserva(ReservaDTO empleado) throws DAOExcepcion;
    
    public List <ReservaDTO> obtenerReservas() throws DAOExcepcion;

}
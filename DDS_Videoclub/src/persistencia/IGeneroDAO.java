package persistencia;

import excepciones.DAOExcepcion;
import java.util.List;
import persistencia.dto.GeneroDTO;

public interface IGeneroDAO {

    GeneroDTO buscarGenero(int id) throws DAOExcepcion;
    
    public List <GeneroDTO> obtenerGeneros() throws DAOExcepcion;

}
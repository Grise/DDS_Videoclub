package persistencia;

import excepciones.DAOExcepcion;
import java.util.List;
import persistencia.dto.GeneroDTO;

public interface IGeneroDAO {

    void crearGenero(GeneroDTO generoDTO) throws DAOExcepcion;

    GeneroDTO buscarGenero(int id) throws DAOExcepcion;
    
    public List <GeneroDTO> obtenerGeneros() throws DAOExcepcion;

}
package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.GeneroDTO;

public interface IGeneroDAO {

    GeneroDTO buscarGenero(int id) throws DAOExcepcion;

}
package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.GeneroDTO;

interface IGeneroDAO {

    GeneroDTO buscarGenero(int id) throws DAOExcepcion;

}
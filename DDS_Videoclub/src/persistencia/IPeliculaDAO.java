package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.PeliculaDTO;

public interface IPeliculaDAO {

    PeliculaDTO buscarPelicula(int id) throws DAOExcepcion;

}
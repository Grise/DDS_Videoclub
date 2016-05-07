package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.PeliculaDTO;

interface IPeliculaDAO {

    PeliculaDTO buscarPelicula(int id) throws DAOExcepcion;

}
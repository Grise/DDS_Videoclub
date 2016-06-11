package persistencia;

import excepciones.DAOExcepcion;
import java.util.List;
import persistencia.dto.PeliculaDTO;

public interface IPeliculaDAO {

    PeliculaDTO buscarPelicula(int id) throws DAOExcepcion;
    
    public List <PeliculaDTO> obtenerPeliculas() throws DAOExcepcion;

}
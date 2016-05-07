
package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.PeliculaDTO;

public interface IPeliculaDAO {
    
    public PeliculaDTO buscarPelicula(int id)throws DAOExcepcion;
    
}
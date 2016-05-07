
package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.GeneroDTO;

public interface IGeneroDAO {
    
    public GeneroDTO buscarGenero(int id)throws DAOExcepcion;
    
}


package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.DirectorDTO;

public interface IDirectorDAO {
    
    public DirectorDTO buscarDirector(int id)throws DAOExcepcion;
    
}

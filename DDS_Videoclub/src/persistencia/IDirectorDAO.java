
package persistencia;

import excepciones.DAOExcepcion;
import java.util.List;
import persistencia.dto.DirectorDTO;

public interface IDirectorDAO {

    DirectorDTO buscarDirector(int id) throws DAOExcepcion;
    
    public List <DirectorDTO> obtenerDirectores() throws DAOExcepcion;

}

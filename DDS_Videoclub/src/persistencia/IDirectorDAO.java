
package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.DirectorDTO;

public interface IDirectorDAO {

    DirectorDTO buscarDirector(int id) throws DAOExcepcion;

}

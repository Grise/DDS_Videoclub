
package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.DirectorDTO;

interface IDirectorDAO {

    DirectorDTO buscarDirector(int id) throws DAOExcepcion;

}

package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.PersonaDTO;

import java.util.List;

public interface IPersonaDAO {

    PersonaDTO buscarPersona(int id) throws DAOExcepcion;

    void crearPersona(PersonaDTO personaDTO) throws DAOExcepcion;

    void eliminarPersona(int id) throws DAOExcepcion;

    List<PersonaDTO> obtenerDirectores() throws DAOExcepcion;

    List<PersonaDTO> obtenerClientes() throws DAOExcepcion;

    List<PersonaDTO> obtenerEmpleados() throws DAOExcepcion;
}
package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.ClienteDTO;

public interface IClienteDAO {

    ClienteDTO buscarCliente(int id) throws DAOExcepcion;

    void crearCliente(ClienteDTO clienteDTO) throws DAOExcepcion;
}

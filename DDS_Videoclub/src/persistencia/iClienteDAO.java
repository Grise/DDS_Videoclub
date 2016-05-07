package persistencia;

import persistencia.dto.ClienteDTO;
import excepciones.*;

interface IClienteDAO {
    ClienteDTO buscarCliente(int id) throws DAOExcepcion;
    void crearCliente(ClienteDTO cliente) throws DAOExcepcion;
}

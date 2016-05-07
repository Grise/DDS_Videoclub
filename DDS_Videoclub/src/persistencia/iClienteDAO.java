package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.ClienteDTO;

interface IClienteDAO {

    ClienteDTO buscarCliente(int id) throws DAOExcepcion;

    void cliente(ClienteDTO clienteDTO) throws DAOExcepcion;

}
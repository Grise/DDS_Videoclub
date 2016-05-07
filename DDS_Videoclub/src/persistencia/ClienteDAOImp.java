package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.ClienteDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

class ClienteDAOImp {
    private ConnectionManager connectionManager;

    public ClienteDAOImp() throws DAOExcepcion {
        super();
        try {
            connectionManager = new ConnectionManager("dbvideoclub");
        } catch (ClassNotFoundException e) {
            throw new DAOExcepcion(e);
        }
    }

    public ClienteDTO buscarCliente(int id) throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet resultSet = connectionManager.queryDB("select * from CLIENTE where ID=" + id);
            connectionManager.close();
            if (resultSet.next()) {
                return new ClienteDTO(
                        resultSet.getInt("ID"),
                        resultSet.getString("NOMBRE")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        }
    }

    public void crearCliente(ClienteDTO clienteDTO) throws DAOExcepcion {
        try {
            connectionManager.connect();
            connectionManager.updateDB("insert into CLIENTE(nombre) values ('" + clienteDTO.getNombre() + "')");
            connectionManager.close();
        } catch (Exception e) {
            throw new DAOExcepcion(e);
        }
    }
}
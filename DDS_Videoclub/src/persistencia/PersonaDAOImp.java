package persistencia;

import excepciones.DAOExcepcion;
import persistencia.dto.PersonaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImp implements IPersonaDAO {
    private ConnectionManager connectionManager;

    public PersonaDAOImp() throws DAOExcepcion {
        super();
        try {
            connectionManager = new ConnectionManager("dbvideoclub");
        } catch (ClassNotFoundException e) {
            throw new DAOExcepcion(e);
        }
    }

    public PersonaDTO buscarPersona(int id) throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet resultSet = connectionManager.queryDB("select * from PERSONA where ID= '" + id + "'");
            connectionManager.close();
            if (resultSet.next()) {
                return new PersonaDTO(
                        resultSet.getInt("ID"),
                        resultSet.getString("DNI"),
                        resultSet.getString("NOMBRE"),
                        resultSet.getString("TIPO")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        }
    }

    public void crearPersona(PersonaDTO personaDTO) throws DAOExcepcion {
        try {
            connectionManager.connect();
            connectionManager.updateDB("insert into PERSONA (DNI, NOMBRE, TIPO) values ('"
                    + personaDTO.getDni()
                    + "','"
                    + personaDTO.getNombre()
                    + "','"
                    + personaDTO.getTipo()
                    + "')");
            connectionManager.close();
        } catch (Exception e) {
            throw new DAOExcepcion(e);
        }
    }

    public List<PersonaDTO> obtenerDirectores() throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet resultSet = connectionManager.queryDB("select * from PERSONA where TIPO= 'DIRECTOR'");
            connectionManager.close();

            List<PersonaDTO> listaPersonasDTO = new ArrayList<>();

            try {
                while (resultSet.next()) {

                    PersonaDTO personaDTO = new PersonaDTO(
                            resultSet.getInt("ID"),
                            resultSet.getString("DNI"),
                            resultSet.getString("NOMBRE"),
                            resultSet.getString("TIPO")
                    );
                    listaPersonasDTO.add(personaDTO);
                }
                return listaPersonasDTO;
            } catch (Exception e) {
                throw new DAOExcepcion(e);
            }
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        } catch (DAOExcepcion e) {
            throw e;
        }
    }

    public List<PersonaDTO> obtenerEmpleados() throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet resultSet = connectionManager.queryDB("select * from PERSONA where TIPO= 'EMPLEADO'");
            connectionManager.close();

            List<PersonaDTO> listaPersonasDTO = new ArrayList<>();

            try {
                while (resultSet.next()) {

                    PersonaDTO personaDTO = new PersonaDTO(
                            resultSet.getInt("ID"),
                            resultSet.getString("DNI"),
                            resultSet.getString("NOMBRE"),
                            resultSet.getString("TIPO")
                    );
                    listaPersonasDTO.add(personaDTO);
                }
                return listaPersonasDTO;
            } catch (Exception e) {
                throw new DAOExcepcion(e);
            }
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        } catch (DAOExcepcion e) {
            throw e;
        }
    }

    public List<PersonaDTO> obtenerClientes() throws DAOExcepcion {
        try {
            connectionManager.connect();
            ResultSet resultSet = connectionManager.queryDB("select * from PERSONA where TIPO= 'CLIENTE'");
            connectionManager.close();

            List<PersonaDTO> listaPersonasDTO = new ArrayList<>();

            try {
                while (resultSet.next()) {

                    PersonaDTO personaDTO = new PersonaDTO(
                            resultSet.getInt("ID"),
                            resultSet.getString("DNI"),
                            resultSet.getString("NOMBRE"),
                            resultSet.getString("TIPO")
                    );
                    listaPersonasDTO.add(personaDTO);
                }
                return listaPersonasDTO;
            } catch (Exception e) {
                throw new DAOExcepcion(e);
            }
        } catch (SQLException e) {
            throw new DAOExcepcion(e);
        } catch (DAOExcepcion e) {
            throw e;
        }
    }
}
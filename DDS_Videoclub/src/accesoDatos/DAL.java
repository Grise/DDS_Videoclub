package accesoDatos;

import excepciones.DAOExcepcion;
import java.util.List;
import persistencia.*;
import persistencia.dto.PersonaDTO;
import persistencia.dto.DirectorDTO;
import persistencia.dto.EmpleadoDTO;
import persistencia.dto.GeneroDTO;
import persistencia.dto.PeliculaDTO;
import persistencia.dto.ReservaDTO;

public class DAL {

    private IPersonaDAO personaDAO = new PersonaDAOImp();
    private IPeliculaDAO peliculaDAO = new PeliculaDAOImp();
    private IReservaDAO reservaDAO = new ReservaDAOImp();
    private IGeneroDAO generoDAO = new GeneroDAOImp();

    private static DAL INSTANCIA;

    static {
        try {
            INSTANCIA = new DAL();
        } catch (DAOExcepcion e) {
            e.printStackTrace();
        }
    }

    public static DAL dameDAL() {
        return INSTANCIA;
    }

    public DAL() throws DAOExcepcion {
        super();
        this.personaDAO = new PersonaDAOImp();
        this.peliculaDAO = new PeliculaDAOImp();
        this.reservaDAO = new ReservaDAOImp();
        this.generoDAO = new GeneroDAOImp();
    }
    
    // PERSONA
    
    public PersonaDTO buscarPersona(int id) {
        try {
            return personaDAO.buscarPersona(id);
        } catch (DAOExcepcion e) {
            return null;
        }
    }

    public void crearPersona(PersonaDTO persona) {
        try {
            personaDAO.crearPersona(persona);
        } catch (DAOExcepcion e) {}
    }
    
    // DIRECTOR

    public List<PersonaDTO> obtenerDirectores() {
        try {
            return personaDAO.obtenerDirectores();
        } catch (DAOExcepcion e) {
            return null;
        }
    }

    public List<PersonaDTO> obtenerClientes() {
        try {
            return personaDAO.obtenerClientes();
        } catch (DAOExcepcion e) {
            return null;
        }
    }

    public List<PersonaDTO> obtenerEmpleados() {
        try {
            return personaDAO.obtenerEmpleados();
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    
    // GENERO
    
    public GeneroDTO buscarGenero(int id) {
        try {
            return generoDAO.buscarGenero(id);
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    
    public List<GeneroDTO> obtenerGeneros() {
        try {
            return generoDAO.obtenerGeneros();
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    
    // PELICULA
    
    public PeliculaDTO buscarPelicula(int id) {
        try {
            return peliculaDAO.buscarPelicula(id);
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    
    public List<PeliculaDTO> obtenerPeliculas() {
        try {
            return peliculaDAO.obtenerPeliculas();
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    
    // RESERVA
    
    public ReservaDTO buscarReserva(int id) {
        try {
            return reservaDAO.buscarReserva(id);
        } catch (DAOExcepcion e) {
            return null;
        }
    }

    public void crearReserva(ReservaDTO reserva) {
        try {
            reservaDAO.crearReserva(reserva);
        } catch (DAOExcepcion e) {}
    }
    
    public List<ReservaDTO> obtenerReservas() {
        try {
            return reservaDAO.obtenerReservas();
        } catch (DAOExcepcion e) {
            return null;
        }
    }
}

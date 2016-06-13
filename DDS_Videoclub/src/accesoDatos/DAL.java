package accesoDatos;

import excepciones.DAOExcepcion;
import persistencia.*;
import persistencia.dto.GeneroDTO;
import persistencia.dto.PeliculaDTO;
import persistencia.dto.PersonaDTO;
import persistencia.dto.ReservaDTO;

import java.util.List;

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

    public void eliminarPersona(int id) {
        try {
            personaDAO.eliminarPersona(id);
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

    public void crearGenero(GeneroDTO genero) {
        try {
            generoDAO.crearGenero(genero);
        } catch (DAOExcepcion e) {}
    }
    
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

    public void crearPelicula(PeliculaDTO pelicula) {
        try {
            peliculaDAO.crearPelicula(pelicula);
        } catch (DAOExcepcion e) {}
    }

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
    
    public List<ReservaDTO> obtenerReservasFinalizadas() {
        try {
            return reservaDAO.obtenerReservasFinalizadas();
        } catch (DAOExcepcion e) {
            return null;
        }
    }

    public List<ReservaDTO> obtenerReservasActivas() {
        try {
            return reservaDAO.obtenerReservasActivas();
        } catch (DAOExcepcion e) {
            return null;
        }
    }

    public void eliminarReserva(int id) {
        try {
            reservaDAO.eliminarReserva(id);
        } catch (DAOExcepcion e) {}
    }

    public void finalizarReservaSinDannos(int id, String comentarios) {
        try {
            reservaDAO.finalizarReservaSinDannos(id, comentarios);
        } catch (DAOExcepcion e) {}
    }

    public void finalizarReservaConDannos(int id, String comentarios) {
        try {
            reservaDAO.finalizarReservaConDannos(id, comentarios);
        } catch (DAOExcepcion e) {}
    }
}

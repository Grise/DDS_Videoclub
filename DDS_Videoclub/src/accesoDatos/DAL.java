package accesoDatos;

import excepciones.DAOExcepcion;
import java.util.List;
import persistencia.*;
import persistencia.dto.ClienteDTO;
import persistencia.dto.DirectorDTO;
import persistencia.dto.EmpleadoDTO;
import persistencia.dto.GeneroDTO;
import persistencia.dto.PeliculaDTO;
import persistencia.dto.ReservaDTO;

public class DAL {

    private IClienteDAO clienteDAO = new ClienteDAOImp();
    private IEmpleadoDAO empleadoDAO = new EmpleadoDAOImp();
    private IDirectorDAO directorDAO = new DirectorDAOImp();
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
        this.clienteDAO = new ClienteDAOImp();
        this.empleadoDAO = new EmpleadoDAOImp();
        this.directorDAO = new DirectorDAOImp();
        this.peliculaDAO = new PeliculaDAOImp();
        this.reservaDAO = new ReservaDAOImp();
        this.generoDAO = new GeneroDAOImp();
    }
    
    // CLIENTE
    
    public ClienteDTO buscarCliente(int id) {
        try {
            return clienteDAO.buscarCliente(id);
        } catch (DAOExcepcion e) {
            return null;
        }
    }

    public void crearCliente(ClienteDTO cliente) {
        try {
            clienteDAO.crearCliente(cliente);
        } catch (DAOExcepcion e) {}
    }
    
    // DIRECTOR
    
    public DirectorDTO buscarDirector(int id) {
        try {
            return directorDAO.buscarDirector(id);
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    
    public List<DirectorDTO> obtenerDirectores() {
        try {
            return directorDAO.obtenerDirectores();
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    
    // EMPLEADO
    
    public EmpleadoDTO buscarEmpleado(int id) {
        try {
            return empleadoDAO.buscarEmpleado(id);
        } catch (DAOExcepcion e) {
            return null;
        }
    }

    public void crearEmpleado(EmpleadoDTO empleado) {
        try {
            empleadoDAO.crearEmpleado(empleado);
        } catch (DAOExcepcion e) {}
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

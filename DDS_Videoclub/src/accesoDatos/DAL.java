package accesoDatos;

import excepciones.DAOExcepcion;
import persistencia.*;

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
}

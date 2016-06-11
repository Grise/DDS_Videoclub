
package logica;

import accesoDatos.DAL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import persistencia.dto.DirectorDTO;
import persistencia.dto.GeneroDTO;
import persistencia.dto.PeliculaDTO;
import persistencia.dto.ReservaDTO;

public final class AlquilerPeliculas {
    
    private AlquilerPeliculas Alquiler;
    private static AlquilerPeliculas INSTANCIA = new AlquilerPeliculas();
    private DAL dal;
    private List<Empleado> listaEmpleados = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<Pelicula> listaPeliculas = new ArrayList<>();
    private Hashtable<Integer, Director> listaDirectores = new Hashtable<>();
    private Hashtable<Integer, Genero> listaGeneros = new Hashtable<>();
    
    private AlquilerPeliculas() {
        this.dal = DAL.dameDAL();
        cargaSistema();
    }
    
    public static AlquilerPeliculas dameAlquilerPeliculasLogica() {
        return INSTANCIA;
    }
    
    // GETTERS Y SETTERS

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Hashtable<Integer, Director> getListaDirectores() {
        return listaDirectores;
    }

    public void setListaDirectores(Hashtable<Integer, Director> listaDirectores) {
        this.listaDirectores = listaDirectores;
    }

    public Hashtable<Integer, Genero> getListaGeneros() {
        return listaGeneros;
    }

    public void setListaGeneros(Hashtable<Integer, Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }
    
    // PRECARGA EN MEMORIA
    
    private void cargaGeneros() {
        List<GeneroDTO> listaGenerosDTO = dal.obtenerGeneros();
        for (GeneroDTO generoDTO : listaGenerosDTO) {
            annadirGenero(new Genero(generoDTO.getId(),
                    generoDTO.getNombre()));
        }

    }
    
    private void cargaDirectores() {
        List<DirectorDTO> listaDirectoresDTO = dal.obtenerDirectores();
        for (DirectorDTO directorDTO : listaDirectoresDTO) {
            annadirDirector(new Director(directorDTO.getId(),
                    directorDTO.getNombre()));
        }

    }
    
    private void cargaPeliculas() {
        List<PeliculaDTO> listaPeliculasDTO = dal.obtenerPeliculas();
        for (PeliculaDTO peliculaDTO : listaPeliculasDTO) {
            annadirPelicula(new Pelicula(peliculaDTO.getId(),
                    peliculaDTO.getNombre(),
                    peliculaDTO.getAnno(),
                    buscarDirector(peliculaDTO.getDirector()),
                    buscarGenero(peliculaDTO.getGenero()),
                    peliculaDTO.getStock()));
        }

    }
    
    private void cargaReservas() {
        List<ReservaDTO> listaReservasDTO = dal.obtenerReservas();
        for (ReservaDTO reservaDTO : listaReservasDTO) {
            annadirReserva(new Reserva(reservaDTO.getId(),
                    reservaDTO.getFecha(),
            buscarPelicula(reservaDTO.getPelicula()),
            buscarCliente(reservaDTO.getCliente()),
            buscarEmpleado(reservaDTO.getEmpleado())));
        }

    }
    
    private void cargaSistema() {
        cargaGeneros();
        cargaDirectores();
        cargaPeliculas();
        //cargaReservas();
    }
    
    // DIRECTOR
    
    public Director buscarDirector(Integer id) {
        return listaDirectores.get(id);

    }

    public void annadirDirector(Director director) {
        listaDirectores.put(director.getId(), director);

    }

    public void eliminarDirector(Director director) {
        listaDirectores.remove(director.getId());

    }
    
    private void obtenerDirectores() {
        List<DirectorDTO> directorDTO = dal.obtenerDirectores();
    }
    
    public List<Director> listarDirectores() {
        return new ArrayList<>(listaDirectores.values());
    }
    
    // GENERO
    
    public Genero buscarGenero(Integer id) {
        return listaGeneros.get(id);

    }

    public void annadirGenero(Genero genero) {
        listaGeneros.put(genero.getId(), genero);

    }

    public void eliminarGenero(Genero genero) {
        listaGeneros.remove(genero.getId());

    }
    
    private void obtenerGeneros() {
        List<GeneroDTO> generoDTO = dal.obtenerGeneros();
    }
    
    public List<Genero> listarGeneros() {
        return new ArrayList<>(listaGeneros.values());
    }
    
    // PELICULA
    
    public Pelicula buscarPelicula(Integer id) {
        return listaPeliculas.get(id);

    }

    public void annadirPelicula(Pelicula pelicula) {
        listaPeliculas.add(pelicula);

    }

    public void eliminarPelicula(Pelicula pelicula) {
        listaPeliculas.remove(pelicula);

    }
    
    private void obtenerPeliculas() {
        List<PeliculaDTO> peliculaDTO = dal.obtenerPeliculas();
    }
    
    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }
    
    // RESERVA
    
    public Reserva buscarReserva(Integer id) {
        return listaReservas.get(id);

    }

    public void annadirReserva(Reserva reserva) {
        listaReservas.add(reserva);

    }

    public void eliminarReserva(Reserva reserva) {
        listaReservas.remove(reserva);

    }
    
    private void obtenerReservas() {
        List<ReservaDTO> reservaDTO = dal.obtenerReservas();
    }
    
    public List<Reserva> listarReservas() {
        return listaReservas;
    }
    
    // CLIENTE
    
    public Cliente buscarCliente(Integer id) {
        return listaClientes.get(id);

    }

    public void annadirCliente(Cliente cliente) {
        listaClientes.add(cliente);

    }

    public void eliminarCliente(Cliente cliente) {
        listaClientes.remove(cliente);

    }
    
    public List<Cliente> listarClientes() {
        return listaClientes;
    }
    
    // EMPLEADO
    
    public Empleado buscarEmpleado(Integer id) {
        return listaEmpleados.get(id);

    }

    public void annadirEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);

    }

    public void eliminarEmpleado(Empleado empleado) {
        listaEmpleados.remove(empleado);

    }
    
    public List<Empleado> listarEmpleados() {
        return listaEmpleados;
    }
}

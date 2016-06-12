
package logica;

import accesoDatos.DAL;
import persistencia.dto.GeneroDTO;
import persistencia.dto.PeliculaDTO;
import persistencia.dto.PersonaDTO;
import persistencia.dto.ReservaDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AlquilerPeliculas {

    private AlquilerPeliculas Alquiler;
    private static AlquilerPeliculas INSTANCIA = new AlquilerPeliculas();
    private DAL dal;
    private List<Empleado> listaEmpleados = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<Pelicula> listaPeliculas = new ArrayList<>();
    private List<Director> listaDirectores = new ArrayList<>();
    private List<Genero> listaGeneros = new ArrayList<>();
    PersonaFabrica personaFabrica = new PersonaFabrica();

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

    public List<Director> getListaDirectores() {
        return listaDirectores;
    }

    public void setListaDirectores(List<Director> listaDirectores) {
        this.listaDirectores = listaDirectores;
    }

    public List<Genero> getListaGeneros() {
        return listaGeneros;
    }

    public void setListaGeneros(List<Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(List<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
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
        List<PersonaDTO> listaDirectoresDTO = dal.obtenerDirectores();
        for (PersonaDTO directorDTO : listaDirectoresDTO) {
            annadirDirector((Director) personaFabrica.crearPersona(directorDTO.getId(), directorDTO.getDni(),
                    directorDTO.getNombre(), directorDTO.getTipo()));
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
        Iterator<Director> iterator = listaDirectores.iterator();
        while (iterator.hasNext()) {
            Director director = iterator.next();
            if (director.getId() == id)
                return director;
        }
        return null;
    }

    public void annadirDirector(Director director) {
        listaDirectores.add(director);

    }

    private void getListaDirectoresBD() {
        List<PersonaDTO> directorDTO = dal.obtenerDirectores();
    }

    // GENERO

    public Genero buscarGenero(Integer id) {
        return listaGeneros.get(id);

    }

    public Genero buscarGenero(String generoBuscar) {
        Iterator<Genero> iterator = listaGeneros.iterator();
        while (iterator.hasNext()) {
            Genero genero = iterator.next();
            if (genero.getNombre() == generoBuscar)
                return genero;
        }
        return null;
    }

    public void annadirGenero(Genero genero) {
        listaGeneros.add(genero);

    }

    private void getListaGenerosBD() {
        List<GeneroDTO> generoDTO = dal.obtenerGeneros();
    }

    // PELICULA

    public Pelicula buscarPelicula(Integer id) {
        return listaPeliculas.get(id);

    }

    public void annadirPelicula(Pelicula pelicula) {
        listaPeliculas.add(pelicula);

    }

    private void getListaPeliculasBD() {
        List<PeliculaDTO> peliculaDTO = dal.obtenerPeliculas();
    }

    // RESERVA

    public Reserva buscarReserva(Integer id) {
        return listaReservas.get(id);

    }

    public void annadirReserva(Reserva reserva) {
        listaReservas.add(reserva);

    }

    private void getListaReservasBD() {
        List<ReservaDTO> reservaDTO = dal.obtenerReservas();
    }

    // CLIENTE

    public Cliente buscarCliente(Integer id) {
        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getId() == id)
                return cliente;
        }
        return null;
    }

    public void annadirCliente(Cliente cliente) {
        listaClientes.add(cliente);

    }

    // EMPLEADO

    public Empleado buscarEmpleado(Integer id) {
        Iterator<Empleado> iterator = listaEmpleados.iterator();
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            if (empleado.getId() == id)
                return empleado;
        }
        return null;
    }

    public void annadirEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);

    }
}

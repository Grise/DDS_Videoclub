
package logica;

import accesoDatos.DAL;
import persistencia.dto.GeneroDTO;
import persistencia.dto.PeliculaDTO;
import persistencia.dto.PersonaDTO;
import persistencia.dto.ReservaDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class AlquilerPeliculas {

    private AlquilerPeliculas Alquiler;
    private static AlquilerPeliculas INSTANCIA = new AlquilerPeliculas();
    private DAL dal;
    private List<Empleado> listaEmpleados = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Reserva> listaReservasActivas = new ArrayList<>();
    private List<Reserva> listaReservasFinalizadas = new ArrayList<>();
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

    public List<Reserva> getListaReservasActivas() {
        return listaReservasActivas;
    }

    public List<Reserva> getListaReservasFinalizadas() {
        return listaReservasFinalizadas;
    }

    public void setListaReservasActivas(List<Reserva> listaReservas) {
        this.listaReservasActivas = listaReservas;
    }
    public void setListaReservasFinalizadas(List<Reserva> listaReservas) {
        this.listaReservasFinalizadas = listaReservas;
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

    private void cargaReservasFinalizadas() {
        List<ReservaDTO> listaReservasDTO = dal.obtenerReservasFinalizadas();
        for (ReservaDTO reservaDTO : listaReservasDTO) {
            annadirReservaFinalizada(new Reserva(reservaDTO.getId(),
                    reservaDTO.getFechaInicio(),
                    reservaDTO.getFechaFin(),
                    buscarPelicula(reservaDTO.getPelicula()),
                    buscarCliente(reservaDTO.getCliente()),
                    buscarEmpleado(reservaDTO.getEmpleado())));
        }

    }

    private void cargaReservasActivas() {
        List<ReservaDTO> listaReservasDTO = dal.obtenerReservasActivas();
        for (ReservaDTO reservaDTO : listaReservasDTO) {
            annadirReservaActiva(new Reserva(reservaDTO.getId(),
                    reservaDTO.getFechaInicio(),
                    reservaDTO.getFechaFin(),
                    buscarPelicula(reservaDTO.getPelicula()),
                    buscarCliente(reservaDTO.getCliente()),
                    buscarEmpleado(reservaDTO.getEmpleado())));
        }

    }

    private void cargaClientes() {
        List<PersonaDTO> listaClientesDTO = dal.obtenerClientes();
        for (PersonaDTO clienteDTO : listaClientesDTO) {
            annadirCliente((Cliente) personaFabrica.crearPersona(clienteDTO.getId(), clienteDTO.getDni(),
                    clienteDTO.getNombre(), clienteDTO.getTipo()));
        }

    }

    private void cargaEmpleados() {
        List<PersonaDTO> listaEmpleadosDTO = dal.obtenerEmpleados();
        for (PersonaDTO empleadoDTO : listaEmpleadosDTO) {
            annadirEmpleado((Empleado) personaFabrica.crearPersona(empleadoDTO.getId(), empleadoDTO.getDni(),
                    empleadoDTO.getNombre(), empleadoDTO.getTipo()));
        }

    }

    private void cargaSistema() {
        cargaGeneros();
        cargaDirectores();
        cargaPeliculas();
        cargaClientes();
        cargaEmpleados();
        cargaReservasFinalizadas();
        cargaReservasActivas();
    }

    // PERSONA

    public List<Persona> getListaPersonas(){
        List<Persona> combinado = new ArrayList<>();
        combinado.addAll(getListaClientes());
        combinado.addAll(getListaDirectores());
        combinado.addAll(getListaEmpleados());
        return combinado;
    }

    // DIRECTOR

    public Director buscarDirector(String directorBuscar) {
        Iterator<Director> iterator = listaDirectores.iterator();
        while (iterator.hasNext()) {
            Director director = iterator.next();
            if (director.getNombre() == directorBuscar)
                return director;
        }
        return null;
    }

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

    public void crearGenero(Genero genero) {
        GeneroDTO generoDTO = new GeneroDTO(genero.getId(),
                genero.getNombre());
        annadirGenero(genero);
        dal.crearGenero(generoDTO);

    }

    public Genero buscarGenero(Integer id) {
        return listaGeneros.get(id);

    }

    public Genero buscarGenero(String generoBuscar) {
        Iterator<Genero> iterator = listaGeneros.iterator();
        while (iterator.hasNext()) {
            Genero genero = iterator.next();
            if (genero.getNombre().compareToIgnoreCase(generoBuscar)==0)
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

    public void crearPelicula(Pelicula pelicula) {
        PeliculaDTO peliculaDTO = new PeliculaDTO(pelicula.getId(),
                pelicula.getNombre(),
                pelicula.getAnno(),
                pelicula.getDirector().getId(),
                pelicula.getGenero().getId(),
                pelicula.getStock());
        annadirPelicula(pelicula);
        dal.crearPelicula(peliculaDTO);

    }

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

    public void crearReserva(Reserva reserva) {
        ReservaDTO reservaDTO = new ReservaDTO(reserva.getId(),
                reserva.getFechaInicio(),
                reserva.getFechaFin(),
                reserva.getPelicula().getId(),
                reserva.getCliente().getId(),
                reserva.getEmpleado().getId());
        annadirReservaActiva(reserva);
        dal.crearReserva(reservaDTO);

    }

    public Reserva buscarReserva(Integer id) {
        Iterator<Reserva> iterator = listaReservasActivas.iterator();
        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.getId() == id)
                return reserva;
        }
        Iterator<Reserva> iterator2 = listaReservasFinalizadas.iterator();
        while (iterator2.hasNext()) {
            Reserva reserva = iterator2.next();
            if (reserva.getId() == id)
                return reserva;
        }
        return null;
    }

    public void eliminarReserva(Integer id){
        listaReservas.remove(buscarReserva(id));
        listaReservasActivas.remove(buscarReserva(id));
        listaReservasFinalizadas.remove(buscarReserva(id));
        dal.eliminarReserva(id);
    }

    public void annadirReservaActiva(Reserva reserva) {
        listaReservasActivas.add(reserva);
        listaReservas.add(reserva);
    }

    public void annadirReservaFinalizada(Reserva reserva){
        listaReservasFinalizadas.add(reserva);
        listaReservas.add(reserva);
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

    public Cliente buscarCliente(String dni) {
        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (Objects.equals(cliente.getDni(), dni))
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

    public void eliminarPersona(Persona persona) {
        if (persona instanceof Cliente){
            Iterator<Cliente> iterator = listaClientes.iterator();
            while (iterator.hasNext()) {
                Cliente cliente = iterator.next();
                if (cliente.getId() == persona.getId()) {
                    listaClientes.remove(cliente);
                    break;
                }
            }
        }
        if (persona instanceof Empleado) {
            Iterator<Empleado> iterator = listaEmpleados.iterator();
            while (iterator.hasNext()) {
                Empleado empleado = iterator.next();
                if (empleado.getId() == persona.getId()) {
                    listaEmpleados.remove(empleado);
                    break;
                }
            }
        }
        if (persona instanceof Director) {
            Iterator<Director> iterator = listaDirectores.iterator();
            while (iterator.hasNext()) {
                Director director = iterator.next();
                if (director.getId() == persona.getId()) {
                    listaDirectores.remove(director);
                    break;
                }
            }
        }
        dal.eliminarPersona(persona.getId());
    }

    public void finalizarReserva(Reserva reservaSeleccionada, String comentarios) {
        listaReservas.remove(reservaSeleccionada);
        dal.finalizarReservaSinDannos(reservaSeleccionada.getId(),comentarios);
    }

    public void finalizarReservaDannada(Reserva reservaSeleccionada, String comentarios) {
        listaReservas.remove(reservaSeleccionada);
        dal.finalizarReservaConDannos(reservaSeleccionada.getId(),comentarios);

    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void crearPersona(int id, String dni, String nombre, String tipo) {
        PersonaFabrica personaFabrica = new PersonaFabrica();
        Persona persona = personaFabrica.crearPersona(id, dni, nombre, tipo);
        if (tipo.equalsIgnoreCase("DIRECTOR")) {
            annadirDirector((Director) persona);
        }
        if (tipo.equalsIgnoreCase("CLIENTE")) {
            annadirCliente((Cliente) persona);
        }
        if (tipo.equalsIgnoreCase("EMPLEADO")) {
            annadirEmpleado((Empleado) persona);
        }
        PersonaDTO personaDTO = new PersonaDTO(id, dni, nombre, tipo);
        dal.crearPersona(personaDTO);

    }
}

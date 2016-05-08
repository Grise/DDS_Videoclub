package logica;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private LocalDateTime fecha;
    private Pelicula pelicula;
    private Cliente cliente;
    private Empleado empleado;

    public Reserva(int id, LocalDateTime fecha, Pelicula pelicula, Cliente cliente, Empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.pelicula = pelicula;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
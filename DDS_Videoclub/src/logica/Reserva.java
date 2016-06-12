package logica;

import java.util.Date;

public class Reserva {
    private int id;
    private Date fechaInicio;
    private Date fechaFin;
    private Pelicula pelicula;
    private Cliente cliente;
    private Empleado empleado;

    public Reserva(int id, Date fechaInicio, Date fechaFin, Pelicula pelicula, Cliente cliente, Empleado empleado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pelicula = pelicula;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
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

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
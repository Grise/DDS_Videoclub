package persistencia.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class ReservaDTO {
    private Date fechaInicio, fechaFin;
    private int id, pelicula, cliente, empleado;

    public ReservaDTO(int id, Date fechaInicio, Date fechaFin, int pelicula, int cliente, int empleado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pelicula = pelicula;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPelicula() {
        return pelicula;
    }

    public void setPelicula(int pelicula) {
        this.pelicula = pelicula;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }
}
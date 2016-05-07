package persistencia.dto;

import java.time.LocalDateTime;

public class ReservaDTO {
    private LocalDateTime fecha;
    private int id, pelicula, cliente, empleado;

    public ReservaDTO(LocalDateTime fecha, int id, int pelicula, int cliente, int empleado) {
        this.fecha = fecha;
        this.id = id;
        this.pelicula = pelicula;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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

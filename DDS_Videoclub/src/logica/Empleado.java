package logica;

public class Empleado extends Persona{
    private int id;
    private String nombre, dni, tipo;

    public Empleado(int id, String dni, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
package logica;

public class Director extends Persona {
    private int id;
    private String dni, nombre, tipo;

    public Director(int id, String dni, String nombre, String tipo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
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
}
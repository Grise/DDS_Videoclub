package logica;

import java.util.ArrayList;

public class Genero {
    private int id;
    private String nombre;

    public Genero(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Genero(String nombre) {
        this.nombre = nombre;
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

}
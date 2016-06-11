package logica;

import java.util.ArrayList;

class Director extends Persona {
    private int id;
    private String nombre;
    private ArrayList<Pelicula> pelicula;

    public Director(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Director(String nombre) {
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
    
    // Metodos para tratar lista peliculas
    
    public void addPelicula(Pelicula p) {
        pelicula.add(p);
    }

    public void deletePelicula(Pelicula p) {
        pelicula.remove(pelicula.indexOf(p));
    }

    public Pelicula getPelicula(int id) {
        for (Pelicula p : pelicula) {
            if (p.getId() == id) {
                return p;
            }

        }
        return null;
    }
    
    public ArrayList<Pelicula> getPelicula() {
        return pelicula;
    }

    public void setCoche(ArrayList<Pelicula> coche) {
        this.pelicula = coche;
    }

}
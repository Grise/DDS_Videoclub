
package logica;

public class Pelicula {
    private int id;
    private String nombre;
    private Director director;
    private Genero genero;
    private int stock;

    public Pelicula(int id, String nombre, Director director, Genero genero, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Director getDirector() {
        return director;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}

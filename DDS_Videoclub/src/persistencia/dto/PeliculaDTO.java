package persistencia.dto;

public class PeliculaDTO {
    private String nombre;
    private int id, anno, director, genero, stock;

    public PeliculaDTO(int id, String nombre, int anno, int director, int genero, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.anno = anno;
        this.director = director;
        this.genero = genero;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getDirector() {
        return director;
    }

    public void setDirector(int director) {
        this.director = director;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
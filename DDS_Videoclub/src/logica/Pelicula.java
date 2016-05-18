package logica;

import java.util.ArrayList;

class Pelicula implements Subject {
    private int id;
    private String nombre;
    private Director director;
    private Genero genero;
    private int stock;
    private String estado;
    private static ArrayList<observador> observadores = new ArrayList<observador>();

    public Pelicula(int id, String nombre, Director director, Genero genero, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.stock = stock;
    }

    public Pelicula(String nombre, Director director, Genero genero, int stock){
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.stock = stock;
    }
    public Pelicula(String nombre, Director director, Genero genero, int stock, String estado){
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.stock = stock;
        this.estado = estado;
    }
    
    

    @Override
    public void attach(observador observador) {
        observadores.add(observador);
    }

    @Override
    public void dettach(observador observador) {
        observadores.remove(observador);
    }

    @Override

    public void notifyObservers() {
        for(int i=0; i<observadores.size();i++){
                observadores.get(i).update();
            }
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
    
    public String getEstado() {
        return estado;
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
    
    public void setEstado(String estado) {
        this.estado = estado;
        //se puede notificar aquicap
        
    }

    

}
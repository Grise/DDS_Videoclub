/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author ledrgb
 */
public class Videoclub {
    
    public void devolverPelicula(Pelicula pelicula){
        if(pelicula.getEstado().equals("DAÑADA")){
            pelicula.notifyObservers();
        }
    }
    
}













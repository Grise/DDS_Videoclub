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
public interface Subject {
    public void attach(observador observador);
    public void dettach(observador observador);
    public void notifyObservers();
    
}



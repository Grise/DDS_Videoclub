package logica;

import java.util.HashMap;

public class PersonaFabrica {
    private final HashMap<String, Persona> personaMap = new HashMap<>();

    public Persona getPersona(String tipoPersona, int id, String nombre) {
        if (tipoPersona == null)
            return null;

        if (tipoPersona.equalsIgnoreCase("CLIENTE")) {
            Cliente cliente = (Cliente) personaMap.get(nombre);
            if (cliente == null) {
                cliente = new Cliente(id, nombre);
                personaMap.put(nombre, cliente);
            }
            return cliente;
        }

        if (tipoPersona.equalsIgnoreCase("EMPLEADO")) {
            Empleado empleado = (Empleado) personaMap.get(nombre);
            if (empleado == null){
                empleado = new Empleado(id, nombre);
                personaMap.put(nombre, empleado);
            }
            return empleado;
        }

        if (tipoPersona.equalsIgnoreCase("DIRECTOR")) {
            Director director = (Director) personaMap.get(nombre);
            if (director == null){
                director = new Director(id, nombre);
                personaMap.put(nombre, director);
            }
            return director;
        }

        return null;
    }
}

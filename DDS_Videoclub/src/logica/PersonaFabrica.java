package logica;

import java.util.HashMap;

public class PersonaFabrica {
    private final HashMap<String, Persona> personaMap = new HashMap<>();

    public Persona crearPersona(int id, String dni, String nombre, String tipoPersona) {

        if (tipoPersona == null)
            return null;

        if (tipoPersona.equalsIgnoreCase("CLIENTE")) {
            Cliente cliente = (Cliente) personaMap.get(nombre);
            if (cliente == null) {
                cliente = new Cliente(id, dni, nombre, "CLIENTE");
                personaMap.put(nombre, cliente);
            }
            return cliente;
        }

        if (tipoPersona.equalsIgnoreCase("EMPLEADO")) {
            Empleado empleado = (Empleado) personaMap.get(nombre);
            if (empleado == null){
                empleado = new Empleado(id, dni, nombre, "EMPLEADO");
                personaMap.put(nombre, empleado);
            }
            return empleado;
        }

        if (tipoPersona.equalsIgnoreCase("DIRECTOR")) {
            Director director = (Director) personaMap.get(nombre);
            if (director == null){
                director = new Director(id, dni, nombre, "DIRECTOR");
                personaMap.put(nombre, director);
            }
            return director;
        }

        return null;
    }
}

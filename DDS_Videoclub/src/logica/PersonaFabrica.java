package logica;

public class PersonaFabrica {
    public Persona getPersona(String tipoPersona, int id, String nombre){
        if(tipoPersona == null)
            return null;

        if(tipoPersona.equalsIgnoreCase("CLIENTE"))
            return new Cliente(id, nombre);

        if(tipoPersona.equalsIgnoreCase("EMPLEADO"))
            return new Empleado(id, nombre);

        if(tipoPersona.equalsIgnoreCase("DIRECTOR"))
            return new Director(id, nombre);

        return null;
    }
}

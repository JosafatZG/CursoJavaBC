package ejemplostatic;

public class Persona {
    private String nombre;
    private int idPersona;
    private static int contadorPersonas;

    public Persona(String nombre){
        contadorPersonas++;
        idPersona = contadorPersonas;
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "Persona[idPersona: " + idPersona + ", nombre: " + nombre + "]";
    }

    public static int getContadorPersonas(){
        return contadorPersonas;
    }
}

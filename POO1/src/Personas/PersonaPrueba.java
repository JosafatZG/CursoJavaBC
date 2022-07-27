package Personas;

import java.sql.SQLOutput;

public class PersonaPrueba {
    public static void main(String[] args){

        Persona_ref p = new Persona_ref();
        p.cambiarNombre("Juan");
        imprimirNombre(p);
        modificarPersona(p);
        imprimirNombre(p);

        /*
        Persona p1 = new Persona();

        System.out.println("Valores por default del objeto Persona");
        p1.desplegarNombre();

        p1.nombre = "Juan";
        p1.apellidoPaterno = "Esparza";
        p1.apellidoMaterno = "Lara";

        System.out.println("\nNuevos valores del objeto Persona");
        p1.desplegarNombre();*/
    }

    public static void modificarPersona(Persona_ref arg){
        arg.cambiarNombre("Carlos");
    }

    public static void imprimirNombre(Persona_ref p){
        System.out.println("Valor recibido: " + p.obtenerNombre());
    }
}

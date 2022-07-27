package test;
import herencia.*;

import java.util.Date;

public class TestHerencia {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Wilfredo Melgar",'M',
                42, "San Salvador");
        imprimir(persona1);

        Empleado empleado1 = new Empleado("Carlos", 3000);
        //System.out.println(empleado1);
        //System.out.println(empleado1.obtenerDetalles());
        imprimir(empleado1);

        Empleado empleado2 = new Empleado("Jose", 4000);
        //System.out.println(empleado2);
        imprimir(empleado2);

        var fecha = new Date();
        Cliente cliente1 = new Cliente("Juan", 'M', 43,
                "Santa Tecla", fecha, true);
        //System.out.println(cliente1);
        imprimir(cliente1);
    }

    public static void imprimir(Persona persona){
        System.out.println(persona.obtenerDetalles());
    }
}

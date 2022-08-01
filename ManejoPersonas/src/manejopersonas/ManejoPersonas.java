package manejopersonas;

import datos.PersonasJDBC;
import domain.Persona;
import java.util.List;

public class ManejoPersonas {
    public static void main(String[] args) {
        PersonasJDBC personasJDBC = new PersonasJDBC();
        //Pruebas
        //personasJDBC.insert("Juan", "Juarez");
        //personasJDBC.update(2, "Nombre3", "Apellido3");
        //personasJDBC.delete(2);

        List<Persona> personas = personasJDBC.select();
        for(Persona persona : personas){
            System.out.print(persona);
            System.out.println("");
        }
    }
}

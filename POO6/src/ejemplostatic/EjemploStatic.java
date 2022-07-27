package ejemplostatic;

public class EjemploStatic {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan");
        Persona p2 = new Persona("Jose");
        Persona p3 = new Persona("Julian");

        System.out.println("Persona1: " + p1);
        System.out.println("Persona2: " + p2);
        System.out.println("Persona3: " + p3);
        System.out.println("Total personas: " + Persona.getContadorPersonas());
    }
}

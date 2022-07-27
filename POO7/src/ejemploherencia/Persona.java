package ejemploherencia;

public class Persona {
    //Atributos
    private String nombre;
    private char genero;
    private int edad;
    private String direccion;

    //Vacío
    public Persona(){ }

    //1 Argumento
    public Persona(String nombre){
        this.nombre = nombre;
    }

    //Completo
    public Persona(String nombre, char genero, int edad, String direccion) {
        this.nombre = nombre;
        this.genero = genero; //M-Masculino, F-Femenino
        this.edad = edad;
        this.direccion = direccion;
    }

    //Getters and Setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return this.genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

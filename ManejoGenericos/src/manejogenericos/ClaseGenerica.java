package manejogenericos;

//Definimos una clase generica con el operador diamante <>
public class ClaseGenerica<T> {
    //Definimos una variable tipo generico
    T objeto;

    //Constructor que inicializa el tipo a utilizar
    public ClaseGenerica(T objeto){
        this.objeto = objeto;
    }

    public void obtenerTipo(){
        System.out.println("El tipo T es: " + this.objeto.getClass().getName());
    }
}

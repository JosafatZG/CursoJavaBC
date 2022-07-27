package manejogenericos;

public class ManejoGenericos {
    public static void main(String[] args) {
        //Creamos una instancia de ClaseGenerica para Integer
        ClaseGenerica<Integer> objetoInt = new ClaseGenerica<>(15);
        objetoInt.obtenerTipo();

        //Creamos una instancia de ClaseGenerica para String
        ClaseGenerica<String> objetoStr = new ClaseGenerica<>("Prueba");
        objetoStr.obtenerTipo();
    }
}

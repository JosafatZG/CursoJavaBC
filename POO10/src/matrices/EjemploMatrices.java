package matrices;

public class EjemploMatrices {
    public static void main(String[] args) {
        //1. Declaramos e instanciamos una matriz de personas
        Persona personas[][] = new Persona[3][2];
        //2. Inicializamos los valores de la matriz de personas
        personas[0][0] = new Persona("Juan");
        personas[0][1] = new Persona("Armando");
        personas[1][0] = new Persona("Karla");
        personas[1][1] = new Persona("Laura");
        personas[2][0] = new Persona("Pedro");
        personas[2][1] = new Persona("Javier");

        //3. Leemos los valores de cada elemento de la matriz con un ciclo for anidado
        System.out.println("");
        for (int i = 0; i < personas.length; i++){
            for (int j = 0; j < personas[i].length; j++){
                System.out.println("Matriz personas indice: " + i + "-"
                + j + ": " + personas[i][j]);
            }
        }

        String nombres[][] = {{"Teresa", "Cesar", "William"}, {"Yesenia", "Esteban", "Maria"}};
        System.out.println("");
        System.out.println("Largo matriz renglones: " + nombres.length);
        System.out.println("Largo matriz columnas: " + nombres[0].length);

        System.out.println("");
        for (int i = 0; i < nombres.length; i++){
            for (int j = 0; j < nombres[i].length; j++){
                System.out.println("Matriz String indice: " + i + "-" + j + ": " + nombres[i][j]);
            }
        }
    }
}

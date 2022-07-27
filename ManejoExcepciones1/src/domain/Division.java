package domain;

import javax.management.openmbean.OpenDataException;

public class Division {

    private int numerador;
    private int denominador;

    /**
     * Construye el objeto Division
     *
     * @param numerador int
     * @param denominador int
     */

    public Division(int numerador, int denominador) throws OperationException{

        if (denominador == 0){
            throw new OperationException("Denominador igual a cero");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void visualizarOperacion(){
        System.out.println("El resultado de la division es: " + numerador/denominador);
    }
}

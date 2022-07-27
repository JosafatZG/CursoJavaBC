package Aritmetica;

public class PruebaAritmetica {
    public static void main(String[] args) {
        int operandoA = 6;
        int operandoB = 2;
        Aritmetica aritmetica = new Aritmetica(operandoA, operandoB);

        System.out.println("\nOperando A: " + operandoA + " y operando B: " + operandoB);
        System.out.println("Resultado suma: " + aritmetica.sumar());
        System.out.println("Resultado resta: " + aritmetica.restar());
        System.out.println("Resultado multiplicacion: " + aritmetica.multiplicar());
        System.out.println("Resultado division: " + aritmetica.dividir());
    }
    /*
    void otroMetodo(){
        //No se puede acceder a una variable local declarada en otro metodo
        System.out.println("Valor operando A" + operandoA);
    }*/
}

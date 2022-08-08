package com.gm.logica;

import com.gm.colegio.*;

import java.util.List;

public class Logica implements InterfaceLogica{

    private static final int NOTA_APROBADO = 6;

    private static final int DURACION_APROBADO = 90;

    public Logica(){

    }

    @Override
    public void alumnosAprobados(List<Alumno> alumnos){
        int aprobados = alumnos.size(); //Inicialmente todos han aprobado, si alguien no, se disminuye

        for (Alumno alumno : alumnos){ //Recorre cada alumno
            for (Examen examen : alumno.getExamenes()){ //Recorre cada examen de cadda alumno
                if (!examenAprobado(examen)){ //Si es verdad, no ha aprobado y disminuye
                    aprobados--;
                    break; //Con un examen reprobado, reprueba el alumno
                }
            }
        }

        System.out.println("Alumnos aprobados: " + aprobados); //Imprime los aprobados
    }

    @Override
    public boolean examenAprobado(Examen examen){
        if(!(examen instanceof Examen)){ //Comprueba si es tipo examen
            System.out.printf("Tipo de dato no valido");
        } else if (examen instanceof ExamenOral) { //Comprueba si es Oral
            if (!examenOral(examen)) return false; //Si es verdad, no ha aprobado
        } else if (examen instanceof ExamenEscrito) { //Comprueba si es escrito
            if(!examenEscrito(examen)) return false; //Si es verdad, no ha aprobado
        }

        return true; //Ha aprobado
    }

    @Override
    public boolean examenOral(Examen examen){
        Satisfaccion satisfaccion = ((ExamenOral) examen).getSatisfaccion(); //Upcasting-Downcasting

        if(satisfaccion == Satisfaccion.INSUFICIENTE)
            return false; //Devulve reprobado

        return true; //Devuelve aprobado
    }

    @Override
    public boolean examenEscrito(Examen examen){
        ExamenEscrito examenEscrito = (ExamenEscrito) examen;
        if(examenEscrito.getDuracion() < DURACION_APROBADO && examenEscrito.getNota() >= NOTA_APROBADO){
            return true; //Devuelve aprobado
        }

        return false; //Devuelve reprobado
    }
}

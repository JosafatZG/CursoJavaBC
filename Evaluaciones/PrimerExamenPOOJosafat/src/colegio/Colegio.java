package colegio;

import com.gm.colegio.*;
import com.gm.logica.*;

import java.util.ArrayList;
import java.util.List;

public class Colegio {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();

        //Alumno 1 Aprobado
        Alumno alumno1 = new Alumno("12336789-0", "J", "Z");
        ExamenEscrito examenEscrito1 = new ExamenEscrito("12/07/2022", 66, 8); //Aprobado
        ExamenOral examenOral1 = new ExamenOral("13/07/2022", Satisfaccion.EXCELENTE); //Aprobado

        alumno1.agregarExamen(examenEscrito1); //Aprobado
        alumno1.agregarExamen(examenOral1); //Aprobado

        //Alumno 2 Reprobado
        Alumno alumno2 = new Alumno("29270768-1", "A", "P");
        ExamenEscrito examenEscrito2 = new ExamenEscrito("01/07/2022", 91, 9); //Reprobado
        ExamenOral examenOral2 = new ExamenOral("12/07/2022", Satisfaccion.SUFICIENTE); //Aprobado

        alumno2.agregarExamen(examenEscrito2); //Reprobado
        alumno2.agregarExamen(examenOral2); //Aprobado

        //Alumno 3 Reprobado
        Alumno alumno3 = new Alumno("300017869-3", "B", "C");
        ExamenEscrito examenEscrito3 = new ExamenEscrito("01/07/2022", 23, 2); //Reprobado
        ExamenOral examenOral3 = new ExamenOral("03/08/2022", Satisfaccion.INSUFICIENTE); //Reprobado

        alumno3.agregarExamen(examenEscrito3); //Reprobado
        alumno3.agregarExamen(examenOral3); //Reprobado

        //Alumno 4 Aprobado
        Alumno alumno4 = new Alumno("121097393-8", "J", "Z");
        ExamenEscrito examenEscrito4 = new ExamenEscrito("12/07/2022", 60, 10); //Aprobado
        ExamenOral examenOral4 = new ExamenOral("13/07/2022", Satisfaccion.EXCELENTE); //Aprobado

        alumno4.agregarExamen(examenEscrito4); //Aprobado
        alumno4.agregarExamen(examenOral4); //Aprobado

        //Agregando a Array Alumnos

        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        alumnos.add(alumno4);

        //Creamos el objeto logica, donde está la lógica

        Logica logica = new Logica();

        //Enviamos el arraylist y nos devuelve la cantidad de aprobados
        logica.alumnosAprobados(alumnos);
    }
}

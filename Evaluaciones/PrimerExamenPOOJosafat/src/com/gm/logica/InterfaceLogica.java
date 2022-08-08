package com.gm.logica;

import com.gm.colegio.*;

import java.util.List;

public interface InterfaceLogica { //Interface para aplicar en diferentes tipos de lógica y condiciones

    public abstract void alumnosAprobados(List<Alumno> alumnos);

    public abstract boolean examenAprobado(Examen examen);

    public abstract boolean examenOral(Examen examen);

    public abstract boolean examenEscrito(Examen examen);

}

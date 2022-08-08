package com.gm.colegio;

public class ExamenOral extends Examen{

    private Satisfaccion satisfaccion;

    public ExamenOral(String fecha, Satisfaccion satisfaccion) {
        super(fecha);
        this.satisfaccion = satisfaccion;
    }

    public Satisfaccion getSatisfaccion() {
        return satisfaccion;
    }

    public void setSatisfaccion(Satisfaccion satisfaccion) {
        this.satisfaccion = satisfaccion;
    }

    @Override
    public String toString() {
        return "ExamenOral{" +
                "satisfaccion='" + satisfaccion + '\'' +
                "} " + super.toString();
    }
}

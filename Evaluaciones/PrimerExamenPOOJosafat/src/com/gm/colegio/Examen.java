package com.gm.colegio;

public class Examen {
    protected String fecha;

    public Examen(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "Fecha='" + fecha + '\'' +
                '}';
    }
}

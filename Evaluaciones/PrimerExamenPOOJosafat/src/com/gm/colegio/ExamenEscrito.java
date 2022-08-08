package com.gm.colegio;

public class ExamenEscrito extends Examen{

    private int duracion;
    private double nota;

    public ExamenEscrito(String fecha, int duracion, int nota) {
        super(fecha);
        this.duracion = duracion;
        this.nota = nota;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "ExamenEscrito{" +
                "duracion=" + duracion +
                ", nota=" + nota +
                "} " + super.toString();
    }
}

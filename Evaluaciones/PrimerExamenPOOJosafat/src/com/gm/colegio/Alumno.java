package com.gm.colegio;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String DUI;
    private String nombre;
    private String apellido;
    private final List<Examen> examenes = new ArrayList<>();

    private Alumno(){
    }

    public Alumno(String dui, String nombre, String apellido) {
        this.DUI = dui;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void agregarExamen(Examen examen){
        examenes.add(examen);
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "DUI='" + DUI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", examenes=" + examenes +
                '}';
    }
}

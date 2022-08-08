package com.gm.colegio;

public enum Satisfaccion {
    INSUFICIENTE("insuficiente"),
    SUFICIENTE("suficiente"),
    EXCELENTE("excelente");

    private final String text;
    Satisfaccion(final String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}

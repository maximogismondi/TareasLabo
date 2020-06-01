package com.company;

public class Hijo extends Persona{

    private String escuela;
    private String juego_favorito;

    public Hijo() {
        this.escuela = "Politecnico Modelo";
        this.juego_favorito = "The Binding Of Isaac";
    }

    public Hijo(String escuela, String juego_favorito) {
        this.escuela = escuela;
        this.juego_favorito = juego_favorito;
    }
}

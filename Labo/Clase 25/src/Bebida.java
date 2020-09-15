package com.company.Bebidas;

public abstract class Bebida {
    private String nombre;
    private double coeficientePos;
    private double coeficienteNeg;

    public Bebida(String nombre, double coeficientePos, double coeficienteNeg){
        this.nombre = nombre;
        this.coeficientePos = coeficientePos;
        this.coeficienteNeg = coeficienteNeg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCoeficienteNeg() {
        return coeficienteNeg;
    }

    public void setCoeficienteNeg(double coeficienteNeg) {
        this.coeficienteNeg = coeficienteNeg;
    }

    public double getCoeficientePos() {
        return coeficientePos;
    }

    public double getHidratacion() {
        return coeficientePos - coeficienteNeg;
    }

}

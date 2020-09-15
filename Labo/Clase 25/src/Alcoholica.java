package com.company.Bebidas;

public class Alcoholica extends Bebida {
    private double cantAlcohol;

    public Alcoholica(String nombre, double cantAlcohol) {
        super(nombre, 0, cantAlcohol*20);
        this.cantAlcohol = cantAlcohol;
    }

    public double getCantAlcohol() {
        return cantAlcohol;
    }

    public void setCantAlcohol(double cantAlcohol) {
        this.cantAlcohol = cantAlcohol;
    }
}

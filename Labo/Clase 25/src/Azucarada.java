package com.company.Bebidas;

public class Azucarada extends Bebida {
    private double cantAzucar;

    public Azucarada(String nombre, double cantAzucar) {
        super(nombre, 1, cantAzucar*10);
        this.cantAzucar = cantAzucar;
    }

    public double getCantAzucar() {
        return cantAzucar;
    }

    public void setCantAzucar(double cantAzucar) {
        this.cantAzucar = cantAzucar;
    }
}

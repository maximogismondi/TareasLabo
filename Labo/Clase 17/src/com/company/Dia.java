package com.company;

public enum Dia {

    Lunes(0), Martes(0), Miercoles(0), Jueves(0), Viernes(0), Sabado (0), Domingo(0);

    private int cant_ventas;

    private Dia(int cant_ventas){
        this.cant_ventas = cant_ventas;
    }

    public int getCant_ventas() {
        return cant_ventas;
    }

    public void setCant_ventas(int cant_ventas){
        this.cant_ventas = cant_ventas;
    }

    public void incrementarVentas(int cantidad){
        this.cant_ventas = this.cant_ventas + cantidad;
    }
}
package com.company;

public class Habitacion {

    private int nro_habitacion;
    private int capacidad;

    public Habitacion(int nro_habitacion, int capacidad){
        this.nro_habitacion = nro_habitacion;
        this.capacidad = capacidad;
    }

    public int getNro_habitacion() {
        return nro_habitacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setNro_habitacion(int nro_habitacion) {
        this.nro_habitacion = nro_habitacion;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}

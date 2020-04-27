package com.company;

public class Habitacion {

    private int nro_habitacion;
    private int capacidad;

    public Habitacion(int nro_habitacion, int capacidad){
        this.nro_habitacion = nro_habitacion;
        this.capacidad = capacidad;
    }

    public int get_nro_habitacion() {
        return nro_habitacion;
    }

    public int get_capacidad() {
        return capacidad;
    }

    public void set_nro_habitacion(int nro_habitacion) {
        this.nro_habitacion = nro_habitacion;
    }

    public void set_capacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}

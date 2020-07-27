package com.company;

import java.util.ArrayList;

public class Reserva {

    private Fecha fecha_entrada;
    private int cant_dias;
    private Habitacion habitacion;
    private ArrayList<Huesped> lista_huespedes;

    public Reserva (Fecha fecha_entrada, int cant_dias, Habitacion habitacion, ArrayList<Huesped> lista_huspedes){
        this.fecha_entrada = fecha_entrada;
        this.cant_dias = cant_dias;
        this.habitacion = habitacion;
        this.lista_huespedes = lista_huspedes;
    }

    public Fecha getFecha_entrada() {
        return fecha_entrada;
    }

    public int getCant_dias() {
        return cant_dias;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public ArrayList<Huesped> getLista_huespedes() {
        return lista_huespedes;
    }

    public Fecha getFecha_salida(){
        Fecha fecha_salida = new Fecha((this.fecha_entrada).getDia(),(this.fecha_entrada).getMes(),(this.fecha_entrada).getAnio());
        fecha_salida.sumarDias(this.cant_dias);
        return fecha_salida;
    }

    public void setFecha_entrada(Fecha fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public void setCant_dias(int cant_dias) {
        this.cant_dias = cant_dias;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setLista_huespedes(ArrayList<Huesped> lista_huespedes) {
        this.lista_huespedes = lista_huespedes;
    }
}

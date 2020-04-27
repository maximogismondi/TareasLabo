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

    public Fecha get_fecha_entrada() {
        return fecha_entrada;
    }

    public int get_cant_dias() {
        return cant_dias;
    }

    public Habitacion get_habitacion() {
        return habitacion;
    }

    public ArrayList<Huesped> get_lista_huespedes() {
        return lista_huespedes;
    }

    public Fecha get_fecha_salida(){
        Fecha fecha_salida = new Fecha((this.fecha_entrada).get_dia(),(this.fecha_entrada).get_mes(),(this.fecha_entrada).get_anio());
        fecha_salida.sumar_dias(this.cant_dias);
        return fecha_salida;
    }

    public void set_fecha_entrada(Fecha fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public void set_cant_dias(int cant_dias) {
        this.cant_dias = cant_dias;
    }

    public void set_habitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void set_lista_huespedes(ArrayList<Huesped> lista_huespedes) {
        this.lista_huespedes = lista_huespedes;
    }
}

package com.company;
import java.util.Date;

public class Hospedaje {


    private Date fechaEntrada;
    private Date fechaSalida;
    private Huesped huesped1;
    private Huesped huesped2;
    private Habitacion habitacion;
    private int cantDias;
    private double costo;

    public Hospedaje(Date fechaEntrada, Date fechaSalida, Huesped huesped1, Habitacion habitacion, int cantDias){
        Huesped huesped2 = new Huesped("NULL", "NULL", 0, 0);
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.huesped1 = huesped1;
        this.huesped2 = huesped2;
        this.habitacion = habitacion;
        this.cantDias = cantDias;
        if (cantDias>30){
            this.costo = (cantDias*545)*0.75;
        }
        else{
            this.costo = cantDias*545;
        }
        this.habitacion.setLibre(false);
    }

    public Hospedaje(Date fechaEntrada, Date fechaSalida, Huesped huesped1, Huesped huesped2, Habitacion habitacion, int cantDias){
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.huesped1 = huesped1;
        this.huesped2 = huesped2;
        this.habitacion = habitacion;
        this.cantDias = cantDias;
        if (cantDias>30){
            this.costo = (cantDias*785)*0.75;
        }
        else{
            this.costo = cantDias*785;
        }
        this.habitacion.setLibre(false);
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Huesped getHuesped1() {
        return huesped1;
    }

    public Huesped getHuesped2() {
        return huesped2;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public int getCantDias() {
        return cantDias;
    }

    public double getCosto() {
        return costo;
    }
    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setHuesped1(Huesped huesped1) {
        this.huesped1 = huesped1;
    }

    public void setHuesped2(Huesped huesped2) {
        this.huesped2 = huesped2;
    }
}

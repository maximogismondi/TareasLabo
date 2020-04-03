package com.company;

public class Habitacion {

    private int numeroHabitacion;
    private int cantUsos;
    private boolean libre;

    public Habitacion (int numeroHabitacion){
        this.numeroHabitacion = numeroHabitacion;
        this.cantUsos = 0;
        this.libre = true;
    }

    public int getCantUsos() {
        return cantUsos;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public void setCantUsos(int cantUsos) {
        this.cantUsos = cantUsos;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }
}
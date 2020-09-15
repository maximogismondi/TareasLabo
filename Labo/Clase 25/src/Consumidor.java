package com.company.Bebidas;

import java.util.HashSet;

public class Consumidor implements Hidratacion {
    private HashSet<Bebida> listaBebidas;

    public Consumidor(){
        listaBebidas = new HashSet<>();
    }

    public HashSet<Bebida> getListaBebidas() {
        return listaBebidas;
    }

    public void setListaBebidas(HashSet<Bebida> listaBebidas) {
        this.listaBebidas = listaBebidas;
    }

    public double calcularHidratacion() {
        double Hidratacion = 0.0;
        for(Bebida bebiida_aux : listaBebidas){
            Hidratacion += bebiida_aux.getHidratacion();
        }
        return  Hidratacion;
    }
}

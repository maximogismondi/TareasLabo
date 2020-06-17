package com.company;
import java.util.ArrayList;

public class Pedido {
    private int nro_pedido;
    private int nro_mesa;
    private ArrayList<String> comidas;
    private FechaYHora fechaYHora;

    public Pedido(){
        this.nro_pedido = 0;
        this.nro_mesa = 0;
        this.comidas = new ArrayList<>();
        this.fechaYHora = new FechaYHora();
    }

    public Pedido(int nro_pedido, int nro_mesa, ArrayList<String> comidas,int dia, int mes, int anio, int hora, int minuto){
        this.nro_pedido = nro_pedido;
        this.nro_mesa = nro_mesa;
        this.comidas = comidas;
        this.fechaYHora = new FechaYHora(dia, mes, anio, hora, minuto);
    }

    public int getNro_pedido() {
        return nro_pedido;
    }

    public void setNro_pedido(int nro_pedido) {
        this.nro_pedido = nro_pedido;
    }

    public int getNro_mesa() {
        return nro_mesa;
    }

    public void setNro_mesa(int nro_mesa) {
        this.nro_mesa = nro_mesa;
    }

    public ArrayList<String> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<String> comidas) {
        this.comidas = comidas;
    }

    public FechaYHora getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(FechaYHora fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}

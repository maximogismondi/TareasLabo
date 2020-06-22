package com.company;

public enum Editorial {
    Kapelusz(0), Sudamericana(0), Atlántida(0), ElAteneo(0), Interzona(0), Sur(0) , Alianza(0);

    private int cant_ventas;

    private Editorial(int cant_ventas) {
        this.cant_ventas = cant_ventas;
    }

    public void setCant_ventas(int cant_ventas) {
        this.cant_ventas = cant_ventas;
    }

    public int getCant_ventas() {
        return cant_ventas;
    }

    public void incrementarVentas(int cantidad){
        this.cant_ventas = this.cant_ventas + cantidad;
    }
}

package com.company;

import java.util.HashMap;

public class Cliente extends Persona {

    private HashMap<Libro, Integer> compras;

    public Cliente(String nombre, int edad, int dni){
        super(nombre, edad, dni);
        this.compras = new HashMap<>();
    }

    public HashMap<Libro, Integer> getCompras() {
        return compras;
    }

    public void setCompras(HashMap<Libro, Integer> compras) {
        this.compras = compras;
    }

    public Cliente(){
        super();
        this.compras = new HashMap<>();
    }

    public void agregarCompra(Libro libro, Integer cantidad){
        this.compras.put(libro, cantidad);
    }

    public void eliminarCompra(Libro libro){
        this.compras.remove(libro);
    }

}

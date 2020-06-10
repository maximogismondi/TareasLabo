package com.company;
import java.util.HashMap;

public class Libro {

    private String nombre;
    private String editorial;
    private int precio;

    public Libro(String nombre, String editorial, int precio) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

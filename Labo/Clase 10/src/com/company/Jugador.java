package com.company;

import java.util.Objects;

public class Jugador {
    private String nombre;
    private String apellido;
    private int posicion;
    private int edad;

    public Jugador(String nombre,String apellido, int edad, int posicion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.edad = edad;
    }

    //gets

    public String get_nombre() {
        return nombre;
    }

    public String get_apellido() {
        return apellido;
    }

    public int get_edad() {
        return edad;
    }

    public int get_posicion(){
        return posicion;
    }

    //sets


    public void set_apellido(String apellido) {
        this.apellido = apellido;
    }

    public void set_nombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void set_posicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador)) return false;
        Jugador jugador = (Jugador) o;
        return nombre.equals(jugador.nombre) &&
                apellido.equals(jugador.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}

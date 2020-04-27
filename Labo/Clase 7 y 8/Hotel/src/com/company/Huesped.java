package com.company;

import java.util.ArrayList;

public class Huesped {

    private String nombre;
    private String apellido;
    private int edad;
    private int dni;

    public Huesped(String nombre, String apellido, int edad, int dni){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    public String get_nombre() {
        return nombre;
    }

    public String get_apellido() {
        return apellido;
    }

    public int get_dni() {
        return dni;
    }

    public int get_edad() {
        return edad;
    }

    public void set_nombre(String nombre) {
        this.nombre = nombre;
    }

    public void set_apellido(String apellido) {
        this.apellido = apellido;
    }

    public void set_dni(int dni) {
        this.dni = dni;
    }

    public void set_edad(int edad) {
        this.edad = edad;
    }

}

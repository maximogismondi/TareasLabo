package com.company;

import java.util.ArrayList;

public class Huesped extends Persona {

    private String apellido;

    public Huesped(String nombre, String apellido, int edad, int dni){
        super(nombre, edad, dni);
        this.apellido = apellido;
    }

    public Huesped(){
        super();
        this.apellido = "Perez";
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}

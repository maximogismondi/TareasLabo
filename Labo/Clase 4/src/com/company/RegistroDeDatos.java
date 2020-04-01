package com.company;

public class RegistroDeDatos {

    private String nombre;
    private String apellido;
    private int edad;
    private String ocupacion;

    public RegistroDeDatos(String nombre, String apellido, int edad, String ocupacion){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.ocupacion=ocupacion;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

}
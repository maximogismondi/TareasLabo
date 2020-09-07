package com.company.Veterinaria;

public class Mascota {
    private String Nombre;
    private String Dueno;

    public Mascota(String nombre, String dueno) {
        Nombre = nombre;
        Dueno = dueno;
    }

    public String tipoMascota(){
        System.out.println("indefinido");
        return "Indefinido";
    }

    public void saludo(boolean duenoCorrecto){
        System.out.println("indefinido");
    }

    public void alimentar(){
        System.out.println("indefinido");
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDueno() {
        return Dueno;
    }

    public void setDueno(String dueno) {
        Dueno = dueno;
    }
}

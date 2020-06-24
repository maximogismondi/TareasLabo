package com.company;

import java.util.Objects;

public class Mascota {

    private String nombre;
    private String dueno;

    public Mascota() {
        this.nombre = "Pepito";
        this.dueno = "Juan";
    }

    public Mascota(String nombre, String dueno) {
        this.nombre = nombre;
        this.dueno = dueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mascota)) return false;
        Mascota mascota = (Mascota) o;
        return getNombre().equals(mascota.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre());
    }

    public void saludar(String persona_actual){
    }

    public void alimentarse(){
    }

    public String getTipo_mascota(){
        return null;
    }
}

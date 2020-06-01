package com.company;
import java.util.HashSet;
import java.util.Objects;

public class Madre extends Persona{

    private String nombre_empresa;
    private HashSet<Hijo> hijos;

    public Madre(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
        this.hijos = new HashSet<Hijo>();
    }

    public Madre() {
        this.nombre_empresa = "McDonald's";
        this.hijos = new HashSet<Hijo>();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Madre)) return false;
        Madre madre = (Madre) o;
        return hijos.equals(madre.hijos);
    }

    public int hashCode() {
        return Objects.hash(hijos);
    }
}

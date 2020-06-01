package com.company;
import java.util.HashSet;
import java.util.Objects;

public class Madre extends Persona {

    private String nombre_empresa;
    private HashSet<Hijo> hijos;

    public Madre(String nombre_empresa, String nombre, int edad, int dni) {
        super(nombre,edad,dni);
        this.nombre_empresa = nombre_empresa;
        this.hijos = new HashSet<Hijo>();
    }

    public Madre() {
        super();
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

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public HashSet<Hijo> getHijos() {
        return hijos;
    }

    public void setHijos(HashSet<Hijo> hijos) {
        this.hijos = hijos;
    }

    public HashSet<Hijo> hijos_menores(){
        HashSet<Hijo> hijos_menores = new HashSet<>();
        for(Hijo hijo : this.getHijos()){
            if(hijo.getEdad() >= 18){
                hijos_menores.add(hijo);
            }
        }
        return hijos_menores;
    }
}

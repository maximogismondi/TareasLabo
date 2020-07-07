package com.company;
import java.util.HashMap;
import java.util.HashSet;

public class Mascota{
    private String tipo;  // perro/gato/tortuga
    private String nombre;
    private String dueno;
    private String nacimiento;
    private HashMap<Integer, HashSet<String> > registroVisitas; // año/fechas
    

    public Mascota(String tipo, String nombre, String dueno, String nacimiento) {
        this.tipo            = tipo;
        this.nombre          = nombre;
        this.dueno           = dueno;
        this.nacimiento      = nacimiento;
        this.registroVisitas = new HashMap<>();
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDueno() {
        return this.dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String getNacimiento() {
        return this.nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public HashMap<Integer,HashSet<String>> getRegistroVisitas() {
        return this.registroVisitas;
    }

    public void setRegistroVisitas(HashMap<Integer,HashSet<String>> registroVisitas) {
        this.registroVisitas = registroVisitas;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", dueno='" + getDueno() + "'" +
            ", nacimiento='" + getNacimiento() + "'" +
            ", registroVisitas='" + getRegistroVisitas() + "'" +
            "}";
    }
    

    /*----*/

    public boolean cumplimientoVisitasObligatorias(Integer ano){
        System.out.println("indefinido");
        return false;
    }

    public boolean cumplimientoVisitasObligatorias_DesdeNacimiento(){
        System.out.println("indefinido");
        return false;
    }
}
package com.company;
import java.util.HashMap;
import java.util.HashSet;

public class Gato extends Mascota{
    private String raza;

    public Gato(String nombre, String dueno, String nacimiento, String raza) {
        super("gato", nombre, dueno, nacimiento);
        this.raza = raza;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "{" +
            " raza='" + getRaza() + "'" +
            "}";
    }

    @Override
    public boolean cumplimientoVisitasObligatorias(Integer ano){
        if(this.getRegistroVisitas().get(ano).size() >= 2){
            return true;
        }
        return false;
    }

    @Override
    public boolean cumplimientoVisitasObligatorias_DesdeNacimiento(){
        for (HashMap.Entry<Integer, HashSet<String>> registro_aux : this.getRegistroVisitas().entrySet()){
            if(registro_aux.getValue().size() < 2){
                return false;
            }
        }
        return true;
    }
    
}
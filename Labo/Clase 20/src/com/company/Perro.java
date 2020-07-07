package com.company;
import java.util.HashMap;
import java.util.HashSet;

public class Perro extends Mascota{
    private String raza;


    public Perro(String nombre, String dueno, String nacimiento, String raza) {
        super("perro", nombre, dueno, nacimiento);
        this.raza = raza;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Perro raza(String raza) {
        this.raza = raza;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " raza='" + getRaza() + "'" +
            "}";
    }

    @Override
    public boolean cumplimientoVisitasObligatorias(Integer ano){
        if(this.getRegistroVisitas().get(ano).size() >= 4){
            return true;
        }
        return false;
    }

    @Override
    public boolean cumplimientoVisitasObligatorias_DesdeNacimiento(){
        for (HashMap.Entry<Integer, HashSet<String>> registro_aux : this.getRegistroVisitas().entrySet()){
            if(registro_aux.getValue().size() < 4){
                return false;
            }
        }
        return true;
    }

    

}
    

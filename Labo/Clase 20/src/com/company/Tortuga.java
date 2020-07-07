package com.company;
import java.util.HashMap;
import java.util.HashSet;

public class Tortuga extends Mascota{
    
    public Tortuga (String nombre, String dueno, String nacimiento){
        super("tortuga", nombre, dueno, nacimiento);
    }
    
    @Override
    public boolean cumplimientoVisitasObligatorias(Integer ano){
        if(this.getRegistroVisitas().get(ano).size() >= 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean cumplimientoVisitasObligatorias_DesdeNacimiento(){
        for (HashMap.Entry<Integer, HashSet<String>> registro_aux : this.getRegistroVisitas().entrySet()){
            if(registro_aux.getValue().size() < 1){
                return false;
            }
        }
        return true;
    }
}
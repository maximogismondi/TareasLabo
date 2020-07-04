package com.company;

import com.sun.jdi.FloatValue;

import java.util.HashMap;

public class Alumno extends Persona{

    private HashMap<Materia, Float> lista_materias_promedio;

    public Alumno(String nombre, String apellido, int edad, int dni) {
        super(nombre, apellido, edad, dni);
        this.lista_materias_promedio = new HashMap<>();
    }

    public HashMap<Materia, Float> getLista_materias_promedio() {
        return lista_materias_promedio;
    }

    public void setLista_materias_promedio(HashMap<Materia, Float> lista_materias_promedio) {
        this.lista_materias_promedio = lista_materias_promedio;
    }

    public void agregar_nota(String nombre_materia, int nota){
        for (HashMap.Entry<Materia, Float> materia_promedio : this.lista_materias_promedio.entrySet()){
            if(materia_promedio.getKey().equals(nombre_materia)){
                materia_promedio.getKey().agregar_nota(nota);
            }
        }
    }

    public int menor_nota(String nombre_materia){
        for (HashMap.Entry<Materia, Float> materia_promedio : this.lista_materias_promedio.entrySet()){
            if(materia_promedio.getKey().equals(nombre_materia)){
                return materia_promedio.getKey().menor_nota();
            }
        }
        return 0;
    }

    public int mayor_nota(String nombre_materia){
        for (HashMap.Entry<Materia, Float> materia_promedio : this.lista_materias_promedio.entrySet()){
            if(materia_promedio.getKey().equals(nombre_materia)){
                return materia_promedio.getKey().mayor_nota();
            }
        }
        return 0;
    }

    public Float establecer_y_retornar_promedio(String nombre_materia){
        for (HashMap.Entry<Materia, Float> materia_promedio : this.lista_materias_promedio.entrySet()){
            if(materia_promedio.getKey().equals(nombre_materia)){
                materia_promedio.setValue(materia_promedio.getKey().promedio());
                return materia_promedio.getKey().promedio();
            }
        }
        return Float.valueOf(0);
    }

    public Float promedio_final(){
        Float suma_promedio_final = Float.valueOf(0);
        for (HashMap.Entry<Materia, Float> materia_promedio : this.lista_materias_promedio.entrySet()){
            suma_promedio_final += materia_promedio.setValue(materia_promedio.getKey().promedio());
        }
        return suma_promedio_final / lista_materias_promedio.size();
    }

    public void agregar_materia(String nombre_materia){
        this.lista_materias_promedio.put(new Materia(nombre_materia), Float.valueOf(0));
    }

    public Float menor_promedio(){
        Float menor_promedio = Float.valueOf(10);
        for (HashMap.Entry<Materia, Float> materia_promedio : this.lista_materias_promedio.entrySet()){
            if(menor_promedio > materia_promedio.getKey().promedio()){
                menor_promedio = materia_promedio.getKey().promedio();
            }
        }
        return menor_promedio;
    }

    public Float mayor_promedio(){
        Float mayor_promedio = Float.valueOf(10);
        for (HashMap.Entry<Materia, Float> materia_promedio : this.lista_materias_promedio.entrySet()){
            if(mayor_promedio < materia_promedio.getKey().promedio()){
                mayor_promedio = materia_promedio.getKey().promedio();
            }
        }
        return mayor_promedio;
    }
}

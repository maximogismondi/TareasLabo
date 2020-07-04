package com.company;

import java.util.HashSet;

public class Materia {

    private String nombre;
    private HashSet<Integer> lista_notas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.lista_notas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<Integer> getLista_notas() {
        return lista_notas;
    }

    public void setLista_notas(HashSet<Integer> lista_notas) {
        this.lista_notas = lista_notas;
    }

    public void agregar_nota(int nota){
        this.lista_notas.add(nota);
    }

    public int menor_nota(){
        int menor_nota = 10;
        for(Integer nota : lista_notas){
            if(nota < menor_nota){
                menor_nota = nota;
            }
        }
        return menor_nota;
    }

    public int mayor_nota(){
        int mayor_nota = 0;
        for(Integer nota : lista_notas){
            if(nota > mayor_nota){
                mayor_nota = nota;
            }
        }
        return mayor_nota;
    }

    public Float promedio(){
        int sumatoria_notas = 0;
        for(Integer nota : lista_notas){
            sumatoria_notas = nota;
        }
        return Float.valueOf((sumatoria_notas / lista_notas.size()));
    }
}

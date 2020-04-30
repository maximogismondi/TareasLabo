package com.company;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.HashSet;


public class Equipo {
    private String nombre_club;
    private HashSet<Jugador> lista_jugadores;

    public Equipo(String nombre_club, HashSet<Jugador> lista_jugadores){
        this.nombre_club = nombre_club;
        this.lista_jugadores = lista_jugadores;
    }

    //gets
    public String get_nombre_club() {
        return nombre_club;
    }

    public HashSet<Jugador> get_lista_jugadores() {
        return lista_jugadores;
    }

    //sets
    public void set_nombre_club(String nombre_club) {
        this.nombre_club = nombre_club;
    }

    public void set_lista_jugador(HashSet<Jugador> lista_jugadores) {
        this.lista_jugadores = lista_jugadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;
        Equipo equipo = (Equipo) o;
        return nombre_club.equals(equipo.nombre_club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre_club);
    }
}

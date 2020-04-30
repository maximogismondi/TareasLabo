package com.company;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.HashSet;


public class Partido {
    private Equipo equipo_local;
    private Equipo equipo_visitante;
    private FechaYHora momento_de_inicio;
    private HashSet<Gol> goles;

    public Partido(Equipo equipo_local, Equipo equipo_visitante, HashSet<Gol> goles, FechaYHora momento_de_inicio){

        this.equipo_local = equipo_local;
        this.equipo_visitante = equipo_visitante;
        this.goles = goles;
        this.momento_de_inicio = momento_de_inicio;
    }

    //gets

    public Equipo getEquipoLocal() {
        return equipo_local;
    }

    public Equipo getEquipoVisitante() {
        return equipo_visitante;
    }

    public FechaYHora getMomento_de_inicio() {
        return momento_de_inicio;
    }

    public HashSet<Gol> getGoles() {
        return goles;
    }

    //sets

    public void setEquipo_local(Equipo equipo_local) {
        this.equipo_local = equipo_local;
    }

    public void setEquipo_visitante(Equipo equipo_visitante) {
        this.equipo_visitante = equipo_visitante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partido)) return false;
        Partido partido = (Partido) o;
        return equipo_local.equals(partido.equipo_local) &&
                equipo_visitante.equals(partido.equipo_visitante) &&
                momento_de_inicio.equals(partido.momento_de_inicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipo_local, equipo_visitante, momento_de_inicio);
    }
}

package com.company;

import java.util.Objects;

public class Gol {
    Equipo equipo;
    Jugador jugador;
    FechaYHora fechaYHora;

    public Gol(Equipo equipo, Jugador jugador, FechaYHora fechaYHora){
        this.equipo = equipo;
        this.jugador = jugador;
        this.fechaYHora = fechaYHora;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gol)) return false;
        Gol gol = (Gol) o;
        return jugador.equals(gol.jugador) &&
                fechaYHora.equals(gol.fechaYHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jugador, fechaYHora);
    }
}

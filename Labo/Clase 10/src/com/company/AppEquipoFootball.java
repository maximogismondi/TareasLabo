package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class AppEquipoFootball {

    private HashSet<Partido> lista_de_partidos;
    private HashSet<Equipo> lista_de_equipos;

    public AppEquipoFootball(){
        this.lista_de_partidos = new HashSet<Partido>();
        this.lista_de_equipos = new HashSet<Equipo>();

        Jugador nuevo_jugador_1 = new Jugador("Tomas", "Gimenez", 22, 11);
        Jugador nuevo_jugador_2 = new Jugador("Nicolas", "Gismondi", 20, 1);
        Jugador nuevo_jugador_3 = new Jugador("Juan", "Blum", 27, 7);
        Jugador nuevo_jugador_4 = new Jugador("Damian", "Quinta", 21, 4);
        Jugador nuevo_jugador_5 = new Jugador("Gian", "Bruni", 22, 3);
        Jugador nuevo_jugador_6 = new Jugador("Maximo", "Moggiaa", 19, 5);
        Jugador nuevo_jugador_7 = new Jugador("Pedro", "Sandoval", 25, 12);
        Jugador nuevo_jugador_8 = new Jugador("Ignacio", "Moyano", 30, 18);
        Jugador nuevo_jugador_9 = new Jugador("Matias", "Fedi", 19, 1);
        Jugador nuevo_jugador_10 = new Jugador("Luciano", "Lecuona", 24, 11);

        HashSet<Jugador> jugadores_1 = new HashSet<Jugador>();
        jugadores_1.add(nuevo_jugador_1);
        jugadores_1.add(nuevo_jugador_2);
        HashSet<Jugador> jugadores_2 = new HashSet<Jugador>();
        jugadores_2.add(nuevo_jugador_3);
        jugadores_2.add(nuevo_jugador_4);
        HashSet<Jugador> jugadores_3 = new HashSet<Jugador>();
        jugadores_3.add(nuevo_jugador_5);
        jugadores_3.add(nuevo_jugador_6);
        jugadores_3.add(nuevo_jugador_7);
        HashSet<Jugador> jugadores_4 = new HashSet<Jugador>();
        jugadores_4.add(nuevo_jugador_8);
        jugadores_4.add(nuevo_jugador_9);
        jugadores_4.add(nuevo_jugador_10);

        Equipo nuevo_equipo_1 = new Equipo("Boca",jugadores_1);
        Equipo nuevo_equipo_2 = new Equipo("River",jugadores_2);
        Equipo nuevo_equipo_3 = new Equipo("San Lorenzo",jugadores_3);
        Equipo nuevo_equipo_4 = new Equipo("Racing",jugadores_4);

        this.lista_de_equipos.add(nuevo_equipo_1);
        this.lista_de_equipos.add(nuevo_equipo_2);
        this.lista_de_equipos.add(nuevo_equipo_3);
        this.lista_de_equipos.add(nuevo_equipo_4);

        FechaYHora fecha_y_hora_1 = new FechaYHora(30,4,2020, 12, 45);
        FechaYHora fecha_y_hora_2 = new FechaYHora(30,4,2020, 18, 15);
        FechaYHora fecha_y_hora_3 = new FechaYHora(6,5,2020, 13, 00);
        FechaYHora fecha_y_hora_4 = new FechaYHora(6,5,2020, 19, 30);

        Gol gol_1 = new Gol( new Equipo("Boca",jugadores_1), new Jugador("Tomas", "Gimenez", 22, 11), new FechaYHora(30,4,2020, 13, 00));
        Gol gol_2 = new Gol( new Equipo("River",jugadores_2), new Jugador("Juan", "Blum", 27, 7), new FechaYHora(30,4,2020, 13, 16));
        Gol gol_3 = new Gol( new Equipo("River",jugadores_2), new Jugador("Juan", "Blum", 27, 7), new FechaYHora(30,4,2020, 13, 35));
        Gol gol_4 = new Gol( new Equipo("San Lorenzo",jugadores_3), new Jugador("Pedro", "Sandoval", 25, 12), new FechaYHora(30,4,2020, 18, 35));
        Gol gol_5 = new Gol( new Equipo("San Lorenzo",jugadores_3), new Jugador("Pedro", "Sandoval", 25, 12), new FechaYHora(30,4,2020, 18, 49));
        Gol gol_6 = new Gol( new Equipo("Racing",jugadores_4), new Jugador("Luciano", "Lecuona", 24, 11), new FechaYHora(6,5,2020, 13, 59));
        Gol gol_7 = new Gol( new Equipo("San Lorenzo",jugadores_3), new Jugador("Pedro", "Sandoval", 25, 12), new FechaYHora(6,5,2020, 19, 48));

        HashSet<Gol> goles_1 = new HashSet<Gol>();
        goles_1.add(gol_1);
        goles_1.add(gol_2);
        goles_1.add(gol_3);
        HashSet<Gol> goles_2 = new HashSet<Gol>();
        goles_2.add(gol_4);
        goles_2.add(gol_5);
        HashSet<Gol> goles_3 = new HashSet<Gol>();
        goles_3.add(gol_6);
        HashSet<Gol> goles_4 = new HashSet<Gol>();
        goles_4.add(gol_7);

        Partido partido_1 = new Partido(new Equipo("Boca",jugadores_1), new Equipo("River",jugadores_2),goles_1 ,fecha_y_hora_1);
        Partido partido_2 = new Partido(new Equipo("San Lorenzo",jugadores_3), new Equipo("Racing",jugadores_4),goles_2 ,fecha_y_hora_2);
        Partido partido_3 = new Partido(new Equipo("Boca",jugadores_1), new Equipo("Racing",jugadores_4),goles_3 ,fecha_y_hora_3);
        Partido partido_4 = new Partido(new Equipo("San Lorenzo",jugadores_3), new Equipo("River",jugadores_2),goles_4 ,fecha_y_hora_4);

        this.lista_de_partidos.add(partido_1);
        this.lista_de_partidos.add(partido_2);
        this.lista_de_partidos.add(partido_3);
        this.lista_de_partidos.add(partido_4);
    }

    public HashSet<Equipo> getLista_de_equipos() {
        return lista_de_equipos;
    }

    public HashSet<Partido> getLista_de_partidos() {
        return lista_de_partidos;
    }

    int mostrarOpciones(){
        Scanner ingreso = new Scanner(System.in);

        System.out.println("Chose an option");
        System.out.println("1. Info of players of a Team");
        System.out.println("2. Quantity of wins and loses");
        System.out.println("3. Exit");

        return ingreso.nextInt();
    }

    void mostrarJugadoresDeUnEquipo(String nombre_equipo){
        for (Equipo equipo : lista_de_equipos){
            if (equipo.get_nombre_club().equals(nombre_equipo)){
                System.out.println("Players of " + equipo.get_nombre_club() + ":");
                for (Jugador jugador : equipo.get_lista_jugadores()){
                    System.out.println(jugador.get_nombre() + " " + jugador.get_apellido());
                }
            }
        }
    }

    String resultadoDelPartido(HashSet<Gol> goles, String nombre_equipo){
        int goles_a_favor = 0;
        int goles_en_contra = 0;
        for (Gol gol : goles){
            if (gol.getEquipo().get_nombre_club().equals(nombre_equipo)){
                goles_a_favor++;
            }
            else{
                goles_en_contra++;
            }
        }
        if(goles_a_favor > goles_en_contra){
            return "Victoria";
        }
        else if (goles_a_favor == goles_en_contra){
            return "Empate";
        }
        else{
            return "Derrota";
        }
    }

    void cantidadVictoriasDerrotas(String nombre_equipo){
        int contador_victorias = 0;
        int contador_derrotas = 0;
        int contador_empates = 0;
        for(Partido partido : lista_de_partidos){
            if(partido.getEquipoLocal().get_nombre_club().equals(nombre_equipo)){
                String resultado = resultadoDelPartido(partido.getGoles(), nombre_equipo);
                switch (resultado){
                    case "Victoria":
                        contador_victorias++;
                        break;

                    case "Derrota":
                        contador_derrotas++;
                        break;

                    case "Empate":
                        contador_empates++;
                        break;
                }
            }
            else if(partido.getEquipoVisitante().get_nombre_club().equals(nombre_equipo)){
                String resultado = resultadoDelPartido(partido.getGoles(), nombre_equipo);
                switch (resultado){
                    case "Victoria":
                        contador_victorias++;
                        break;

                    case "Derrota":
                        contador_derrotas++;
                        break;

                    case "Empate":
                        contador_empates++;
                        break;
                }
            }
        }
        System.out.println("The team " + nombre_equipo + " has:");
        System.out.println("Victories: " + contador_victorias + " Deafeats: " + contador_derrotas + " Draws: " + contador_empates);
    }

    void main(){
        Scanner ingreso = new Scanner(System.in);
        int opcion = 0;
        while(opcion != 3) {
            System.out.println(" ");
            opcion = mostrarOpciones();
            switch (opcion) {
                case 1:
                    System.out.println("Team name's: ");
                    String nombre_equipo = ingreso.nextLine();
                    mostrarJugadoresDeUnEquipo(nombre_equipo);
                    break;

                case 2:
                    System.out.println("Team name's: ");
                    String nombre_equipo_2 = ingreso.nextLine();
                    cantidadVictoriasDerrotas(nombre_equipo_2);
                    break;
                case 3:
                    System.out.println("Bye, bye");
                    break;
            }
        }
    }
}
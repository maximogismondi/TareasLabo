package com.company;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.ArrayList;

public class Main {

    ArrayList<Huesped> top6Huepedes (ArrayList<Huesped> listaHuespedes){

        ArrayList<Huesped> top6Huespedes = new ArrayList<>();
        Huesped huespedAux = new Huesped("Jorjito", "Perez", 21, 12345678);

        for (int i = 0 ; i < 6 ; i++){
            top6Huespedes.add(huespedAux);
        }

        for (int i = 0 ; i < listaHuespedes.size() ; i++){
            if ((listaHuespedes.get(i)).getCantVisitas() > (top6Huespedes.get(0)).getCantVisitas()){
                top6Huespedes.set(5,top6Huespedes.get(4));
                top6Huespedes.set(4,top6Huespedes.get(3));
                top6Huespedes.set(3,top6Huespedes.get(2));
                top6Huespedes.set(2,top6Huespedes.get(1));
                top6Huespedes.set(1,top6Huespedes.get(0));
                top6Huespedes.set(0,listaHuespedes.get(i));
            }
            else if ((listaHuespedes.get(i)).getCantVisitas() > (top6Huespedes.get(1)).getCantVisitas()){
                top6Huespedes.set(5,top6Huespedes.get(4));
                top6Huespedes.set(4,top6Huespedes.get(3));
                top6Huespedes.set(3,top6Huespedes.get(2));
                top6Huespedes.set(2,top6Huespedes.get(1));
                top6Huespedes.set(1,listaHuespedes.get(i));
            }
            else if ((listaHuespedes.get(i)).getCantVisitas() > (top6Huespedes.get(2)).getCantVisitas()){
                top6Huespedes.set(5,top6Huespedes.get(4));
                top6Huespedes.set(4,top6Huespedes.get(3));
                top6Huespedes.set(3,top6Huespedes.get(2));
                top6Huespedes.set(2,listaHuespedes.get(i));
            }
            else if ((listaHuespedes.get(i)).getCantVisitas() > (top6Huespedes.get(3)).getCantVisitas()){
                top6Huespedes.set(5,top6Huespedes.get(4));
                top6Huespedes.set(4,top6Huespedes.get(3));
                top6Huespedes.set(3,listaHuespedes.get(i));
            }
            else if ((listaHuespedes.get(i)).getCantVisitas() > (top6Huespedes.get(4)).getCantVisitas()){
                top6Huespedes.set(5,top6Huespedes.get(4));
                top6Huespedes.set(4,listaHuespedes.get(i));
            }
            else if ((listaHuespedes.get(i)).getCantVisitas() > (top6Huespedes.get(5)).getCantVisitas()){
                top6Huespedes.set(5,listaHuespedes.get(i));
            }
        }
        return top6Huespedes;
    }

    int cantDePersonasConEstadiaProlongada(ArrayList<Huesped> listaHuespedes, @NotNull ArrayList<Hospedaje> listaHospedajes){

        ArrayList<Huesped> yaContados = new ArrayList<>();
        boolean yaEsta = false;

        for (int i = 0 ; i < listaHospedajes.size() ; i++){
            if ((listaHospedajes.get(i)).getCantDias()>30){
                for (int j = 0 ; j < yaContados.size() && !yaEsta ; j++){
                    if ((listaHospedajes.get(i)).getHuesped1() == yaContados.get(j)){
                        yaEsta = true;
                    }
                }
                if (!yaEsta){
                    yaContados.add((listaHospedajes.get(i)).getHuesped1());
                }
                else {
                    yaEsta = false;
                }
                if (((listaHospedajes.get(i)).getHuesped2()).getNombre() == "NULL"){
                    for (int j = 0 ; j < yaContados.size() && !yaEsta ; j++){
                        if ((listaHospedajes.get(i)).getHuesped2() == yaContados.get(j)){
                            yaEsta = true;
                        }
                    }
                    if (!yaEsta){
                        yaContados.add((listaHospedajes.get(i)).getHuesped2());
                    }
                    else {
                        yaEsta = false;
                    }
                }
            }
        }
        return yaContados.size();
    }

    double dineroTotal (@NotNull ArrayList<Hospedaje> listaHospedajes){
        double dinerototal=0;
        for(int i=0; i<listaHospedajes.size(); i++){
            dinerototal = dinerototal + ((listaHospedajes.get(i)).getCosto());
        }

        return dinerototal;
    }

    ArrayList<Habitacion> top3Habitaciones (ArrayList<Habitacion> listaHabitaciones) {
        ArrayList<Habitacion> top3Habitaciones = new ArrayList<>();
        for (int i=0; i<3;i++) {
            Habitacion habitacionaux= new Habitacion(i);
            top3Habitaciones.add(habitacionaux);
        }
        for (int i=0; i<listaHabitaciones.size();i++) {
            if ((listaHabitaciones.get(i)).getCantUsos()>(top3Habitaciones.get(0)).getCantUsos()) {
                top3Habitaciones.set(2,top3Habitaciones.get(1));
                top3Habitaciones.set(1,top3Habitaciones.get(0));
                top3Habitaciones.set(0,listaHabitaciones.get(i));
            }
            if ((listaHabitaciones.get(i)).getCantUsos()>(top3Habitaciones.get(1)).getCantUsos()) {
                top3Habitaciones.set(2,top3Habitaciones.get(1));
                top3Habitaciones.set(1,listaHabitaciones.get(i));
            }
            if ((listaHabitaciones.get(i)).getCantUsos()>(top3Habitaciones.get(2)).getCantUsos()) {
                top3Habitaciones.set(2,listaHabitaciones.get(i));
            }
        }
        return top3Habitaciones;
    }

    ArrayList<Integer> listaHabitacionesDisponibles(@NotNull ArrayList<Habitacion> listaHabitacioes){

        ArrayList<Integer> nroHabitacionesDisp = new ArrayList<>();


        for (int i = 0; i < listaHabitacioes.size(); i++){
            if ((listaHabitacioes.get(i).isLibre())){
                nroHabitacionesDisp.add(i);
            }
        }

        return nroHabitacionesDisp;

    }

    ArrayList<Integer> listaHabitacionesOcupadas(@NotNull ArrayList<Habitacion> listaHabitacioes){

        ArrayList<Integer> nroHabitacionesOcup = new ArrayList<>();

        for (int i = 0; i < listaHabitacioes.size(); i++){
            if ((listaHabitacioes.get(i).isLibre())){
                nroHabitacionesOcup.add(i);
            }
        }

        return nroHabitacionesOcup;

    }

    ArrayList<Integer> tiempoHuesped (@NotNull ArrayList<Hospedaje> listaHospedajes){

        ArrayList<Integer>tiempoHuesped = new ArrayList<>();

        for(int i=0; i< listaHospedajes.size(); i++){
            Integer cantidadDias = (listaHospedajes.get(i)).getCantDias();
            tiempoHuesped.add(cantidadDias);
        }
        return tiempoHuesped;
    }

    ArrayList<Huesped> huespedesEnDeterminadaHabitacion (@NotNull ArrayList<Hospedaje> listaHospedajes, int numeroHabitación) {
        Date fechaActual= new Date();
        ArrayList<Huesped> huespedesEnDeterminadaHabitacion = new ArrayList<>();
        for(int i=listaHospedajes.size()-1;i>0;i--){
            if (((listaHospedajes.get(i)).getHabitacion()).getNumeroHabitacion() == numeroHabitación){
                huespedesEnDeterminadaHabitacion.add((listaHospedajes.get(i)).getHuesped1());
                if(((listaHospedajes.get(i)).getHuesped2()).getNombre() != "NULL"){
                    huespedesEnDeterminadaHabitacion.add((listaHospedajes.get(i)).getHuesped2());
                }
            }
            return huespedesEnDeterminadaHabitacion;
        }
        return huespedesEnDeterminadaHabitacion;
    }

    ArrayList<ArrayList<Date>> fechaEntradaSalida(@NotNull ArrayList<Hospedaje> listaHospedajes){

        ArrayList<ArrayList<Date>> fechasEntradaYSalida = new ArrayList<>();

        for (int i = 0; i < listaHospedajes.size(); i++){
            ArrayList<Date> arrayAux = new ArrayList<>();
            arrayAux.add((listaHospedajes.get(i)).getFechaEntrada());
            arrayAux.add((listaHospedajes.get(i)).getFechaSalida());
            fechasEntradaYSalida.add(arrayAux);
        }

        return fechasEntradaYSalida;
    }

    ArrayList<Double> importeAPagar (@NotNull ArrayList<Hospedaje> listaHospedajes) {
        ArrayList<Double>importeAPagar = new ArrayList<>();
        for(int i=0; i< listaHospedajes.size(); i++){
            Double importe = (listaHospedajes.get(i)).getCosto();
            importeAPagar.add(importe);
        }
        return importeAPagar;
    }

    ArrayList<Hospedaje> agregaMasDiasdeEstadia(@NotNull ArrayList<Hospedaje> listaHospedajes, Date fecha_nueva, int cantDias, int numerodeHabitacion){
        for(int i=listaHospedajes.size()-1; i>0; i--){
            if((listaHospedajes.get(i).getHabitacion()).getNumeroHabitacion()==numerodeHabitacion){
                (listaHospedajes.get(i)).setCantDias((listaHospedajes.get(i)).getCantDias()+cantDias);
                (listaHospedajes.get(i)).setFechaSalida(fecha_nueva);
                return listaHospedajes;
            }
        }
        return listaHospedajes;
    }

    public static void main(String[] args) {

        ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();

        for (int i = 1 ; i < 14 ; i++){
            Habitacion habitacionaAux = new Habitacion(i);
            listaHabitaciones.add(habitacionaAux);
        }

        ArrayList<Huesped> listaHuespedes = new ArrayList<>();
        ArrayList<Hospedaje> listaHospedajes = new ArrayList<>();
    }
}
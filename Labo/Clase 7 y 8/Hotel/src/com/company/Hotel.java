package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    ArrayList<Habitacion> lista_habitaciones;
    ArrayList<Huesped> lista_huespedes;
    ArrayList<Huesped> lista_huespedes_sin_habitacion;
    ArrayList<Reserva> lista_reservas;
    Fecha fecha_hoy;

    public Hotel(Fecha fecha_hoy){
        this.lista_habitaciones = new ArrayList<Habitacion>();
        this.lista_huespedes = new ArrayList<Huesped>();
        this.lista_huespedes_sin_habitacion = new ArrayList<Huesped>();
        this.lista_reservas = new ArrayList<Reserva>();
        for(int i = 0; i < 13; i++) {
            if (i < 8) {
                Habitacion habitacion_aux = new Habitacion(i, 1);
                this.lista_habitaciones.add(habitacion_aux);
            } else {
                Habitacion habitacion_aux = new Habitacion(i, 2);
                this.lista_habitaciones.add(habitacion_aux);
            }
        }
        this.fecha_hoy = fecha_hoy;
    }

    public ArrayList<Habitacion> getLista_habitaciones() {
        return lista_habitaciones;
    }

    public ArrayList<Huesped> getLista_huespedes() {
        return lista_huespedes;
    }

    public ArrayList<Reserva> getLista_reservas() {
        return lista_reservas;
    }

    public void liberar_huespedes(){
        for (Reserva reserva : lista_reservas){
            if (this.fecha_hoy.es_mayor_a(reserva.get_fecha_salida())){
                lista_huespedes_sin_habitacion.add(reserva.get_lista_huespedes().get(0));
                if(reserva.get_lista_huespedes().size() == 2){
                    lista_huespedes_sin_habitacion.add(reserva.get_lista_huespedes().get(1));
                }
            }
        }
    }

    public boolean esta_ocupada(int nro_habitacion){
        for(Reserva reservas:this.lista_reservas){
            if ((reservas.get_habitacion()).get_nro_habitacion() == nro_habitacion && reservas.get_fecha_salida().es_mayor_a(this.fecha_hoy)){
                return true;
            }
        }
        return false;
    }

    public void nuevo_huesped(){
        Scanner ingreso = new Scanner(System.in);

        System.out.println("Escribe el nombre del huesped");
        String nombre_nuevo_huesped = ingreso.nextLine();
        System.out.println("Escribe el apellido del huesped");
        String apellido_nuevo_huesped = ingreso.nextLine();
        System.out.println("Escribe la edad del huesped");
        int edad_nuevo_huesped = ingreso.nextInt();
        System.out.println("Escribe el dni del huesped");
        int dni_nuevo_huesped = ingreso.nextInt();

        Huesped nuevo_huesped = new Huesped(nombre_nuevo_huesped, apellido_nuevo_huesped, edad_nuevo_huesped, dni_nuevo_huesped);
        this.lista_huespedes.add(nuevo_huesped);
        this.lista_huespedes_sin_habitacion.add(nuevo_huesped);
    }

    public void nueva_reserva(){
        Scanner ingreso = new Scanner(System.in);
        System.out.println("Van a ser 1 o 2 personas?");
        int cant_personas_nueva_reserva = ingreso.nextInt();

        System.out.println("Seleccione el numero de hueped, si no esta en la lista escriba -1 para agregarlo");
        if (lista_huespedes_sin_habitacion.size() == 0){
            System.out.println();
            System.out.println("La lista esta vacia");
            System.out.println();
        }
        for (int i = 0; i < this.lista_huespedes_sin_habitacion.size(); i++){
            System.out.println("Nro: " + (i+1) + "  Nombre: " + (this.lista_huespedes_sin_habitacion.get(i)).get_nombre() + "  Apellido: " + (this.lista_huespedes_sin_habitacion.get(i)).get_apellido() + "  Edad: " + (this.lista_huespedes_sin_habitacion.get(i)).get_edad());
        }
        int id_nuevo_husped = -1;
        if(lista_huespedes_sin_habitacion.size() != 0){
            id_nuevo_husped = ingreso.nextInt();
        }
        if (id_nuevo_husped == -1){
            nuevo_huesped();
            id_nuevo_husped = this.lista_huespedes_sin_habitacion.size();
        }
        ArrayList<Huesped>  lista_huespedes_nueva_reserva= new ArrayList<Huesped>();
        lista_huespedes_nueva_reserva.add(this.lista_huespedes_sin_habitacion.get(id_nuevo_husped - 1));
        this.lista_huespedes_sin_habitacion.remove((id_nuevo_husped-1));


        if (cant_personas_nueva_reserva == 2) {
            System.out.println("Seleccione el numero de hueped, si no esta en la lista escriba -1 para agregarlo");
            if (lista_huespedes_sin_habitacion.size() == 0){
                System.out.println();
                System.out.println("La lista esta vacia");
                System.out.println();
            }
            for (int i = 0; i < this.lista_huespedes_sin_habitacion.size(); i++){
                if ( i != id_nuevo_husped - 1)
                System.out.println("Nro: " + (i+1) + "  Nombre: " + (this.lista_huespedes_sin_habitacion.get(i)).get_nombre() + "  Apellido: " + (this.lista_huespedes_sin_habitacion.get(i)).get_apellido() + "  Edad: " + (this.lista_huespedes_sin_habitacion.get(i)).get_edad());
            }
            int id_nuevo_husped2 = -1;
            if(lista_huespedes_sin_habitacion.size() != 0){
                id_nuevo_husped2 = ingreso.nextInt();
            }
            if (id_nuevo_husped2 == -1){
                nuevo_huesped();
                id_nuevo_husped2 = this.lista_huespedes_sin_habitacion.size();
            }
            lista_huespedes_nueva_reserva.add(this.lista_huespedes_sin_habitacion.get(id_nuevo_husped2 - 1));
            this.lista_huespedes_sin_habitacion.remove((id_nuevo_husped2-1));


        }

        System.out.println("Escribe la duracion de su estadia (dias)");
        int cant_dias_nueva_reserva = ingreso.nextInt();

        System.out.println("Elija la habitacion de estas disponibles");
        for(Habitacion habitaciones:this.lista_habitaciones){
            if (!esta_ocupada(habitaciones.get_nro_habitacion()) && habitaciones.get_capacidad() == cant_personas_nueva_reserva) {
                System.out.println("Habitacion nro " + (habitaciones.get_nro_habitacion()+1));
            }
        }
        int nro_habitacion_nueva_reserva = ingreso.nextInt() - 1;
        while (nro_habitacion_nueva_reserva < 0 || nro_habitacion_nueva_reserva > 12 || esta_ocupada(nro_habitacion_nueva_reserva) || this.lista_habitaciones.get(nro_habitacion_nueva_reserva).get_capacidad() != cant_personas_nueva_reserva){
            if (nro_habitacion_nueva_reserva < 0 || nro_habitacion_nueva_reserva > 12){
                System.out.println("La habitacion no existe, escriba un numero de habitacion valido");
                nro_habitacion_nueva_reserva = ingreso.nextInt() - 1;
            }
            else if (esta_ocupada(nro_habitacion_nueva_reserva)){
                System.out.println("La habitacion esta ocupada");
                nro_habitacion_nueva_reserva = ingreso.nextInt() - 1;
            }
            else if(this.lista_habitaciones.get(nro_habitacion_nueva_reserva).get_capacidad() != cant_personas_nueva_reserva){
                System.out.println("La habitacion es para un numero distinto de personas");
                nro_habitacion_nueva_reserva = ingreso.nextInt() - 1;
            }
        }

        Reserva nueva_reserva = new Reserva(this.fecha_hoy, cant_dias_nueva_reserva, this.lista_habitaciones.get(nro_habitacion_nueva_reserva), lista_huespedes_nueva_reserva);
        this.lista_reservas.add(nueva_reserva);
    }

    public ArrayList<Huesped> top_6_huespedes(){
        //Obtengo todos las cantidad de visitas
        ArrayList<Integer> cant_visitas_huesped = new ArrayList<Integer>();
        for(int i = 0; i < this.lista_huespedes.size(); i++){
            cant_visitas_huesped.add(0);
            for(Reserva reservas:this.lista_reservas){
                if(reservas.get_lista_huespedes().get(0) == this.lista_huespedes.get(i)){
                    cant_visitas_huesped.set(i, cant_visitas_huesped.get(i) + 1);
                }
                if (reservas.get_lista_huespedes().size() == 2 && reservas.get_lista_huespedes().get(1) == this.lista_huespedes.get(i)){
                    cant_visitas_huesped.set(i, cant_visitas_huesped.get(i) + 1);
                }
            }
        }
        //Lo ordeno
        ArrayList<Huesped> top_6_huespedes= new ArrayList<Huesped>();
        Huesped huesped_relleno = new Huesped("relleno","relleno", -1,-1);
        for (int j = 0; j < 6; j++){
            int id_huesped_mas_visitas = 0;
            for(int i = 0; i < cant_visitas_huesped.size(); i++){
                if(cant_visitas_huesped.get(i) > cant_visitas_huesped.get(id_huesped_mas_visitas)){
                    id_huesped_mas_visitas = i;
                }
            }
            if(cant_visitas_huesped.get(id_huesped_mas_visitas) == -1){
                top_6_huespedes.add(huesped_relleno);
            }
            else{
                top_6_huespedes.add(lista_huespedes.get(id_huesped_mas_visitas));
                cant_visitas_huesped.set(id_huesped_mas_visitas, -1);
            }
        }
        return top_6_huespedes;
    }

    public ArrayList<Habitacion> top_3_habitaciones(){
        //Obtengo todos las cantidad de requerimientos
        ArrayList<Integer> cant_requerimientos_habitaciones = new ArrayList<Integer>();
        for(int i = 0; i < this.lista_habitaciones.size(); i++){
            cant_requerimientos_habitaciones.add(0);
            for(Reserva reservas:this.lista_reservas){
                if(reservas.get_habitacion() == this.lista_habitaciones.get(i)){
                    cant_requerimientos_habitaciones.set(i, cant_requerimientos_habitaciones.get(i) + 1);
                }
            }
        }
        //Lo ordeno
        ArrayList<Habitacion> top_3_habitaciones= new ArrayList<Habitacion>();
        Habitacion habitacion_relleno =  new Habitacion(-1, -1);
        for (int j = 0; j < 3; j++){
            int id_habitaciones_mas_requeridas = 0;
            for(int i = 0; i < cant_requerimientos_habitaciones.size(); i++){
                if(cant_requerimientos_habitaciones.get(i) > cant_requerimientos_habitaciones.get(id_habitaciones_mas_requeridas)){
                    id_habitaciones_mas_requeridas = i;
                }
            }
            if(cant_requerimientos_habitaciones.get(id_habitaciones_mas_requeridas) == 0){
                top_3_habitaciones.add(habitacion_relleno);
            }
            else{
                top_3_habitaciones.add(lista_habitaciones.get(id_habitaciones_mas_requeridas));
                cant_requerimientos_habitaciones.set(id_habitaciones_mas_requeridas, -1);
            }
        }
        return top_3_habitaciones;
    }

    public double dinero_recaudado_total(){
        double dinero_total = 0;
        for(Reserva reservas:this.lista_reservas){
            if( reservas.get_habitacion().get_capacidad() == 1) {
                if (reservas.get_cant_dias() > 30) {
                    dinero_total = dinero_total + (reservas.get_cant_dias() * 545 * 0.75);
                }
                else {
                    dinero_total = dinero_total + (reservas.get_cant_dias() * 545);
                }
            }
            else {
                if (reservas.get_cant_dias() > 30) {
                    dinero_total = dinero_total + (reservas.get_cant_dias() * 785 * 0.75);
                }
                else {
                    dinero_total = dinero_total + (reservas.get_cant_dias() * 785);
                }
            }
        }
        return dinero_total;
    }

    public int cant_huespedes_estadia_prolongada(){
        ArrayList<Huesped> huespedes_ya_contados = new ArrayList<Huesped>();
        boolean ya_esta_huesped1 = false;
        boolean ya_esta_huesped2 = false;
        for (Reserva reservas : lista_reservas){
            if(reservas.get_cant_dias() > 30){
                for (Huesped huspedes_contados : huespedes_ya_contados){
                    if (reservas.get_lista_huespedes().get(0).get_dni() == huspedes_contados.get_dni()){
                        ya_esta_huesped1 = true;
                    }
                    if (reservas.get_lista_huespedes().size() == 2 && reservas.get_lista_huespedes().get(1).get_dni() == huspedes_contados.get_dni()){
                        ya_esta_huesped2 = true;
                    }
                }
                if(!ya_esta_huesped1){
                    huespedes_ya_contados.add(reservas.get_lista_huespedes().get(0));
                }
                ya_esta_huesped1 = false;
                if(reservas.get_lista_huespedes().size() == 2 && !ya_esta_huesped2){
                    huespedes_ya_contados.add(reservas.get_lista_huespedes().get(1));
                }
                ya_esta_huesped2 = false;
            }
        }
        return huespedes_ya_contados.size();
    }

    public ArrayList<Integer> lista_habitaciones_ocupadas (){
        ArrayList<Integer> habitaciones_ocupadas = new ArrayList<Integer>();
        for (Habitacion habitaciones : lista_habitaciones){
            if(esta_ocupada(habitaciones.get_nro_habitacion())){
                habitaciones_ocupadas.add(habitaciones.get_capacidad());
            }
        }
        return habitaciones_ocupadas;
    }

    public ArrayList<Integer> lista_habitaciones_libres (){
        ArrayList<Integer> habitaciones_ocupadas = new ArrayList<Integer>();
        for (Habitacion habitaciones : lista_habitaciones){
            if(!esta_ocupada(habitaciones.get_nro_habitacion())){
                habitaciones_ocupadas.add(habitaciones.get_nro_habitacion());
            }
        }
        return habitaciones_ocupadas;
    }

    public void huespedes_por_habitaciones(){
        boolean ya_paso = false;
        for(int i = 0; i < 13; i++){
            if (esta_ocupada(lista_habitaciones.get(i).get_nro_habitacion())){
                for(int j = lista_reservas.size()-1; j > -1 && !ya_paso; j--){
                    if(lista_reservas.get(j).get_habitacion().get_nro_habitacion() == i){
                        System.out.println("Habitacion nro " + (i+1));
                        System.out.println("Huesped 1: " + lista_reservas.get(j).get_lista_huespedes().get(0).get_nombre() + " " + lista_reservas.get(j).get_lista_huespedes().get(0).get_apellido());
                        ya_paso = true;
                        if(lista_reservas.get(j).get_lista_huespedes().size() == 2) {
                        System.out.println("Huesped 2: " + lista_reservas.get(j).get_lista_huespedes().get(1).get_nombre() + " " + lista_reservas.get(j).get_lista_huespedes().get(1).get_apellido());
                        }
                    }
                    System.out.println();
                    ya_paso = false;
                }
            }
        }
    }

    public void duracion_huespedes_por_reserva(){
        System.out.println("La duracion de cada huesped en cada reserva es / fue");
        for (Huesped huespedes : lista_huespedes) {
            System.out.println();
            System.out.println(huespedes.get_nombre() + " " + huespedes.get_apellido() + ": ");
            for (Reserva reserva : lista_reservas) {
                if (reserva.get_lista_huespedes().get(0).get_dni() == huespedes.get_dni()){
                    System.out.println(reserva.get_cant_dias() + " dias");
                }
                if (reserva.get_lista_huespedes().size() == 2 && reserva.get_lista_huespedes().get(1).get_dni() == huespedes.get_dni()){
                    System.out.println(reserva.get_cant_dias() + " dias");
                }
            }
        }
    }

    public void fechas_entrada_salida(int dni_huesped_a_consultar){
        boolean ya_esta = false;
        for(int i = lista_reservas.size()-1; i > -1 && !ya_esta; i--){
            if (lista_reservas.get(i).get_lista_huespedes().get(0).get_dni() == dni_huesped_a_consultar || (lista_reservas.get(i).get_lista_huespedes().size() == 2 && lista_reservas.get(i).get_lista_huespedes().get(1).get_dni() == dni_huesped_a_consultar)){
                ya_esta = true;
                if(lista_reservas.get(i).get_fecha_salida().es_mayor_a(this.fecha_hoy)){
                    System.out.println("Fecha entrada: " + lista_reservas.get(i).get_fecha_entrada().get_dia() + "/" + lista_reservas.get(i).get_fecha_entrada().get_mes() + "/" + lista_reservas.get(i).get_fecha_entrada().get_anio());
                    System.out.println("Fecha salida: " + lista_reservas.get(i).get_fecha_salida().get_dia() + "/" + lista_reservas.get(i).get_fecha_salida().get_mes() + "/" + lista_reservas.get(i).get_fecha_salida().get_anio());
                }
                else{
                    System.out.println("Su reserva ya ha expirado");
                }
            }
        }
        if (!ya_esta){
            System.out.println("No se ha encontrada al huesped en ninguna reserva");
        }
    }

    public void agregar_dias_estadia(int dni_huesped_a_consultar){
        Scanner ingreso = new Scanner(System.in);
        boolean ya_esta = false;
        for(int i = lista_reservas.size()-1; i > -1 && !ya_esta; i--){
            if (lista_reservas.get(i).get_lista_huespedes().get(0).get_dni() == dni_huesped_a_consultar || (lista_reservas.get(i).get_lista_huespedes().size() == 2 && lista_reservas.get(i).get_lista_huespedes().get(1).get_dni() == dni_huesped_a_consultar)){
                ya_esta = true;
                if(lista_reservas.get(i).get_fecha_salida().es_mayor_a(this.fecha_hoy)){
                    System.out.println("Cuantos dias desea agregar a su reserva?");
                    int dias_extra = ingreso.nextInt();
                    lista_reservas.get(i).set_cant_dias((lista_reservas.get(i).get_cant_dias() + dias_extra));
                }
                else{
                    System.out.println("Su reserva ya ha expirado");
                }
            }
        }
        if (!ya_esta){
            System.out.println("No se ha encontrada al huesped en ninguna reserva");
        }
    }

    public double importe_a_pagar(int dni_huesped_a_consultar){
        for(int i = lista_reservas.size()-1; i > -1; i--){
            if (lista_reservas.get(i).get_lista_huespedes().get(0).get_dni() == dni_huesped_a_consultar || (lista_reservas.get(i).get_lista_huespedes().size() == 2 && lista_reservas.get(i).get_lista_huespedes().get(1).get_dni() == dni_huesped_a_consultar)){
                if(this.lista_reservas.get(i).get_habitacion().get_capacidad() == 1) {
                    if (this.lista_reservas.get(i).get_cant_dias() > 30) {
                        return (this.lista_reservas.get(i).get_cant_dias() * 545 * 0.75);
                    }
                    else {
                        return (this.lista_reservas.get(i).get_cant_dias() * 545);
                    }
                }
                else {
                    if (this.lista_reservas.get(i).get_cant_dias() > 30) {
                        return (this.lista_reservas.get(i).get_cant_dias() * 785 * 0.75);
                    }
                    else {
                        return (this.lista_reservas.get(i).get_cant_dias() * 785);
                    }
                }
            }
        }
        System.out.println("No se ha encontrada al huesped en ninguna reserva");
        return -1;
    }
}
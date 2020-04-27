package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void mostrar_y__pedir_opcion(){
        System.out.println("Escriba la opcion");
        System.out.println("1. Agregar Husped");
        System.out.println("2. Agregar Reserva");
        System.out.println("3. Top 6 Huespedes mas frecuentes");
        System.out.println("4. Top 3 Habitaciones mas requeridas");
        System.out.println("5. Dinero totaL recaudado");
        System.out.println("6. Cantidad de huespedes que abonaron una estadia prolongada");
        System.out.println("7. Lista de habitaciones ocupadas");
        System.out.println("8. Lista de habitaciones libres");
        System.out.println("9. Huespedes por habitacion");
        System.out.println("10. El tiempo que se quedo cada huesped, cada vez que vino");
        System.out.println("11. Fechas entrada y salida del huesped");
        System.out.println("12. Agregar dias a la estadia");
        System.out.println("13. Importe a pagar");
        System.out.println("14. Terminar");
}

    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);
        int opcion;
        boolean seguir = true;
        System.out.println("Buenos dias!, ingese la fecha de hoy");
        Fecha fecha_hoy = new Fecha(0,0,0);
        System.out.println("Dia: ");
        fecha_hoy.setDia(ingreso.nextInt());
        System.out.println("Mes: ");
        fecha_hoy.setMes(ingreso.nextInt());
        System.out.println("Anio: ");
        fecha_hoy.setAnio(ingreso.nextInt());
        Hotel hotel = new Hotel(fecha_hoy);

        while(seguir){
            hotel.liberarHuespedes();
            mostrar_y__pedir_opcion();
            opcion = ingreso.nextInt();
            switch (opcion){
                case 1:
                    hotel.nuevoHuesped();
                    break;
                case 2:
                    hotel.nuevaReserva();
                    break;
                case 3:
                    ArrayList<Huesped> top_6_huespedes = hotel.top6Huespedes();
                    for(Huesped huesped:top_6_huespedes){
                        if (huesped.getEdad() != -1 || huesped.getDni() != -1) {
                            System.out.println(huesped.getNombre() + " " + huesped.getApellido());
                        }
                    }
                    break;
                case 4:
                    ArrayList<Habitacion> top_3_habitaciones = hotel.top3Habitaciones();
                    for(Habitacion habitacion : top_3_habitaciones){
                        if(habitacion.getNro_habitacion() != -1){
                            System.out.println("Habitacion nro " + (habitacion.getNro_habitacion()+1));
                        }
                    }
                    break;
                case 5:
                    double dinero_total = hotel.dineroRecaudHoTotal();
                    System.out.println("La cantidad total de dinero recaudada es: $" + dinero_total);
                    break;
                case 6:
                    int cant_huespedes_estadia_prolongada = hotel.cantHuespedesEstadiaProlongada();
                    System.out.println("La cantidad de huespedes con estadia prolongada es: " + cant_huespedes_estadia_prolongada);
                    break;
                case 7:
                    ArrayList<Integer> habitaciones_ocupadas= hotel.listaHabitacionesOcupadas();
                    System.out.println("Las habitaciones ocupadas son: ");
                    for(Integer habitaciones : habitaciones_ocupadas){
                        System.out.println("Habitacion nro " + (habitaciones+1));
                    }
                    break;
                case 8:
                    ArrayList<Integer> habitaciones_libres= hotel.listaHabitacionesLibres();
                    System.out.println("Las habitaciones libres son: ");
                    for(Integer habitaciones : habitaciones_libres){
                        System.out.println("Habitacion nro " + (habitaciones+1));
                    }
                    break;
                case 9:
                    hotel.huespedesPorHabitaciones();
                    break;
                case 10:
                    hotel.duracion_huespedes_por_reserva();
                    break;
                case 11:
                    System.out.println();
                    System.out.println("Ingrese el dni del huesped");
                    int dni_huesped_a_consultar_fecha = ingreso.nextInt();
                    hotel.fechasEntradaSalida(dni_huesped_a_consultar_fecha);
                    break;
                case 12:
                    System.out.println();
                    System.out.println("Ingrese el dni del huesped");
                    int dni_huesped_a_agregar_dias = ingreso.nextInt();
                    hotel.agregarDiasEstadia(dni_huesped_a_agregar_dias);
                    break;
                case 13:
                    System.out.println();
                    System.out.println("Ingrese el dni del huesped");
                    int dni_huesped_a_consultar_pago = ingreso.nextInt();
                    System.out.println("Importe a pagar: $" + hotel.importe_a_pagar(dni_huesped_a_consultar_pago));
                    break;
                case 14:
                    seguir = false;
                    System.out.println("Que tenga un buen dia");
                    break;
            }
            System.out.println();
        }

    }
}

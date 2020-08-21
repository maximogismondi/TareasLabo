package com.company;

import java.util.Scanner;

public class Main {

    public static void mostrarMenu(){
        System.out.println(" ____________________________________________");
        System.out.println("|                    MENU                    |");
        System.out.println("|                                            |");
        System.out.println("|   1) Alta mascota                          |");
        System.out.println("|   2) Baja mascota                          |");
        System.out.println("|   3) Modificar nombre                      |");
        System.out.println("|   4) Modificar dueno                       |");
        System.out.println("|   5) Saludar                               |");
        System.out.println("|   6) Alimentar                             |");
        System.out.println("|   0) Salir                                 |");
        System.out.println("| ___________________________________________|");
        System.out.println("Ingrese opcion: ");
    }

    public static void main(String[] args) {
        Veterinaria veterinaria = new Veterinaria();
        Scanner ingreso = new Scanner(System.in);
        boolean salir = false;

        while(!salir){
            mostrarMenu();
            int opcion = ingreso.nextInt();
            String basura = ingreso.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nombre de la mascota: ");
                    String nombre_mascota_nueva = ingreso.nextLine();
                    System.out.println("Ingrese el nombre del dueno: ");
                    String nombre_dueno_nueva = ingreso.nextLine();
                    System.out.println("Ingrese tipo mascota: ");
                    String tipo_mascota_nueva = ingreso.nextLine();
                    veterinaria.dar_de_alta(nombre_mascota_nueva, nombre_dueno_nueva, tipo_mascota_nueva);
                    break;

                case 2:
                    System.out.println("Ingrese el nombre de la mascota a dar de baja: ");
                    String nombre_mascota_a_eliminar = ingreso.nextLine();
                    veterinaria.dar_de_baja(nombre_mascota_a_eliminar);
                    break;

                case 3:
                    System.out.println("Ingrese el nombre de la mascota a modificar: ");
                    String nombre_mascota_a_modificar_nombre = ingreso.nextLine();
                    System.out.println("Ingrese el nuevo nombre de la mascota: ");
                    String nuevo_nombre_mascota = ingreso.nextLine();
                    veterinaria.cambiarNombre(nombre_mascota_a_modificar_nombre, nuevo_nombre_mascota);
                    break;

                case 4:
                    System.out.println("Ingrese el nombre de la mascota a modificar: ");
                    String nombre_mascota_a_modificar_dueno = ingreso.nextLine();
                    System.out.println("Ingrese el nuevo nombre del dueno: ");
                    String nuevo_nombre_dueno = ingreso.nextLine();
                    veterinaria.cambiarDueno(nombre_mascota_a_modificar_dueno, nuevo_nombre_dueno);
                    break;

                case 5:
                    System.out.println("Ingrese el nombre de la mascota a saludar: ");
                    String nombre_mascota_a_saludar = ingreso.nextLine();
                    System.out.println("Ingrese el nombre del dueno que saluda: ");
                    String nombre_dueno_que_saluda = ingreso.nextLine();
                    veterinaria.saludar(nombre_mascota_a_saludar, nombre_dueno_que_saluda);
                    break;

                case 6:
                    System.out.println("Ingrese el nombre de la mascota a alimentar: ");
                    String nombre_mascota_a_alimentar = ingreso.nextLine();
                    veterinaria.alimentar(nombre_mascota_a_alimentar);
                    break;

                case 0:
                    System.out.println("Adios!");
                    salir = true;
            }
        }
    }
}

package com.company;
import java.util.Scanner;

public class MainDatos {

    public static void main(String[] args) {

        Scanner ingreso = new Scanner(System.in);

        System.out.println("Escriba el nombre");
        String nombre = ingreso.nextLine();

        System.out.println("Escriba el apellido");
        String apellido = ingreso.nextLine();

        System.out.println("Escriba el ocupacion");
        String ocupacion = ingreso.nextLine();

        System.out.println("Escriba el edad");
        int edad = ingreso.nextInt();




        RegistroDeDatos Persona1 = new RegistroDeDatos(nombre, apellido, edad, ocupacion);

        System.out.println(nombre + apellido + edad + ocupacion);
    }
}

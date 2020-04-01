package com.company;
import java.util.Scanner;

public class MainCompras {

    public static void main(String[] args) {

        Scanner ingreso = new Scanner(System.in);

        System.out.println("Escriba el nombre");
        String nombre = ingreso.nextLine();

        System.out.println("Escriba la marca");
        String marca = ingreso.nextLine();

        System.out.println("Escriba el precio");
        float precio = ingreso.nextFloat();

        System.out.println("Escriba el nro de unidades");
        int unidades = ingreso.nextInt();


        RegistroDeCompras Compra1 = new RegistroDeCompras(nombre, marca, precio, unidades);

        System.out.println(nombre + marca + precio + unidades);
    }
}

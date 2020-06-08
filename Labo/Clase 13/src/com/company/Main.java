package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String [] args){

        Libreria libreria = new Libreria();

        libreria.agregarVenta("Kapelusz");
        libreria.agregarVenta("Kapelusz");
        libreria.agregarVenta("Kapelusz");
        libreria.agregarVenta("Kapelusz");
        libreria.agregarVenta("Kapelusz");
        libreria.agregarVenta("Sudamericana");
        libreria.agregarVenta("Sudamericana");
        libreria.agregarVenta("Sudamericana");
        libreria.agregarVenta("Sudamericana");
        libreria.agregarVenta("Atlantida");
        libreria.agregarVenta("Atlantida");
        libreria.agregarVenta("Sur");
        libreria.agregarVenta("Sur");
        libreria.agregarVenta("Sur");
        libreria.agregarVenta("Interzona");

        System.out.println(libreria.editorialConMasVentas());

        libreria.agregarEditorial("Santillana");

        libreria.agregarVenta("Santillana");
        libreria.agregarVenta("Santillana");

        System.out.println("Editorial mas vendida: " + libreria.cantidadVendidaEditorial("Sur"));

        libreria.eliminarEditorial("Sudamericana");

        libreria.eliminarVenta("Kapelusz");
        libreria.eliminarVenta("ElAteneo");

        //Por alguna razon no me imprime los objetos del HashMap haciendo:
        //System.out.println(libreria);

       libreria.imprimirTodo();
    }

}

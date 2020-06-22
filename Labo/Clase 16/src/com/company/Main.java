package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String [] args){

        Libreria libreria = new Libreria();

        libreria.agregarVenta("Kapelusz",1);
        libreria.agregarVenta("Kapelusz",3);
        libreria.agregarVenta("Sudamericana",5);
        libreria.agregarVenta("Alianza",2);
        libreria.agregarVenta("Sur",5);
        libreria.agregarVenta("Interzona",6);

        System.out.println("Editorial mas vendida: " + libreria.editorialConMasVentas());

        libreria.eliminarVenta("Kapelusz",2);
        libreria.eliminarVenta("ElAteneo", 3);

        libreria.imprimirTodo();
    }

}

package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String [] args){

        Libreria libreria = new Libreria();

        libreria.agregarVenta("Kapelusz","Lunes",1);
        libreria.agregarVenta("Kapelusz","Viernes",3);
        libreria.agregarVenta("Sudamericana","Sabado",5);
        libreria.agregarVenta("Alianza","Domingo",2);
        libreria.agregarVenta("Sur","Jueves",5);
        libreria.agregarVenta("Interzona","Lunes",6);

        System.out.println("Editorial mas vendida: " + libreria.editorialConMasVentas());
        System.out.println("Dia con mas ventas: " + libreria.diaConMasVentas());

        libreria.eliminarVenta("Kapelusz","Lunes",2);
        libreria.eliminarVenta("ElAteneo","Miercoles", 3);

        libreria.imprimirTodo();
    }
}

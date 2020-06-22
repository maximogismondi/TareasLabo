package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;

public class LibreriaScanner {

    private HashMap<ArrayList<Libro>, Integer> pedidos;

    public LibreriaScanner() {
        this.pedidos = new HashMap<>();
    }

    public void AgregarPedido(){
        Scanner ingreso = new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();
        boolean seguir = true;
        Integer precio = 0;

        while (seguir){
            System.out.println("De cuantas paginas queire el libro? (24, 48 o 96)");
            int paginas = ingreso.nextInt();
            switch (paginas){
                case 24:
                    libros.add(Libro.Chico);
                    precio += 50;
                    break;
                case 48:
                    libros.add(Libro.Mediano);
                    precio += 100;
                    break;
                case 96:
                    libros.add(Libro.Grande);
                    precio += 175;
                    break;
            }
            System.out.println("Quiere comprar otro libro? (S o N)");
            if (ingreso.nextLine() != "S"){
                seguir = false;
                System.out.println("Total: "+precio+"$");
            }
        }
        this.pedidos.put(libros, precio);
    }
}

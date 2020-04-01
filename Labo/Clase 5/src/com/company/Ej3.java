package com.company;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);

        int contador = -1;
        int suma = 0;
        int n = 0;

        while(n!=-1){
            suma = suma + n;
            contador++;
            System.out.println("Suma parcial: "+suma);
            System.out.println("Conteo de nros: "+contador);
            System.out.println("Ingrese un nro (-1 para terminar)");
            n = ingreso.nextInt();
        }
        System.out.println("Suma total: "+suma);
        System.out.println("Conteo final: "+contador);
    }
}

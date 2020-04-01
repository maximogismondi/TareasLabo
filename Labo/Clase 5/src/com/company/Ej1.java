package com.company;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);
        System.out.println("Ingrese 2 numeros");
        int numero1 = ingreso.nextInt();
        int numero2 = ingreso.nextInt();
        if(numero1>numero2){
            System.out.println("El numero mas grande es: "+numero1);
        }
        else if (numero1<numero2){
            System.out.println("El numero mas grande es: "+numero2);
        }
        else{
            System.out.println("Los numeros son iguales");
        }
    }
}
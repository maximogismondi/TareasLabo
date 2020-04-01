package com.company;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);

        System.out.println("Ingrese el nro de pares que desee ver");
        int n = ingreso.nextInt();

        for (int i = 1; i<=n; i++){
            System.out.println(2*i);
        }
    }
}

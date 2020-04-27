package com.company;
import java.util.Scanner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);
        Fecha fecha_hoy = new Fecha(27, 4, 2020);
        AppParaDeposito deposito = new AppParaDeposito(fecha_hoy);
        boolean terminar = false;
        while (!terminar) {
            System.out.println("");
            System.out.println("Elija una opcion: ");
            System.out.println("1. Ingresar / Egresar productos");
            System.out.println("2. Valor del stock del producto");
            System.out.println("3. Productos sin stock");
            System.out.println("4. Consultar el stock del producto");
            System.out.println("5. Productos con poco stock");
            System.out.println("6. Terminar");
            int opcion = ingreso.nextInt();
            switch (opcion){
                case 1:
                    deposito.ingresoEgresoProductos();
                    break;
                case 2:
                    deposito.valorDelStockProducto();
                    break;
                case 3:
                    deposito.productosSinStock();
                    break;
                case 4:
                    deposito.stockDelProducto();
                    break;
                case 5:
                    deposito.productosPocoStock();
                    break;
                case 6:
                    terminar = true;
                    break;
            }
        }
    }
}

package com.company;

public class Main {

    public static void main(String [] args){

        LibreriaVentas libreria = new LibreriaVentas();

        libreria.agregarEditorial("Santillana");

        Libro l1= new Libro("El libro de la selva","Kapelusz",200);
        Libro l2= new Libro("La Rosa de los Vientos","Kapelusz",500);
        Libro l3= new Libro("Puki","Kapelusz",150);
        Libro l4= new Libro("Dori la Novela","Sudamericana",350);
        Libro l5= new Libro("El emocionario","Atlantida",205);
        Libro l6= new Libro("Gol 7","ElAteneo",1050);
        Libro l7= new Libro("Annabell","Interzona",875);
        Libro l8= new Libro("Manual Matmatica 4","Interzona",605);
        Libro l9= new Libro("Manual Lengua 2","Sur",450);
        Libro l10= new Libro("Zoo loco","Santillana",150);

        Cliente c1 = new Cliente("Ana", 82, 1235456);
        Cliente c2 = new Cliente("Paola", 41, 2345578);
        Cliente c3 = new Cliente("Lucia", 11, 34578591);
        Cliente c4 = new Cliente("Pia", 8, 4567912);
        Cliente c5 = new Cliente("Maximo", 17, 56778923);
        Cliente c6 = new Cliente("Luciano", 40, 67381234);
        Cliente c7 = new Cliente("Matias", 45, 78911345);
        Cliente c8 = new Cliente("Soledad", 40, 893123467);
        Cliente c9 = new Cliente("Valentina", 21, 91348567);
        Cliente c10 = new Cliente("Pedro", 10, 789456172);

        libreria.agregarLibro(l1);
        libreria.agregarLibro(l2);
        libreria.agregarLibro(l3);
        libreria.agregarLibro(l4);
        libreria.agregarLibro(l5);
        libreria.agregarLibro(l6);
        libreria.agregarLibro(l7);
        libreria.agregarLibro(l8);
        libreria.agregarLibro(l9);
        libreria.agregarLibro(l10);

        libreria.eliminarLibro(l3.getNombre());
        libreria.eliminarLibro(l5.getNombre());

        libreria.agregarCliente(c1);
        libreria.agregarCliente(c2);
        libreria.agregarCliente(c3);
        libreria.agregarCliente(c4);
        libreria.agregarCliente(c5);
        libreria.agregarCliente(c6);
        libreria.agregarCliente(c7);
        libreria.agregarCliente(c8);
        libreria.agregarCliente(c9);
        libreria.agregarCliente(c10);

        System.out.println("Editorial mas vendida: " + libreria.editorialConMasVentas());

        libreria.eliminarEditorial("Sudamericana");

        libreria.agregarEditorialConDescuento("Kapelusz");
        libreria.agregarEditorialConDescuento("Interzona");
        libreria.agregarEditorialConDescuento("Sudamericana");

        libreria.eliminarEditorialConDescuento("Interzona");
        libreria.eliminarEditorialConDescuento("Sudamericana");

        libreria.agregarCompra(c1.getDni(), l1, 5);
        libreria.agregarCompra(c2.getDni(), l2, 3);
        libreria.agregarCompra(c3.getDni(), l3, 15);
        libreria.agregarCompra(c4.getDni(), l4, 4);
        libreria.agregarCompra(c1.getDni(), l5, 6);
        libreria.agregarCompra(c10.getDni(), l6, 3);
        libreria.agregarCompra(c6.getDni(), l2, 1);
        libreria.agregarCompra(c4.getDni(), l3, 1);
        libreria.agregarCompra(c3.getDni(), l4, 8);
        libreria.agregarCompra(78412536, l9, 10);

        System.out.println("");

        libreria.eliminarCompra(c1.getDni(), l5.getNombre());
        libreria.eliminarCompra(c10.getDni(), l6.getNombre());

        System.out.println("El total que ha gastado el c3 es :" + libreria.totalGastadoCliente(c3.getDni()));

    }

}

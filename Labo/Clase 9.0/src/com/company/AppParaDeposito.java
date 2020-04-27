package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class AppParaDeposito {

    ArrayList<ProductoAlimenticio> lista_producto_alimenticio;
    ArrayList<Integer> stock_por_producto_alimenticio;
    Fecha fecha_hoy;

    public AppParaDeposito (Fecha fecha_hoy){
        this.lista_producto_alimenticio = new ArrayList<ProductoAlimenticio>();
        this.stock_por_producto_alimenticio = new ArrayList<Integer>();
        this.fecha_hoy = fecha_hoy;
    }

    public ArrayList<ProductoAlimenticio> getLista_producto_alimenticio() {
        return lista_producto_alimenticio;
    }

    public ArrayList<Integer> getStock_por_producto_alimenticio() {
        return stock_por_producto_alimenticio;
    }

    public void setLista_producto_alimenticio(ArrayList<ProductoAlimenticio> lista_producto_alimenticio) {
        this.lista_producto_alimenticio = lista_producto_alimenticio;
    }

    public void setStock_por_producto_alimenticio(ArrayList<Integer> stock_por_producto_alimenticio) {
        this.stock_por_producto_alimenticio = stock_por_producto_alimenticio;
    }

    public void mostrarNombresYStockProductos(){
        System.out.println("Lista nombres y stock por producto:");
        for(int i = 0; i < this.lista_producto_alimenticio.size(); i++){
            System.out.println(this.lista_producto_alimenticio.get(i).getNombre() + " con " + this.stock_por_producto_alimenticio.get(i) + " unidades");
        }
    }

    public boolean nombreProductoEstaEnListaProductos(String nombre_producto_a_buscar){
        for (ProductoAlimenticio productos : this.lista_producto_alimenticio){
            if(nombre_producto_a_buscar.equals(productos.getNombre())){
                return true;
            }
        }
        return false;
    }

    public void ingresoProducto(){
        Scanner ingreso = new Scanner(System.in);

        boolean ya_esta_ocupado = true;
        System.out.println("Ingrese el nombre del producto");
        String nuevo_nombre = ingreso.nextLine();

        if(!nombreProductoEstaEnListaProductos(nuevo_nombre)){
            System.out.println("Ingrese la fecha de elaboracion");
            System.out.println("Dia: ");
            int nuevo_dia_fecha_elaboracion = ingreso.nextInt();
            System.out.println("Mes: ");
            int nuevo_mes_fecha_elaboracion = ingreso.nextInt();
            System.out.println("Anio: ");
            int nuevo_anio_fecha_elaboracion = ingreso.nextInt();
            Fecha nueva_fecha_elaboracion = new Fecha(nuevo_dia_fecha_elaboracion, nuevo_mes_fecha_elaboracion, nuevo_anio_fecha_elaboracion);

            System.out.println("Ingrese la fecha de caducidad");
            System.out.println("Dia: ");
            int nuevo_dia_fecha_vencimiento = ingreso.nextInt();
            System.out.println("Mes: ");
            int nuevo_mes_fecha_vencimiento = ingreso.nextInt();
            System.out.println("Anio: ");
            int nuevo_anio_fecha_vencimiento = ingreso.nextInt();
            Fecha nueva_fecha_caducidad = new Fecha(nuevo_dia_fecha_vencimiento, nuevo_mes_fecha_vencimiento, nuevo_anio_fecha_vencimiento);

            System.out.println("Ingrese el precio");
            int nuevo_precio = ingreso.nextInt();

            System.out.println("Ingrese el peso (g)");
            int nuevo_peso = ingreso.nextInt();

            System.out.println("Ingrese la cantidad de unidades que quiera agregar (stock)");
            int nuevo_stock = ingreso.nextInt();

            ProductoAlimenticio nuevo_producto_alimenticio = new ProductoAlimenticio(nuevo_nombre, nueva_fecha_elaboracion, nueva_fecha_caducidad, nuevo_precio, nuevo_peso);
            this.lista_producto_alimenticio.add(nuevo_producto_alimenticio);
            this.stock_por_producto_alimenticio.add(nuevo_stock);

            System.out.println("Se ha ingresado el producto correctamnte");
        }
        else{
            System.out.println("Ya se ha registrado este producto, ingrese la cantidad de unidades que quiera agregar");
            int nuevo_stock = ingreso.nextInt();
            int id_producto_a_modificar = 0;
            for (int i = 0; i < lista_producto_alimenticio.size(); i++){
                if (nuevo_nombre.equals(lista_producto_alimenticio.get(i).getNombre())){
                    id_producto_a_modificar = i;
                }
            }
            stock_por_producto_alimenticio.set(id_producto_a_modificar, getStock_por_producto_alimenticio().get(id_producto_a_modificar)+nuevo_stock);
            System.out.println("Se ha actualizado el stock correctamente");
        }


    }

    public void egresoProducto(){
        Scanner ingreso = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto a egresar");
        String nombre_producto_a_eliminar = ingreso.nextLine();
        while(!nombreProductoEstaEnListaProductos(nombre_producto_a_eliminar)){
            System.out.println("El producto no esta en la lista de productos, elija uno de estos");
            System.out.println("");
            mostrarNombresYStockProductos();
            System.out.println("Ingrese el nombre del producto");
            nombre_producto_a_eliminar = ingreso.nextLine();
        }

        int id_producto_a_eliminar = 0;
        for (int i = 0; i < this.lista_producto_alimenticio.size(); i++){
            if (nombre_producto_a_eliminar.equals(lista_producto_alimenticio.get(i).getNombre())){
                id_producto_a_eliminar = i;
            }
        }

        System.out.println("Ingrese la cantidad de unidades a egresar");
        int unidades_a_eliminar = ingreso.nextInt();

        while(unidades_a_eliminar > this.stock_por_producto_alimenticio.get(id_producto_a_eliminar)){
            System.out.println("Se quieren borrar mas unidades, de las almacenadas");
            System.out.println("Cantidad de unidades almacenadas " + this.stock_por_producto_alimenticio.get(id_producto_a_eliminar));
            System.out.println("Ingrese las unidades que deseea eliminar");
            unidades_a_eliminar = ingreso.nextInt();
        }

        stock_por_producto_alimenticio.set(id_producto_a_eliminar, stock_por_producto_alimenticio.get(id_producto_a_eliminar)-unidades_a_eliminar);

        System.out.println("Se han egresado " + unidades_a_eliminar + " unidade/s");
    }

    public void ingresoEgresoProductos(){
        Scanner ingreso = new Scanner(System.in);
        boolean seguir_modificando = true;
        System.out.println("Que deseea...");
        System.out.println("1. Ingresar Producto");
        System.out.println("2. Egresar Producto");
        int eleccion_Ingreso_Egreso = ingreso.nextInt();
        if(eleccion_Ingreso_Egreso == 1){
            ingresoProducto();
        }
        else if(eleccion_Ingreso_Egreso == 2){
            egresoProducto();
        }
    }

    public void valorDelStockProducto(){
        Scanner ingreso = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto a consultar");
        String nombre_producto_a_consultar = ingreso.nextLine();

        int id_producto_a_consltar = 0;
        if(nombreProductoEstaEnListaProductos(nombre_producto_a_consultar)){
            for (int i = 0; i < this.lista_producto_alimenticio.size(); i++){
                if (nombre_producto_a_consultar.equals(lista_producto_alimenticio.get(i).getNombre())){
                    id_producto_a_consltar = i;
                }
            }
            System.out.println("El valor eqivalente al stock del deposito es: $" + lista_producto_alimenticio.get(id_producto_a_consltar).getprecio()*stock_por_producto_alimenticio.get(id_producto_a_consltar));
        }
        else{
            System.out.println("No se ha encontrado el elemento");
        }
    }

    public void productosSinStock(){
        System.out.println("Estos productos no tienen stock:");
        for (int i = 0; i < lista_producto_alimenticio.size(); i++){
            if (stock_por_producto_alimenticio.get(i).equals(0)){
                System.out.println(lista_producto_alimenticio.get(i).getNombre());
            }
        }
    }

    public void stockDelProducto(){
        Scanner ingreso = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto a consultar");
        String nombre_producto_a_consultar = ingreso.nextLine();

        int id_producto_a_consltar = 0;
        if(nombreProductoEstaEnListaProductos(nombre_producto_a_consultar)){
            for (int i = 0; i < this.lista_producto_alimenticio.size(); i++){
                if (nombre_producto_a_consultar.equals(lista_producto_alimenticio.get(i).getNombre())){
                    id_producto_a_consltar = i;
                }
            }
            System.out.println();
            System.out.println("Hay " + stock_por_producto_alimenticio.get(id_producto_a_consltar) + " unidades de " + lista_producto_alimenticio.get(id_producto_a_consltar).getNombre());
        }
        else{
            System.out.println("No se ha encontrado el elemento");
        }
    }

    public void productosPocoStock(){
        System.out.println("Estos productos tienen menos de 15 unidades:");
        for (int i = 0; i < lista_producto_alimenticio.size(); i++){
            if (stock_por_producto_alimenticio.get(i) < 15){
                System.out.println(lista_producto_alimenticio.get(i).getNombre());
            }
        }
    }
}

package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class LibreriaVentas extends Libreria{

    private HashSet<String> editoriales_con_descuento;
    private HashSet<Cliente> clientes;
    private HashSet<Libro> libros;

    public LibreriaVentas() {
        super();
        this.editoriales_con_descuento = new HashSet<>();
        this.clientes = new HashSet<>();
        this.libros = new HashSet<>();
    }

    public void agregarEditorialConDescuento(String nombre_editorial){

        Boolean esta = false;
        for (HashMap.Entry<String, Integer> editorial : this.getEditoriales().entrySet()){
            if(editorial.getKey() == nombre_editorial){
                esta = true;
            }
        }

        if(esta){
            editoriales_con_descuento.add(nombre_editorial);
        }
        else{
            System.out.println(nombre_editorial + " no pertenece a la lista de editoriales, sera agregada a la lista de editoriales");
            this.agregarEditorial(nombre_editorial);
            editoriales_con_descuento.add(nombre_editorial);
        }

    }

    public void eliminarEditorialConDescuento(String nombre_editorial){
        Boolean esta = false;
        for (String editoriales : editoriales_con_descuento){
            if(editoriales == nombre_editorial){
                esta = true;
            }
        }

        if(esta){
            editoriales_con_descuento.remove(nombre_editorial);
        }
        else{
            System.out.println(nombre_editorial + " no pertenece a la lista de editoriales con descuento");
        }
    }

    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void agregarCompra(int dni, Libro libro_agregar, int cantidad){
        boolean esta_libro = false;
        boolean esta_cliente = false;
        for (Libro libro:libros){
            if(libro.getNombre() == libro_agregar.getNombre()){
                esta_libro = true;
            }
        }
        if (esta_libro){
            for (Cliente cliente:clientes){
                if(cliente.getDni() == dni){
                    esta_cliente = true;
                    cliente.agregarCompra(libro_agregar, cantidad);
                    agregarVenta(libro_agregar.getEditorial());
                }
            }
            if (!esta_cliente){
                System.out.println("El cliente no ha sido encontrado");
            }
        }
        else{
            System.out.println("El libro no ha sido encontrado");
        }
    }

    public void eliminarCompra(int dni, String nombre_libro){
        boolean esta_libro = false;
        boolean esta_cliente = false;
        for (Cliente cliente:clientes){
            if(cliente.getDni() == dni){
                esta_cliente = true;
                for (HashMap.Entry<Libro, Integer> compra : cliente.getCompras().entrySet()) {
                    if (compra.getKey().getNombre() == nombre_libro){
                        esta_libro= true;
                        cliente.eliminarCompra(compra.getKey());
                        eliminarVenta(compra.getKey().getEditorial());
                    }
                }
            }
        }
        if (!esta_cliente){
            System.out.println("El cliente no ha sido encontrado");
        }
        if (!esta_libro){
            System.out.println("El libro no ha sido encontrado");
        }
    }

    public int totalGastadoCliente(int dni){
        int totalGastado = 0;
        for (Cliente cliente : clientes) {
            for (HashMap.Entry<Libro, Integer> compra : cliente.getCompras().entrySet()) {
                totalGastado = totalGastado + precioLibro(compra.getKey().getNombre());
            }
        }
        return totalGastado;
    }

    public int precioLibro(String nombre_libro){
        for (Libro libro: libros){
            if (libro.getNombre() == nombre_libro){
                for (String editorial:editoriales_con_descuento){
                    if (libro.getEditorial() == editorial){
                        return libro.getPrecio()/2;
                    }
                }
            }
        }
        for (Libro libro: libros){
            if (libro.getNombre() == nombre_libro){
                return libro.getPrecio();
            }
        }
        return 0;
    }

    public void agregarLibro(Libro libro){
        libros.add(libro);
    }

    public void eliminarLibro(String nombre_libro){
        Libro libro_remover = new Libro("null","null",123456);
        for(Libro libro:libros){
            if (libro.getNombre() == nombre_libro){
                libro_remover = libro;
            }
        }
        libros.remove(libro_remover);
    }
}

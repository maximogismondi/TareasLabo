package com.company;
import java.util.HashSet;
import java.util.HashMap;

public class Libreria {

    private HashSet<Editorial> editoriales;

    public Libreria(){
        this.editoriales = new HashSet<>();
        this.editoriales.add(Editorial.Alianza);
        this.editoriales.add(Editorial.Atlántida);
        this.editoriales.add(Editorial.ElAteneo);
        this.editoriales.add(Editorial.Interzona);
        this.editoriales.add(Editorial.Kapelusz);
        this.editoriales.add(Editorial.Sudamericana);
        this.editoriales.add(Editorial.Sur);
    }

    private Editorial switchEditoriales(String nombre_editorial){
        Editorial editorial = null;
        switch (nombre_editorial){
            case "Kapelusz":
                return editorial.Kapelusz;
            case "Sudamericana":
                return editorial.Sudamericana;
            case "Atlántida":
                return editorial.Atlántida;
            case "ElAteneo":
                return editorial.ElAteneo;
            case "Interzona":
                return editorial.Interzona;
            case "Sur":
                return editorial.Sur;
            case "Alianza":
                return editorial.Alianza;
            default:
                return editorial;
        }
    }

    private String switchEditorialesInverso(Editorial editorial){
        switch (editorial){
            case Kapelusz:
                return "Kapelusz";
            case Sudamericana:
                return "Sudamericana";
            case Atlántida:
                return "Atlántida";
            case ElAteneo:
                return "ElAteneo";
            case Interzona:
                return "Interzona";
            case Sur:
                return "Sur";
            case Alianza:
                return "Alianza";
            default:
                return "No se ha encontrado";
        }
    }

    public void agregarVenta(String editorial, int cantidad){

        Editorial editorial_incrementar = switchEditoriales(editorial);
        editorial_incrementar.incrementarVentas(cantidad);

    }

    public int cantidadVendidaEditorial(String editorial){
        Editorial editorial_buscar = switchEditoriales(editorial);
        return editorial_buscar.getCant_ventas();
    }

    public void eliminarVenta(String editorial, int cantidad){
        Editorial editorial_decrementar = switchEditoriales(editorial);
        if(cantidadVendidaEditorial(editorial) >= cantidad){
            editorial_decrementar.incrementarVentas(-1*cantidad);
        }
        else {
            System.out.println("Da negatvo");
        }
    }

    public String editorialConMasVentas(){
        String editorial_con_mas_ventas = "Sur";
        int cantidad = -1;
        for (Editorial editorial : editoriales){
            if (editorial.getCant_ventas() > cantidadVendidaEditorial(editorial_con_mas_ventas)){
                editorial_con_mas_ventas = switchEditorialesInverso(editorial);
            }
        }
        return editorial_con_mas_ventas;
    }

    public void imprimirTodo(){
        for (Editorial editorial : editoriales){
            System.out.println("Editorial: " + switchEditorialesInverso(editorial) +  " Ventas: " + editorial.getCant_ventas());
        }
    }
}


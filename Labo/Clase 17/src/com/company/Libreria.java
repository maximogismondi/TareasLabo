package com.company;
import java.util.HashSet;
import java.util.HashMap;

public class Libreria {

    private HashSet<Editorial> editoriales;
    private HashSet<Dia> dias;

    public Libreria(){
        this.editoriales = new HashSet<>();
        this.editoriales.add(Editorial.Alianza);
        this.editoriales.add(Editorial.Atlántida);
        this.editoriales.add(Editorial.ElAteneo);
        this.editoriales.add(Editorial.Interzona);
        this.editoriales.add(Editorial.Kapelusz);
        this.editoriales.add(Editorial.Sudamericana);
        this.editoriales.add(Editorial.Sur);

        this.dias = new HashSet<>();
        this.dias.add(Dia.Lunes);
        this.dias.add(Dia.Martes);
        this.dias.add(Dia.Miercoles);
        this.dias.add(Dia.Jueves);
        this.dias.add(Dia.Viernes);
        this.dias.add(Dia.Sabado);
        this.dias.add(Dia.Domingo);
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

    private Dia switchDias(String nombre_dia){
        Dia dia = null;
        switch (nombre_dia){
            case "Lunes":
                return dia.Lunes;
            case "Martes":
                return dia.Martes;
            case "Miercoles":
                return dia.Miercoles;
            case "Jueves":
                return dia.Jueves;
            case "Viernes":
                return dia.Viernes;
            case"Sabado":
                return dia.Sabado;
            case "Domingo":
                return dia.Domingo;
            default:
                return dia;
        }
    }

    private String switchDiasInverso(Dia dia){
        switch (dia){
            case Lunes:
                return "Lunes";
            case Martes:
                return "Martes";
            case Miercoles:
                return "Miercoles";
            case Jueves:
                return "Jueves";
            case Viernes:
                return "Viernes";
            case Sabado:
                return "Sabado";
            case Domingo:
                return "Domingo";
            default:
                return "No se encontro";
        }
    }

    public void agregarVenta(String editorial, String dia, int cantidad){
        Editorial editorial_incrementar = switchEditoriales(editorial);
        editorial_incrementar.incrementarVentas(cantidad);
        Dia dia_incrementar = switchDias(dia);
        dia_incrementar.incrementarVentas(cantidad);
    }

    public int cantidadVendidaEditorial(String editorial){
        Editorial editorial_buscar = switchEditoriales(editorial);
        return editorial_buscar.getCant_ventas();
    }

    public int cantidadVendidaDia(String dia){
        Dia dia_incrementar = switchDias(dia);
        return dia_incrementar.getCant_ventas();
    }

    public void eliminarVenta(String editorial, String dia, int cantidad){
        Editorial editorial_decrementar = switchEditoriales(editorial);
        Dia dia_incrementar = switchDias(dia);
        if(cantidadVendidaEditorial(editorial) >= cantidad){
            editorial_decrementar.incrementarVentas(-1*cantidad);
        }
        else {
            System.out.println("Editorial da negatvo");
        }
        if(cantidadVendidaDia(dia) >= cantidad){
            dia_incrementar.incrementarVentas(-1*cantidad);
        }
        else {
            System.out.println("Dia da negatvo");
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

    public String diaConMasVentas(){
        String dia_con_mas_ventas = "Lunes";
        int cantidad = -1;
        for (Dia dia : dias){
            if (dia.getCant_ventas() > cantidadVendidaDia(dia_con_mas_ventas)){
                dia_con_mas_ventas = switchDiasInverso(dia);
            }
        }
        return dia_con_mas_ventas;
    }

    public void imprimirTodo(){
        for (Editorial editorial : editoriales){
            System.out.println("Editorial: " + switchEditorialesInverso(editorial) +  " Ventas: " + editorial.getCant_ventas());
        }
        for (Dia dia : dias){
            System.out.println("Dia: " + switchDiasInverso(dia) +  " Ventas: " + dia.getCant_ventas());
        }
    }
}


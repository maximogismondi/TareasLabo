package com.company;
import java.util.ArrayList;
import java.util.HashSet;

public class Veterinaria {

    HashSet<Mascota> listaDeMascota;
    Integer ano_actual = 2020;
    ArrayList<String> listaNombre = new ArrayList<>();

    public HashSet<String> razasDePerrosIncumplidoras(){
        HashSet<String> lista_aux = new HashSet<>();
        for(Mascota mascota_aux : listaDeMascota){
            if(mascota_aux.getTipo().equals("perro") && !mascota_aux.cumplimientoVisitasObligatorias(2020)){
                Perro perro_aux = (Perro)mascota_aux;
                lista_aux.add(perro_aux.getRaza());
            }
        }
        return lista_aux;
    }
    public String tipoMascotaConMayorCumplimiento(){
        int visitaPerros = 0, visitasGatos = 0, visitasTortugas = 0;
        int max_visitas  = -1;
        String tipo      = "";
        for(Mascota mascota_aux : listaDeMascota){
            if(mascota_aux.cumplimientoVisitasObligatorias(ano_actual)){
                switch (mascota_aux.getTipo()) {
                    case "perro":
                        visitaPerros++;
                        if(visitaPerros >= max_visitas){
                            max_visitas = visitaPerros;
                            tipo = "perro";
                        }
                        break;
                    case "gato":
                        visitasGatos++;
                        if(visitasGatos >= max_visitas){
                            max_visitas = visitasGatos;
                            tipo = "gato";
                        }
                        break;
                    case "tortuga":
                        visitasTortugas++;
                        if(visitasTortugas >= max_visitas){
                            max_visitas = visitasTortugas;
                            tipo = "tortuga";
                        }
                        break;
                }
            }
        }
        return tipo;
    }
    public String ingresarDueno(){
        String nombreDueno = "";
        try{
            System.out.print("ingrese nombre de dueño: ");
            nombreDueno = listaNombre.get(listaNombre.indexOf(input.nextLine()));
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("Ocurrio un error:  " + ex.getMessage());
        }
        return nombreDueno;
    }
}
package com.company;

import java.util.HashSet;

public class Veterinaria {

    HashSet<Mascota> mascotas;

    public Veterinaria() {
        this.mascotas = new HashSet<>();
    }

    public void dar_de_alta(String nombre_mascota, String nombre_persona, String tipo){
        switch (tipo){
            case "Perro":
                mascotas.add(new Perro(nombre_mascota, nombre_persona));
                break;
            case "Gato":
                mascotas.add(new Gato(nombre_mascota, nombre_persona));
                break;
            case "Pajaro":
                mascotas.add(new Pajaro(nombre_mascota, nombre_persona));
                break;
            case "Pez":
                mascotas.add(new Pez(nombre_mascota, nombre_persona));
                break;
            default:
                System.out.println("Tipo no valido de mascota (Perro, Gato, Pajaro, Pez)");
        }
    }

    public void dar_de_baja(String nombre_mascota){
        for(Mascota mascota : mascotas){
            if (mascota.getNombre().equals(nombre_mascota)){
                mascotas.remove(mascota);
            }
        }
    }

    public void alimentar(String nombre_mascota){
        for(Mascota mascota : mascotas){
            if (mascota.getNombre().equals(nombre_mascota)){
                mascota.alimentarse();
            }
        }
    }

    public void saludar(String nombre_mascota, String nombre_persona){
        for (Mascota mascota : mascotas){
            if (mascota.getNombre().equals(nombre_mascota)){
                mascota.saludar(nombre_persona);
                if (mascota.getTipo_mascota().equals("Pez")){
                    Pez pezAux = (Pez) mascota;
                    if (pezAux.getVidas() == 0){
                        mascotas.remove(mascota);
                    }
                }
            }
        }
    }

    public void cambiarNombre(String nombre_mascota_vieja, String nombre_mascota_nueva){
        for(Mascota mascota : mascotas){
            if (mascota.getNombre().equals(nombre_mascota_vieja)){
                mascota.setNombre(nombre_mascota_nueva);
            }
        }
    }

    public void cambiarDueno(String nombre_mascota_vieja, String nombre_dueno_nuevo){
        for(Mascota mascota : mascotas){
            if (mascota.getNombre().equals(nombre_mascota_vieja)){
                mascota.setDueno(nombre_dueno_nuevo);
            }
        }
    }

}

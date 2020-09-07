package com.company.Veterinaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Veterinaria {
    ArrayList<String>  listaNombre   = new ArrayList<>();
    ArrayList<Mascota> listaMascotas = new ArrayList<>();
    Scanner            input         = new Scanner(System.in);
    String             basura        = "";

    public String ingresoNombreMascota(boolean estado){ //true = baja o modificar / false = alta
        String  nombreMascota;
        boolean valido = estado;
        do {
            System.out.print("Ingrese nombre mascota: ");
            nombreMascota = input.nextLine();
            for (Mascota mascota_aux : listaMascotas) {
                if (nombreMascota.equals(mascota_aux.getNombre())){
                    valido = !valido;
                }
            }
            if(estado == false) valido = !valido;

        }while(valido == estado);
        return nombreMascota;
    }

    public void comprobarPezMuerto(){
        for (int i=0 ; i<listaMascotas.size() ; i++) {
            if(listaMascotas.get(i).tipoMascota().equals("pez")){
                if(((Pez) listaMascotas.get(i)).getVidas() == 0){
                    listaMascotas.remove(i);
                    System.out.println("Murio el pez xD");
                }
            }
        }
    }

    public void imgPerro(){
        System.out.println("                          _,)");
        System.out.println("                  _..._.-;-'" );
        System.out.println("               .-'     `("    );
        System.out.println("              /      ;   \\"  );
        System.out.println("             ;.' ;`  ,;  ;"   );
        System.out.println("            .'' ``. (  \\ ;"  );
        System.out.println("           / f_ _L \\ ;  )\\" );
        System.out.println("           \\/|` '|\\/;; <;/" );
        System.out.println("          ((; \\_/  (()"      );
        System.out.println("               \""            );
    }
    public void imgGato(){
        System.out.println("           ,_     _"          );
        System.out.println("           |\\\\_,-~/"        );
        System.out.println("           / _  _ |    ,--."  );
        System.out.println("          (  @  @ )   / ,-'"  );
        System.out.println("           \\  _T_/-._( ("    );
        System.out.println("           /         `. \\"   );
        System.out.println("          |         _  \\ |"  );
        System.out.println("           \\ \\ ,  /      |" );
        System.out.println("            || |-_\\__   /"   );
        System.out.println("          ((_/`(____,-'"      );
    }
    public void imgPez(){
        System.out.println("                /`·.¸"              );
        System.out.println("               /¸...¸`:·"           );
        System.out.println("           ¸. · ´ ¸ `· .¸. · ´)"    );
        System.out.println("          : ©): ´; ¸ {"             );
        System.out.println("           `· .¸` · ¸. · ´ \\ `· ¸)");
        System.out.println("               `\\ ´´ \\ ¸. · ´"    );
    }
    public void imgPajaro(){
        System.out.println("                                     ."     );
        System.out.println("                                    | \\/|" );
        System.out.println("            (\\   _                  ) )|/|");
        System.out.println("                (/            _----. /.'.'" );
        System.out.println("          .-._________..      .' @ _\\  .'" );
        System.out.println("          '.._______.   '.   /    (_| .')"  );
        System.out.println("            '._____.  /   '-/      | _.' "  );
        System.out.println("             '.______ (         ) ) \\"     );
        System.out.println("               '..____ '._       )  )"      );
        System.out.println("                  .' __.--\\  , ,  // (("   );
        System.out.println("                  '.'     |  \\/   (_.'(  " );
        System.out.println("                          '   \\ .' "       );
        System.out.println("                           \\   ("          );
        System.out.println("                            \\   '."        );
        System.out.println("                             \\ \\ '.)"     );
        System.out.println("                              '-'-'"        );
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

    public int menu(){
        int valorMenu = 0;
        System.out.println("______________________________________________");
        System.out.println("|                   MENU                     |");
        System.out.println("| sistema de Alta-Baja-Modificacion (ABM)    |");
        System.out.println("| (Aceptamos perros, gatos, peces y pajaros) |");
        System.out.println("|   1) Alta mascota                          |");
        System.out.println("|   2) Baja mascota                          |");
        System.out.println("|   3) Modificar mascota                     |");
        System.out.println("|   4) Saludar                               |");
        System.out.println("|   5) Alimentar                             |");
        System.out.println("|   6) Salir                                 |");
        System.out.println("|____________________________________________|");

        while(valorMenu>6 || valorMenu<1){
            System.out.print("Ingresar valor: ");
            valorMenu = input.nextInt();
            basura = input.nextLine();
        }

        return valorMenu;
    }

    public static void main(String[] args) {

        Veterinaria veterinaria = new Veterinaria();
                    veterinaria.listaNombre.add("Juan");
                    veterinaria.listaNombre.add("Carlos");
                    veterinaria.listaNombre.add("Matias");
                    veterinaria.listaNombre.add("Lionel");
                    veterinaria.listaNombre.add("Damian");
                    veterinaria.listaNombre.add("Demian");
                    veterinaria.listaNombre.add("Emian");
                    veterinaria.listaNombre.add("Franco");
                    veterinaria.listaNombre.add("Maximiliano");
                    veterinaria.listaNombre.add("Maximo");
                    veterinaria.listaNombre.add("Emiliano");
                    veterinaria.listaNombre.add("Marco");
                    veterinaria.listaNombre.add("Marcos");
                    veterinaria.listaNombre.add("Luis Ivan");
                    veterinaria.listaNombre.add("Juan");
                    veterinaria.listaNombre.add("Penelope");
                    veterinaria.listaNombre.add("Roza Melano");
                    veterinaria.listaNombre.add("Elva Ginon");
                    veterinaria.listaNombre.add("Labo Ludiada");

        int eleccion;

        do {
            System.out.println();
            eleccion = veterinaria.menu();
            switch (eleccion) {
                case 1:
                    String nombreMascotaAlta = veterinaria.ingresoNombreMascota(false);

                    String nombreDueno = veterinaria.ingresarDueno();
                    if (nombreDueno.equals("")) break;

                    System.out.print("ingrese tipo mascota: ");
                    String tipoMascota = veterinaria.input.nextLine();

                    Mascota nuevaMascota = null;
                    switch (tipoMascota) {
                        case "perro":
                            nuevaMascota = new Perro(nombreMascotaAlta, nombreDueno);
                            veterinaria.imgPerro();
                            break;
                        case "gato":
                            nuevaMascota = new Gato(nombreMascotaAlta, nombreDueno);
                            veterinaria.imgGato();
                            break;
                        case "pez":
                            nuevaMascota = new Pez(nombreMascotaAlta, nombreDueno);
                            veterinaria.imgPez();
                            break;
                        case "pajaro":
                            nuevaMascota = new Pajaro(nombreMascotaAlta, nombreDueno);
                            veterinaria.imgPajaro();
                            break;
                    }
                    System.out.println();
                    System.out.println("##############################################");
                    System.out.println("Dueño: " + nombreDueno + " | Animal: " + nombreMascotaAlta);
                    System.out.println("##############################################");

                    veterinaria.listaMascotas.add(nuevaMascota);

                    break;
                case 2:
                    String nombreMascotaBaja = veterinaria.ingresoNombreMascota(true);

                    for (int i=0 ; i<veterinaria.listaMascotas.size() ; i++) {
                        if (nombreMascotaBaja.equals(veterinaria.listaMascotas.get(i).getNombre())) {
                            veterinaria.listaMascotas.remove(i);
                        }
                    }

                    break;
                case 3:
                    String nombreMascotaModificar = veterinaria.ingresoNombreMascota(true);
                    int eleccionModificar;

                    for (int i = 0; i < veterinaria.listaMascotas.size(); i++) {
                        Mascota mascota_aux = veterinaria.listaMascotas.get(i);
                        if (nombreMascotaModificar.equals(mascota_aux.getNombre())) {
                            do {
                                System.out.print("Modificar nombre(1) o dueño(2): ");
                                eleccionModificar = veterinaria.input.nextInt();
                                veterinaria.basura = veterinaria.input.nextLine();
                            } while (eleccionModificar < 1 || eleccionModificar > 2);

                            switch (eleccionModificar) {
                                case 1:
                                    String nuevoNombreMascota = veterinaria.ingresoNombreMascota(false);
                                    mascota_aux.setNombre(nuevoNombreMascota);
                                    break;
                                case 2:
                                    String nuevoDueno = veterinaria.ingresarDueno();
                                    if (nuevoDueno.equals("")) break;
                                    mascota_aux.setDueno(nuevoDueno);
                                    break;
                            }
                        }
                    }

                    break;
                case 4:
                    String  nombreMascotaSaludar = veterinaria.ingresoNombreMascota(true);
                    boolean entro                = true;

                    String nombreDuenoSaludar = veterinaria.ingresarDueno();
                    if (nombreDuenoSaludar.equals("")) break;
                    System.out.println();

                    for (int i = 0; i < veterinaria.listaMascotas.size(); i++) {
                        if(entro){
                            if (veterinaria.listaMascotas.get(i).getDueno().equals(nombreDuenoSaludar) && veterinaria.listaMascotas.get(i).getNombre().equals(nombreMascotaSaludar)) {
                                veterinaria.listaMascotas.get(i).saludo(true);
                                entro = !entro;
                            }
                            else if (i == veterinaria.listaMascotas.size() - 1) {
                                veterinaria.listaMascotas.get(i).saludo(false);
                                entro = !entro;
                            }
                        }
                    }
                    veterinaria.comprobarPezMuerto();
                    break;
                case 5:
                    String nombreMascotaAlimentar = veterinaria.ingresoNombreMascota(true);

                    for (int i=0 ; i<veterinaria.listaMascotas.size() ; i++) {
                        if(nombreMascotaAlimentar.equals(veterinaria.listaMascotas.get(i).getNombre())){
                            veterinaria.listaMascotas.get(i).alimentar();
                        }
                    }
                    break;
            }
        }while(eleccion != 6);
    }
}

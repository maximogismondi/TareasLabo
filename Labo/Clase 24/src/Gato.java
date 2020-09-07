package com.company.Veterinaria;

public class Gato extends Mascota {
    private int alegria;

    public Gato(String nombre, String dueno) {
        super(nombre, dueno);
        this.alegria = 1;
    }

    @Override
    public String tipoMascota(){
        return "gato";
    }

    @Override
    public void saludo(boolean duenoCorrecto){
        if(duenoCorrecto){
            for (int i=0 ; i<alegria ; i++){
                System.out.println("miau ");
            }
        }
        else{
            System.out.println("MIAU!");
        }
    }

    @Override
    public void alimentar(){
        alegria++;
    }

    public int getAlegria() {
        return alegria;
    }

    public void setAlegria(int alegria) {
        this.alegria = alegria;
    }
}

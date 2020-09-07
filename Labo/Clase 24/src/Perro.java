package com.company.Veterinaria;

public class Perro extends Mascota {
    private int alegria;

    public Perro(String nombre, String dueno) {
        super(nombre, dueno);
        this.alegria = 1;
    }

    @Override
    public String tipoMascota(){
        return "perro";
    }

    @Override
    public void saludo(boolean duenoCorrecto){
        if(duenoCorrecto){
            for (int i=0 ; i<alegria ; i++){
                System.out.println("guau ");
            }
        }
        else{
            System.out.println("GUAU!");
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

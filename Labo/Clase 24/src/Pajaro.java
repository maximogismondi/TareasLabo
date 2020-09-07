package com.company.Veterinaria;

public class Pajaro extends Mascota  {
    private int alegria;

    public Pajaro(String nombre, String dueno) {
        super(nombre, dueno);
        this.alegria = 1;
    }

    @Override
    public String tipoMascota(){
        return "pajaro";
    }

    @Override
    public void saludo(boolean duenoCorrecto){
        if(duenoCorrecto){
            for (int i=0 ; i<alegria ; i++){
                System.out.println("pio ");
            }
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

package com.company.Veterinaria;

public class Pez extends Mascota  {
    private int vidas;

    public Pez(String nombre, String dueno) {
        super(nombre, dueno);
        this.vidas = 10;
    }

    @Override
    public String tipoMascota(){
        return "pez";
    }

    @Override
    public void saludo(boolean duenoCorrecto){
        if(duenoCorrecto){
            vidas--;
        }
        else{
            vidas = 0;
        }
    }

    @Override
    public void alimentar(){
        vidas++;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
}

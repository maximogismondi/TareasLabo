package com.company;

public class Pez extends Mascota{

    private int vidas;

    public Pez(String nombre, String dueno) {
        super(nombre, dueno);
        this.vidas = 10;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void saludar(String persona_actual){
        if(persona_actual.equals(this.getDueno())){
            this.vidas--;
        }
        else {
            this.vidas = 0;
        }
    }

    public void alimentarse(){
        this.vidas++;
    }

    public String getTipo_mascota(){
        return "Pez";
    }
}

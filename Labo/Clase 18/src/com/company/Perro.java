package com.company;

public class Perro extends Mascota{

    private int alegria;

    public Perro(String nombre, String dueno) {
        super(nombre, dueno);
        this.alegria = 1;
    }

    public int getAlegria() {
        return alegria;
    }

    public void setAlegria(int alegria) {
        this.alegria = alegria;
    }

    public void saludar(String persona_actual){
        if(persona_actual.equals(this.getDueno())){
            for (int i = 0; i < alegria; i++) {
                System.out.println("guau ");
            }
        }
        else {
            for (int i = 0; i < alegria; i++) {
                System.out.println("GUAU! ");
            }
        }
    }

    public void alimentarse(){
        this.alegria++;
    }

    public String getTipo_mascota(){
        return "Perro";
    }
}

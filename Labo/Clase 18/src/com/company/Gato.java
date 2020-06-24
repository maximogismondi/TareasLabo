package com.company;

public class Gato extends Mascota{

    private int alegria;

    public Gato(String nombre, String dueno ){
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
                System.out.println("miau ");
            }
        }
        else {
            for (int i = 0; i < alegria; i++) {
                System.out.println("MIAU! ");
            }
        }
    }

    public void alimentarse(){
        this.alegria++;
    }

    public String getTipo_mascota(){
        return "Gato";
    }
}

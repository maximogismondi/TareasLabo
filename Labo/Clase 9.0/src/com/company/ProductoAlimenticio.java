package com.company;

public class ProductoAlimenticio {
    // Atributos
    private String nombre;
    private Fecha fechaDeElaboracion;
    private Fecha fechaDeVencimiento;
    private int precio;
    private int peso;

    // Constructores
    public ProductoAlimenticio(String nombre, Fecha fechaDeElaboracion, Fecha fechaDeVencimiento, int precio, int peso){
        this.nombre = nombre;
        this.fechaDeElaboracion = fechaDeElaboracion;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.precio = precio;
        this.peso = peso;
    }

    // Métodos

    //Getters

    public String  getNombre(){
        return this.nombre;
    }

    public Fecha  getfechaDeElaboracion(){
        return this.fechaDeElaboracion;
    }

    public Fecha  getfechaDeVencimiento(){
        return this.fechaDeVencimiento;
    }

    public int  getprecio(){
        return this.precio;
    }

    public int  getpeso(){
        return this.peso;
    }

    //Setters
    public void setnombre(String nombre){
        this.nombre = nombre;
    }

    public void setfechaDeElaboracion(Fecha fechaDeElaboracion){
        this.fechaDeElaboracion = fechaDeElaboracion;
    }

    public void setfechaDeVencimiento(Fecha fechaDeVencimiento){
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public void setprecio(int precio){
        this.precio = precio;
    }

    public void setpeso(int peso){
        this.peso = peso;
    }

    //Funciones
    public boolean pesaMasDe5(){
        if(this.peso > 5){
            return true;
        }
        return false;
    }

    public boolean estaVencido(Fecha fechaActual){
        if(this.fechaDeVencimiento.esMayorA(fechaActual)){
            return true;
        }
        return false;
    }
}

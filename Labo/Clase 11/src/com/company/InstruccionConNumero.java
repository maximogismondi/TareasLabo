package com.company;

public class InstruccionConNumero extends Instruccion{

    private int valor;

    public InstruccionConNumero(){
        super();
        this.valor = 10;
    }

    public InstruccionConNumero(int valor){
        super();
        this.valor = valor;
    }

    public void duplicarValor(){
        this.setValor(this.getValor()*2);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}

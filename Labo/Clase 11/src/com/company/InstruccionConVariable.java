package com.company;

public class InstruccionConVariable extends Instruccion{

    private String nombreVariable;

    public InstruccionConVariable(){
        super();
        this.nombreVariable = "var";
    }

    public InstruccionConVariable(String nombre_variable){
        super();
        this.nombreVariable = nombre_variable;
    }

    public void cambiarNombrePorLaOperacion(){
        nombreVariable=this.getOperacion();
    }

    public String getNombreVariable() {
        return nombreVariable;
    }

    public void setNombreVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }
}

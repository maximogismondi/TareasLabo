package com.company;

public class Instruccion {
    private String operacion;


    //CONSTRUCTORES

        public Instruccion(){
            this.operacion = "Suma";
        }
        public Instruccion(String operacion) {
            this.operacion=operacion;
        }

        public String getOperacion() { return operacion; }

        public void setOperacion(String operacion) { this.operacion = operacion; }

}

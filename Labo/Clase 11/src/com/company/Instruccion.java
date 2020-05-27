package com.company;

public class Instruccion {
    private String operacion;
    private int valor;
    private String nombreVariable;

    //CONSTRUCTORES
        public Instruccion(String operacion, int valor) {
            this.operacion=operacion;
            this.valor=valor;
        }
        public Instruccion(String operacion) {
            this.operacion=operacion;
        }
        public Instruccion(String operacion, String variable) {
            this.operacion=operacion;
            this.nombreVariable=variable;
        }

    //GETTERS
        public int getValor() { return valor; }

        public String getOperacion() { return operacion; }

        public String getNombreVariable() {
        return nombreVariable;
    }

    //SETTERS
        public void setValor(int valor) { this.valor = valor; }

        public void setOperacion(String operacion) { this.operacion = operacion; }

        public void setNombreVariable(String nombreVariable) { this.nombreVariable = nombreVariable; }
}

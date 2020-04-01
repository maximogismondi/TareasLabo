package com.company;

public class RegistroDeCompras {

    private String nombre;
    private String marca;
    private float precio;
    private int unidades;

    public RegistroDeCompras(String nombre, String marca, Float precio, int unidades){
        this.nombre=nombre;
        this.marca=marca;
        this.precio=precio;
        this.unidades=unidades;
    }
        public String getNombre() {
            return nombre;
        }

        public String getMarca() {
            return marca;
        }

        public Float getPrecio() {
            return precio;
        }

        public int getUnidades() {
            return unidades;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public void setPrecio(float precio) {
            this.precio = precio;
        }

        public void setUnidades(int unidades) {
            this.unidades = unidades;
        }
}

package com.company;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int get_dia() {
        return dia;
    }

    public int get_mes() {
        return mes;
    }

    public int get_anio() {
        return anio;
    }

    public void set_dia(int dia) {
        this.dia = dia;
    }

    public void set_mes(int mes) {
        this.mes = mes;
    }

    public void set_anio(int anio) {
        this.anio = anio;
    }

    public void sumar_dias(int dias_a_agregar){

        this.dia = this.dia + dias_a_agregar;

        boolean ya_esta_sumada = false;

        while (!ya_esta_sumada){
            boolean anio_biciesto = false;
            if(this.anio % 4 == 0){
                anio_biciesto = true;
            }
            if (this.mes == 2 && !anio_biciesto && this.dia>28) {
                this.mes ++;
                this.dia = this.dia - 27;
            }
            else if (this.mes == 2 && anio_biciesto && this.dia>29) {
                this.mes ++;
                this.dia = this.dia - 28;
            }
            else if ((this.mes == 4 && this.dia > 30) || (this.mes == 6 && this.dia > 30) || (this.mes == 9 && this.dia > 30) || (this.mes == 11 && this.dia > 30)){
                    this.mes ++;
                    this.dia = this.dia - 29;
            }
            else if (this.dia > 31){
                this.mes ++;
                this.dia = this.dia - 30;
            }
            else if (this.mes > 12){
                this.anio ++;
                this.mes = this.mes - 11;
            }
            else{
                ya_esta_sumada = true;
            }
        }

    }

    public boolean es_mayor_a(Fecha fecha2){
        if(this.anio > fecha2.get_anio()){
            return true;
        }
        else if(this.anio == fecha2.get_anio() && this.mes > fecha2.get_mes()){
            return true;
        }
        else if(this.anio == fecha2.get_anio() && this.mes == fecha2.get_mes() && this.dia > fecha2.get_dia()){
            return true;
        }
        else{
            return false;
        }
    }
}

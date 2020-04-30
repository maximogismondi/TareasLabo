package com.company;

public class FechaYHora {

    private int dia;
    private int mes;
    private int anio;
    private int minuto;
    private int hora;

    public FechaYHora(int dia, int mes, int anio, int hora, int minuto){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.minuto = minuto;
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void sumarDias(int dias_a_agregar){

        this.dia = this.dia + dias_a_agregar;

        boolean ya_esta_sumada = false;

        while (!ya_esta_sumada){
            boolean anio_biciesto = false;
            
            if(this.anio % 4 == 0){
                anio_biciesto = true;
            }

            if (this.mes > 12){
                this.anio ++;
                this.mes = this.mes - 11;
            }

            else if (this.mes == 2 && !anio_biciesto && this.dia>28) {
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
            
            else{
                ya_esta_sumada = true;
            }
        }

    }

    public boolean esMayorA(FechaYHora fecha2){
        if(this.anio > fecha2.getAnio()){
            return true;
        }
        else if(this.anio == fecha2.getAnio() && this.mes > fecha2.getMes()){
            return true;
        }
        else if(this.anio == fecha2.getAnio() && this.mes == fecha2.getMes() && this.dia > fecha2.getDia()){
            return true;
        }
        else if(this.anio == fecha2.getAnio() && this.mes == fecha2.getMes() && this.dia == fecha2.getDia() && this.hora > fecha2.getHora()){
            return true;
        }
        else if(this.anio == fecha2.getAnio() && this.mes == fecha2.getMes() && this.dia == fecha2.getDia() && this.hora == fecha2.getHora() && this.minuto > fecha2.getMinuto()){
            return true;
        }
        else{
            return false;
        }
    }
}

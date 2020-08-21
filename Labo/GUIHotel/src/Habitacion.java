import java.util.ArrayList;

public class Habitacion {
    //Atributos
    private int numero;
    private int precioXDia;
    private int cantPersona;
    private int cantVecesSolicitadada;
    private boolean disponibilidad;
    //Constructores
    public Habitacion (int numeroIngresado, int precioXDiaIngresado, int cantPersonaIngresado, int cantVecesSolicitadadaIngresada, boolean disponibilidadIngresado){
        numero=numeroIngresado;
        precioXDia=precioXDiaIngresado;
        cantPersona=cantPersonaIngresado;
        cantVecesSolicitadada=cantVecesSolicitadadaIngresada;
        disponibilidad=disponibilidadIngresado;
    }
    //Metodos
    //Getters
    public int getNumero() {
        return numero;
    }
    public int getPrecioXDia() {
        return precioXDia;
    }
    public int getCantPersona() {
        return cantPersona;
    }
    public int getCantVecesSolicitadada() {
        return cantVecesSolicitadada;
    }
    public boolean getDisponibilidad(){
        return disponibilidad;
    }
    //Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setPrecioXDia(int precioXDia) {
        this.precioXDia = precioXDia;
    }
    public void setCantPersona(int cantPersona) {
        this.cantPersona = cantPersona;
    }
    public void setCantVecesSolicitadada(int cantVecesSolicitadada) {
        this.cantVecesSolicitadada = cantVecesSolicitadada;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


    //---------------------------------------------//


    public Habitacion devuelveHabitacionDeUnoMasSolicitada(Habitacion habDeUno, ArrayList<Habitacion> habitacionesAux){
        for(int i=1;i<8;i++){      /*no puedo cambiar el for porque no recorre entero el arreglo, si no que recorre una cantidad específica*/
            if(habDeUno.getCantVecesSolicitadada()<habitacionesAux.get(i).getCantVecesSolicitadada()){
                habDeUno = habitacionesAux.get(i);
            }
        }
        return  habDeUno;
    }


    //---------------------------------------------//


    public Habitacion devuelveHabitacionDeDosMasSolicitada(Habitacion habDeDos, ArrayList<Habitacion> habitacionesAux){
        for(int i=9;i<13;i++){      /*no puedo cambiar el for porque no recorre entero el arreglo, si no que recorre una cantidad específica*/
            if(habDeDos.getCantVecesSolicitadada()<habitacionesAux.get(i).getCantVecesSolicitadada()){
                habDeDos = habitacionesAux.get(i);
            }
        }
        return  habDeDos;
    }


    //-------------------------------------//

    public boolean buscarHuespedEnHabitacion(int largo, ArrayList <Hospedaje> listaHospedaje){
        if(this.getNumero()==listaHospedaje.get(largo).getHabit().getNumero() && listaHospedaje.get(largo).getHabit().getDisponibilidad()==false){
            return true;
        }
        return false;
    }

    //--------------------------------------------//
    public ArrayList <Habitacion> masSolicitadas(ArrayList <Habitacion> habitaciones){
        ArrayList <Habitacion> dos = new ArrayList<>();
        Habitacion solicitadaDeUno= habitaciones.get(0);
        Habitacion solicitadaDeDos= habitaciones.get(9);
        solicitadaDeUno=devuelveHabitacionDeUnoMasSolicitada(solicitadaDeUno,habitaciones);
        solicitadaDeDos=devuelveHabitacionDeDosMasSolicitada(solicitadaDeDos,habitaciones);
        dos.add(solicitadaDeUno);
        dos.add(solicitadaDeDos);
        return dos;
    }
    //---------------------------------------//
    public ArrayList <Habitacion> ocupadas(ArrayList <Habitacion> habitaciones){
        ArrayList <Habitacion> habitOcupadas = new ArrayList<>();
        for(Habitacion habAux:habitaciones){
            if(!habAux.getDisponibilidad()){
                habitOcupadas.add(habAux);
            }
        }
        return habitOcupadas;
    }
    //---------------------------------------//
    public ArrayList <Habitacion> disponible(ArrayList <Habitacion> habitaciones){
        ArrayList <Habitacion> habitDisponibles = new ArrayList<>();
        for(Habitacion habAux:habitaciones){
            if(habAux.getDisponibilidad()){
                habitDisponibles.add(habAux);
            }
        }
        return habitDisponibles;
    }

    //-------------------------------------------------//

    public Huesped huespedesActuales(ArrayList<Hospedaje> listaHospedaje) {
        Huesped actual = new Huesped("No Hay Nadie","Habitacion Vacia",00,00,00);
        if(!this.getDisponibilidad()){
            int largo = listaHospedaje.size();
            boolean comprobacion=false;
            while(largo>0 && !comprobacion){
                largo--;
                if(this.buscarHuespedEnHabitacion(largo, listaHospedaje)){
                    comprobacion=true;
                }
            }
            actual=listaHospedaje.get(largo).getHuesp();
        }
        return actual;
    }
    //---------------------------------------//
}


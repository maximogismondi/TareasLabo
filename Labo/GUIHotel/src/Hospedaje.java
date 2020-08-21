import java.util.ArrayList;

public class Hospedaje {
    //Atributos
    private Huesped huesp;
    private Habitacion habit;
    private String fechaEntrada;
    private String fechaSalida;
    private int costoTotal;
    private int cantDias;
    //Constructores
    public Hospedaje (Huesped huespIngresado, Habitacion habitIngresado, String fechaEntradaIngresado, String fechaSalidaIngresado, int costoTotalIngresado, int cantDiasIngresado){
        huesp=huespIngresado;
        habit=habitIngresado;
        fechaEntrada=fechaEntradaIngresado;
        fechaSalida=fechaSalidaIngresado;
        costoTotal=costoTotalIngresado;
        cantDias=cantDiasIngresado;
    }
    //Metodos
    //Getters
    public Huesped getHuesp() {
        return huesp;
    }
    public Habitacion getHabit() {
        return habit;
    }
    public String getFechaEntrada() {
        return fechaEntrada;
    }
    public String getFechaSalida() {
        return fechaSalida;
    }
    public int getCostoTotal() {
        return costoTotal;
    }
    public int getCantDias() {
        return cantDias;
    }
    //Setters
    public void setHuesp(Huesped huesp) {
        this.huesp = huesp;
    }
    public void setHabit(Habitacion habit) {
        this.habit = habit;
    }
    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }
    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }
    //Importantes
    public int SepararDia(String Fecha){
        String a= Fecha.substring(0,2);
        int b= Integer.parseInt(a);
        return b;
    }
    public int SepararMes(String Fecha){
        String a= Fecha.substring(3,5);
        int b= Integer.parseInt(a);
        return b;
    }
    public int SepararAnio(String Fecha){
        String a= Fecha.substring(6,10);
        int b= Integer.parseInt(a);
        return b;
    }
    public String JuntarFecha(int Dia,int Mes, int Anio){
        String fecha= Dia+"-"+Mes+"-"+Anio;
        return fecha;
    }

    //--------------------------------------//

    public boolean anioBisisto(int anio){
        if(anio%4==0){
            if(anio%100==0){
                if(anio%400==0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    //----------------------------//

    public int mesCorrespondiente(int mes){
        if(mes!=1 && mes!=2 && mes!=3 && mes!=5 && mes!=7 && mes!=8 && mes!=10 && mes!=12){
            return 1;
        }
        else if(mes!=2 && mes!=12){
            return 2;
        }
        else if(mes==2){
            return 3;
        }
        else{
            return 4;
        }
    }

    //---------------------------------------//
    public int dineroTotal(ArrayList <Hospedaje> listaHospedajes){
        int total=0;
        int largo=listaHospedajes.size();
        for(Hospedaje hosAux:listaHospedajes){
            total=total+hosAux.getCostoTotal();
        }
        return total;
    }

    //-----------------------------------//

    public int cantDiasQueSeQueda() {
        int dias=this.getCantDias();
        return dias;
    }

    //------------------------------//
    public ArrayList <Hospedaje> estadiasProlongadas(ArrayList <Hospedaje> listaHospedajes){
        ArrayList <Hospedaje> hospedajeProlongado = new ArrayList<>();
        for(Hospedaje hosAux:listaHospedajes){
            if(hosAux.getCantDias()>=30){
                int contadorDeDesiguales=0;
                for(Hospedaje hosAux2:hospedajeProlongado){
                    if(hosAux2.getHuesp()!=hosAux.getHuesp()){
                        contadorDeDesiguales++;
                    }
                }
                if(contadorDeDesiguales==hospedajeProlongado.size()) {
                    hospedajeProlongado.add(hosAux);
                }
            }
        }
        return hospedajeProlongado;
    }
    //--------------------------------------------------//

    public Hospedaje todasLasFechas() {
        return this;
    }
    //------------------------------------------------//

    public void agregarDias(int DiasAgregar){
        String Salida= this.getFechaSalida();
        this.cantDias=this.getCantDias()+DiasAgregar;
        int diaS= SepararDia(Salida);
        int mesS= SepararMes(Salida);
        int anioS= SepararAnio(Salida);
        while(DiasAgregar!=0){
            int mes=mesCorrespondiente(mesS);
            if(anioBisisto(anioS)){
                //bisiesto
                if(mes==1){
                    if(diaS+1>30){
                        diaS=1;
                        mesS++;
                    }
                    else{
                        diaS++;
                    }
                }
                else if(mes==2){
                    if(diaS+1>31){
                        diaS=1;
                        mesS++;
                    }
                    else{
                        diaS++;
                    }
                }
                else if(mes==3){
                    if(diaS+1>29){
                        diaS=1;
                        mesS++;
                    }
                    else{
                        diaS++;
                    }
                }
                else{
                    if(diaS+1>31){
                        diaS=1;
                        mesS=1;
                        anioS++;
                    }
                    else{
                        diaS++;
                    }
                }
            }
            else{
                //no bisiesto
                if(mes==1){
                    if(diaS+1>30){
                        diaS=1;
                        mesS++;
                    }
                    else{
                        diaS++;
                    }
                }
                else if(mes==2){
                    if(diaS+1>31){
                        diaS=1;
                        mesS++;
                    }
                    else{
                        diaS++;
                    }
                }
                else if(mes==3){
                    if(diaS+1>28){
                        diaS=1;
                        mesS++;
                    }
                    else{
                        diaS++;
                    }
                }
                else{
                    if(diaS+1>31){
                        diaS=1;
                        mesS=1;
                        anioS++;
                    }
                    else{
                        diaS++;
                    }
                }
            }
            DiasAgregar--;
        }
        String fechaSalidaa= JuntarFecha(diaS,mesS,anioS);
        this.setFechaSalida(fechaSalidaa);
    }

    //----------------------------------------------//
    public void nuevoMontoTotal (int nuevosDias){
        int totaldias=nuevosDias+this.getCantDias();
        int costoTot=totaldias*this.getHabit().getPrecioXDia();
        this.setCostoTotal(costoTot);
    }
}

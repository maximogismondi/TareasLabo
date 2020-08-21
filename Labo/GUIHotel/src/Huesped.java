import java.util.ArrayList;

public class Huesped extends Persona {
    //Atributo
    private String apellido;
    private int dni;
    private int cantDeEstadias;

    //Constructores
    public Huesped(String nombreIngresado, String apellidoIngresado, int edadIngresado, int dniIngresado, int cantDeEstadiasIngresado) {
        super(nombreIngresado,edadIngresado);
        apellido = apellidoIngresado;

        dni = dniIngresado;
        cantDeEstadias = cantDeEstadiasIngresado;
    }

    //Metodos
    //Getters
    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public int getCantDeEstadias() {
        return cantDeEstadias;
    }

    //Settets
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setCantDeEstadias(int cantDeEstadias) {
        this.cantDeEstadias = cantDeEstadias;
    }

    //------------------------------------------//
    public ArrayList<Huesped> seisFrecuentes(ArrayList<Huesped> huespedes) {
        ArrayList<Huesped> seis = new ArrayList<>();
        ArrayList<Huesped> ayuda=new ArrayList<>();
        for(int i=0;i<huespedes.size();i++){
            Huesped aux2=huespedes.get(i);
            ayuda.add(aux2);
        }
        for (int i = 0; i < 6; i++) { /*Este for no se puede reemplazar porque no estoy recorriendo, si no que estoy usandolo para repetir*/
            int contador = 0;
            int posicion = 0;
            Huesped haux = ayuda.get(posicion);
            for (Huesped h1 : ayuda) {
                if (h1.getCantDeEstadias() > haux.getCantDeEstadias()) {
                    haux = h1;
                    posicion = contador;
                }
                contador++;
            }
            seis.add(haux);
            ayuda.remove(posicion);
        }
        return seis;
    }
}



public class Empleado extends Persona {

    private String ocupacion;

    public Empleado(){
        super();
        this.ocupacion = "científico";
    }

    public Empleado(String nombre){
        super(nombre);
        this.ocupacion = "ingeniero";
    }

    public boolean puedeVotar(){
        boolean esMayor = super.esMayorDeEdad();
       /*
        * también se puede escribir:
        *  boolean esMayor = this.esMayorDeEdad();
        */
        return esMayor;
    }
}

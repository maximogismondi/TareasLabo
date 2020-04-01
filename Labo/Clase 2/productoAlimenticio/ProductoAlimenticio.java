public class ProductoAlimenticio {

    // Atributos
    private String nombre;
    private Date fechaDeElaboracion;
    private Date fechaDeVencimiento;
    private int precio;
    private int peso;

    // Constructores
    public Rectangulo(String nombrex, Date fechaDeElaboracionx, Date fechaDeVencimientox, int preciox, int pesox){
        nombre = nombrex;
        fechaDeElaboracion = fechaDeElaboracionx;
        fechaDeVencimiento = fechaDeVencimientox;
        precio = preciox;
        peso = pesox;
    }

    // Métodos

    //Getters
    
    public void  getnombre(){
        return this.nombre;
    }

    public void  getfechaDeElaboracion(){
        return this.fechaDeElaboracion;
    }

    public void  getfechaDeVencimiento(){
        return this.fechaDeVencimiento;
    }

    public void  getprecio(){
        return this.precio;
    }

    public void  getpeso(){
        return this.peso;
    }

    //Setters
    public void setnombre(int nombrex){
        this.nombre = nombrex;
    }

    public void setfechaDeElaboracion(int fechaDeElaboracionx){
        this.fechaDeElaboracion = fechaDeElaboracionx;
    }

    public void setfechaDeVencimiento(int fechaDeVencimientox){
        this.fechaDeVencimiento = fechaDeVencimientox;
    }

    public void setprecio(int preciox){
        this.precio = preciox;
    }

    public void setpeso(int pesox){
        this.peso = pesox;
    }

    //Funciones 
    public boolean pesaMasDe5(){
        if(this.peso > 5){
            return true;
        }
        return false;
    }

    public boolean estaVencido(Date fechaActual){
        if(this.fechaDeVencimiento > fechaActual){
            return true;
        }
        return false;
    }
}
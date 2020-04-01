public class OrdenDeCompras {

    // Atributos
    private int importeAPagar;
    private int cliente;
    private int cantTotalDeProductos;
    private String formaDePago;
    private Date fecha;
    private Time hora;
    

    // Constructores
    public Rectangulo(int importeAPagarx, int clientex, int cantTotalDeProductosx, String formaDePagox, Date fechax, Time horax){
        importeAPagar = importeAPagarx;
        cliente = clientex;
        cantTotalDeProductos = cantTotalDeProductosx;
        formaDePago = formaDePagox;
        fecha = fechax;
        hora = horax;
    }

    // Métodos

    //Getters
    
    public void  getimporteAPagar(){
        return this.importeAPagar;
    }

    public void  getcliente(){
        return this.cliente;
    }

    public void  getcantTotalDeProductos(){
        return this.cantTotalDeProductos;
    }

    public void  getformaDePago(){
        return this.formaDePago;
    }

    public void  getfecha(){
        return this.fecha;
    }

    public void  gethora(){
        return this.hora;
    }

    //Setters
    public void setimporteAPagar(int importeAPagarx){
        this.importeAPagar = importeAPagarx;
    }

    public void setcliente(int clientex){
        this.cliente = clientex;
    }

    public void setcantTotalDeProductos(int cantTotalDeProductosx){
        this.cantTotalDeProductos = cantTotalDeProductosx;
    }

    public void setformaDePago(String formaDePagox){
        this.formaDePago = formaDePagox;
    }

    public void setfecha(Date fechax){
        this.fecha = fechax;
    }

    public void sethora(Time horax){
        this.hora = horax;
    }

    //Funciones 
    public boolean esMenorA255(){
        if(this.cantTotalDeProductos<255){
            return true;
        }
        return false;
    }

    public boolean pagaraEnEfectivo(){
        if(this.formaDePago=="Efectivo"{
            return true;
        }
        return false;
    }
}
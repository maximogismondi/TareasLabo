import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {
    private String mesa;
    private HashMap<String,Integer> platos;
    private String estado;

    public Pedido(){
        mesa    = " ";
        platos  = new HashMap<>();
        estado  = " ";
    }

    public Pedido(String mesa, HashMap<String,Integer> platos){
        this.mesa   = mesa;
        this.platos = platos;
        this.estado = "En espera";
    }

    public String getNumeroDeMesa() {
        return mesa;
    }

    public HashMap<String,Integer> getPlatos() {
        return platos;
    }

    public String getEstado() {
        return estado;
    }

    public void setNumeroDeMesa(String mesa) {
        this.mesa = mesa;
    }

    public void setPlatos(HashMap<String,Integer> platos) {
        this.platos = platos;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

package com.company;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Restaruante {

    private HashSet<String> comidas;
    private HashSet<Pedido> pedidos;
    private HashMap<Integer, Pedido> mesas;

    public Restaruante() {
        this.comidas = new HashSet<>();
        this.comidas.add("Milanesa con puré de papas");
        this.comidas.add("Ravioles rellenos con carne");
        this.comidas.add("Pizza a la Piedra");
        this.comidas.add("Polenta con salsa Fileto");
        this.comidas.add("Arroz primavera");
        this.pedidos = new HashSet<>();
        this.mesas = new HashMap<>();
    }

    public void nueva_comida(String nombre_comida){
        this.comidas.add(nombre_comida);
    }

    public void eliminar_comida(String nombre_comida){
        this.comidas.remove(nombre_comida);
    }

    public void agregar_mesas(Integer cant_mesas){
        int ultimo_nro_mesa = 0;
        for (HashMap.Entry<Integer, Pedido> mesa : this.mesas.entrySet()){
            if (ultimo_nro_mesa < mesa.getKey()){
                ultimo_nro_mesa = mesa.getKey();
            }
        }
        for (int i = 1; i <= cant_mesas; i++) {
            this.mesas.put(ultimo_nro_mesa+i , new Pedido());
        }
    }

    public void eliminar_mesa(Integer nro_mesa){
        this.mesas.remove(nro_mesa);
    }

    public void agregar_pedido(Integer nro_mesa, ArrayList<String> comidas_pedido, int dia,int mes,int anio,int hora ,int minuto){
        int numero_ultimo_pedido = 0;
        for (HashMap.Entry<Integer, Pedido> mesa : this.mesas.entrySet()){
            if (numero_ultimo_pedido < mesa.getValue().getNro_pedido()){
                numero_ultimo_pedido = mesa.getValue().getNro_pedido();
            }
        }
        this.mesas.replace(nro_mesa, new Pedido(numero_ultimo_pedido, nro_mesa, comidas_pedido, dia, mes, anio, hora, minuto));
    }

    public void limpiar_mesa(Integer nro_mesa){
        Pedido pediodo_a_guardar = mesas.get(nro_mesa);
        mesas.remove(nro_mesa);
        pedidos.add(pediodo_a_guardar);
    }

    public HashSet<Integer> nro_mesa_segun_plato(String nombre_comida){
        HashSet<Integer> nro_mesas_correspondientes = new HashSet<>();
        for (HashMap.Entry<Integer, Pedido> mesa : this.mesas.entrySet()){
            for (int i = 0; i < mesa.getValue().getComidas().size(); i++) {
                if (mesa.getValue().getComidas().get(i).equals(nombre_comida)){
                    nro_mesas_correspondientes.add(mesa.getKey());
                }
            }
        }
        return nro_mesas_correspondientes;
    }

    public void mostrar_pedidos(){
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido nro " + pedido.getNro_pedido());
            for (int i = 0; i < pedido.getComidas().size(); i++) {
                System.out.println(pedido.getComidas().get(i));
            }
            System.out.println();
        }
    }

    public String comida_mas_pedida_del_dia(int dia, int mes, int anio){
        String nombre_comida_mas_pedida = "";
        int contador_comidas_mas_pedida = 0;
        for (String comida : this.comidas) {
            int contador_actual = 0;
            for (Pedido pedido : this.pedidos){
                if (pedido.getFechaYHora().mismoDia(new FechaYHora(dia, mes, anio, 0,0))) {
                    for (int i = 0; i < pedido.getComidas().size(); i++) {
                        if (comida.equals(pedido.getComidas().get(i))){
                            contador_actual++;
                        }
                    }
                }
            }
            if (contador_actual > contador_comidas_mas_pedida){
                nombre_comida_mas_pedida = comida;
                contador_comidas_mas_pedida =contador_actual;
            }
        }
        return nombre_comida_mas_pedida;
    }

    public String comida_menos_pedida_del_dia(int dia, int mes, int anio){
        String nombre_comida_menos_pedida = "";
        int contador_comidas_menos_pedida = 0;
        for (String comida : this.comidas) {
            int contador_actual = 0;
            for (Pedido pedido : this.pedidos){
                if (pedido.getFechaYHora().mismoDia(new FechaYHora(dia, mes, anio, 0,0))) {
                    for (int i = 0; i < pedido.getComidas().size(); i++) {
                        if (comida.equals(pedido.getComidas().get(i))){
                            contador_actual++;
                        }
                    }
                }
            }
            if (contador_actual < contador_comidas_menos_pedida){
                nombre_comida_menos_pedida = comida;
                contador_comidas_menos_pedida =contador_actual;
            }
        }
        return nombre_comida_menos_pedida;
    }

    public int nro_pedido_a_entregar_mas_proximo(){
        int nro_pedido_a_entregar_mas_proximo = 0;
        for (Pedido pedido:pedidos){
            nro_pedido_a_entregar_mas_proximo = pedido.getNro_pedido();
        }

        FechaYHora fechaYHora_pedido_a_entregar_mas_proximo = new FechaYHora();
        for (HashMap.Entry<Integer, Pedido> mesa : this.mesas.entrySet()){
            for(Pedido pedido:pedidos){
                if(pedido.getNro_pedido() == nro_pedido_a_entregar_mas_proximo){
                    fechaYHora_pedido_a_entregar_mas_proximo = pedido.getFechaYHora();
                }
            }
            if(mesa.getValue().getFechaYHora().esMenorA(fechaYHora_pedido_a_entregar_mas_proximo)){
                nro_pedido_a_entregar_mas_proximo = mesa.getValue().getNro_pedido();
                fechaYHora_pedido_a_entregar_mas_proximo = mesa.getValue().getFechaYHora();
            }
        }
        return nro_pedido_a_entregar_mas_proximo;
    }

    public int mesa_mas_ocupada_del_dia(int dia, int mes, int anio){
        int nro_mesa_mas_ocupada = 0;
        int contador_mesa_mas_ocupada = 0;
        for (HashMap.Entry<Integer, Pedido> mesa : this.mesas.entrySet()) {
            int contador_actual = 0;
            for (Pedido pedido : this.pedidos){
                if (pedido.getFechaYHora().mismoDia(new FechaYHora(dia, mes, anio, 0,0))) {
                    if (mesa.getKey() == pedido.getNro_mesa()){
                        contador_actual++;
                    }
                }
            }
            if (contador_actual > contador_mesa_mas_ocupada){
                nro_mesa_mas_ocupada = mesa.getKey();
                contador_mesa_mas_ocupada = contador_actual;
            }
        }
        return nro_mesa_mas_ocupada;
    }

}

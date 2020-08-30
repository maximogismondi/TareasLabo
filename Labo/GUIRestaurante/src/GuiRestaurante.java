
package com.company.RestauranteGUI;

import com.company.AccesoBaseDeDatos;
import com.company.Restaurante.Pedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class GuiRestaurante{
    AccesoBaseDeDatos        BasePlato           = new AccesoBaseDeDatos("laboratorio", "plato");
    HashMap<String, Integer> menu                = new HashMap<>();
    ArrayList<Pedido>        listaPedidos        = new ArrayList<>();
    JPanel                   contenedor          = new JPanel(new BorderLayout());
    boolean                  cantMesasDefinidas  = false;
    int                      cantMesas           = 4;
    JFrame                   ventana             = new JFrame("Restaurate");

    public static void main(String[] args) {
        GuiRestaurante restaurante = new GuiRestaurante();

        restaurante.BasePlato.conectar("root","");

        restaurante.ventana.setLayout(new BorderLayout());
        restaurante.ventana.setSize(700,600);
        restaurante.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        restaurante.ventana.setResizable(false);

        restaurante.contenedor.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, Color.DARK_GRAY));

        JMenuBar menu = new JMenuBar();

        JMenu opcionMenu1 = new JMenu("| Pedido |");
        JMenu opcionMenu2 = new JMenu("| Carta |");
        JMenu opcionMenu3 = new JMenu("| Mesas |");

        JMenuItem opcionItem1 = new JMenuItem("Crear Pedido");
        JMenuItem opcionItem2 = new JMenuItem("Lista Pedidos");
                 opcionMenu1.add(opcionItem1);
                 opcionMenu1.add(opcionItem2);
        menu.add(opcionMenu1);
        menu.add(opcionMenu2);
        menu.add(opcionMenu3);

        restaurante.ventana.add(BorderLayout.NORTH , menu);

        /*-------------------------------------*/

        restaurante.cargarMenu();

        /*-------------------------------------*/

        restaurante.ventana.add(BorderLayout.CENTER, restaurante.contenedor);

        plantillaRestauranteGUI  definirMesas = new plantillaRestauranteGUI(restaurante);
        restaurante.contenedor.add(BorderLayout.CENTER, definirMesas.getContenedor());


        restaurante.ventana.setVisible(true);

        opcionItem1.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(restaurante.cantMesasDefinidas) restaurante.resetItem1(restaurante);
                else restaurante.alertaDefinirCantMesas();
            }
        } );

        opcionItem2.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(restaurante.cantMesasDefinidas) restaurante.resetItem2(restaurante, null);
                else restaurante.alertaDefinirCantMesas();
            }
        } );

        opcionMenu2.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(restaurante.cantMesasDefinidas) restaurante.resetMenu2(restaurante);
                else restaurante.alertaDefinirCantMesas();
            }
        } );

        opcionMenu3.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                restaurante.resetMenu3(restaurante);
            }
        } );
    }

    public void resetItem1(GuiRestaurante restaurante){
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(new agregarPedidoGUI(restaurante).getContenedor());
        contenedor.setVisible(true);
    }

    public void resetItem2(GuiRestaurante restaurante, String mesa){
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(new listaPedidosActivos(restaurante, mesa).getContenedor());
        contenedor.setVisible(true);
    }

    public void resetMenu2(GuiRestaurante restaurante){
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(new agregarBorrarPlatoGUI(restaurante).getContenedor());
        contenedor.setVisible(true);
    }

    public void resetMenu3(GuiRestaurante restaurante){
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(new plantillaRestauranteGUI(restaurante).getContenedor());
        contenedor.setVisible(true);
    }

    //geters y seters

    public HashMap<String, Integer> getMenu() {
        return menu;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public int getCantMesas() {
        return cantMesas;
    }

    public boolean getCantMesasDefinidas(){
        return cantMesasDefinidas;
    }

    public void setCantMesasDefinidas(boolean cantMesasDefinidas) {
        this.cantMesasDefinidas = cantMesasDefinidas;
    }

    public void setCantMesas(int cantMesas) {
        this.cantMesas = cantMesas;
    }

    //metodos

    public void alertaDefinirCantMesas(){
        JOptionPane.showMessageDialog(contenedor,"Antes debe definir la cantidad de mesas","Alert",JOptionPane.WARNING_MESSAGE);
    }

    //Base de adtos

    public void cargarMenu(){
        try {
            Statement st = BasePlato.getConexion().createStatement();
            ResultSet resultado = st.executeQuery("SELECT nombrePlato FROM " + BasePlato.getNombreTabla());
            while (resultado.next()) {
                String nombre = resultado.getString("nombrePlato");
                menu.put(nombre, 0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void actualizarMenu(HashMap<String, Integer> pedido, String plato, String accion){
        if(plato != null){
            String notificacion = "";
            String consulta = "";
            if (accion.equals("add")){
                if(menu.containsKey(plato)){
                    JOptionPane.showMessageDialog(ventana,"El plato ya existe","Alert",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    consulta = "INSERT INTO " + BasePlato.getNombreTabla() + "(idPlato, nombrePlato) VALUES (null,'" + plato + "');";
                    notificacion = "El plato '" + plato + "' se ha añadido exitosamente";
                    menu.put(plato, 0);
                }
            }
            else{
                consulta = "DELETE FROM " + BasePlato.getNombreTabla() + " WHERE nombrePlato = '" + plato + "';";
                notificacion = "El plato '" + plato + "' se ha eliminado exitosamente";
                menu.remove(plato);
            }
            System.out.println(consulta);

            try {
                PreparedStatement sentenciaSQL = BasePlato.getConexion().prepareStatement(consulta);
                int resultado = sentenciaSQL.executeUpdate();
                if (resultado > 0) {
                    JOptionPane.showMessageDialog(contenedor, notificacion);
                } else {
                    JOptionPane.showMessageDialog(contenedor, "Hubo un error con la conexion");
                    sentenciaSQL.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            for (HashMap.Entry<String, Integer> entryPedido : pedido.entrySet()) {
                for (HashMap.Entry<String, Integer> entryMenu : menu.entrySet()) {
                    if(entryMenu.getKey().equals(entryPedido.getKey())){
                        entryMenu.setValue(entryMenu.getValue()+entryPedido.getValue());
                    }
                }
            }
        }
    }


}


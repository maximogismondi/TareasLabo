import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class listaPedidosActivos {
    JPanel contenedor = new JPanel(new BorderLayout());

    public listaPedidosActivos(GuiRestaurante restaurante, String mesa){
        contenedor.setSize(300,300);
        contenedor.setVisible(true);
        contenedor.setBackground(Color.LIGHT_GRAY);
        contenedor.setLayout(new BorderLayout());
        contenedor.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.LIGHT_GRAY));

        JTabbedPane tp = new JTabbedPane();
        contenedor.add(BorderLayout.CENTER, tp);

        boolean siguientePedido = true;
        for (Pedido pedido_aux : restaurante.getListaPedidos()){
            if(!pedido_aux.getEstado().equals("Finalizado")){
                JPanel panelPedido = new JPanel(new BorderLayout());
                JLabel listaPlatos = new JLabel("   Lista de Platos:");
                       listaPlatos.setFont(new Font("Arial", Font.BOLD, 15));

                if(siguientePedido && !pedido_aux.getEstado().equals("Servido") && !pedido_aux.getEstado().equals("Finalizado")){
                        listaPlatos.setBackground(Color.RED);
                        listaPlatos.setForeground(Color.WHITE);
                        listaPlatos.setOpaque(true);
                        siguientePedido = false;
                }

                JPanel platos      = new JPanel(new GridLayout(20,1));
                       platos.setBackground(Color.white);

                int indice = restaurante.getListaPedidos().indexOf(pedido_aux);

                JPanel panel       = new JPanel(new GridLayout(1,3));
                JButton actualizar = new JButton("Actualizar Estado");
                        actualizar.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.DARK_GRAY));

                panelPedido.add(BorderLayout.NORTH, listaPlatos);
                for (HashMap.Entry<String, Integer> entry : pedido_aux.getPlatos().entrySet()) {
                    platos.add(new JLabel("     » " + entry.getKey() + "  x" + Integer.toString(entry.getValue())));
                }
                panelPedido.add(BorderLayout.CENTER, platos);

                JComboBox<String> estadoBox = new JComboBox<String>();
                estadoBox.addItem("En espera");
                estadoBox.addItem("Preparandose");
                estadoBox.addItem("Enplatado");
                estadoBox.addItem("Servido");
                estadoBox.addItem("Finalizado");
                estadoBox.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
                switch (pedido_aux.getEstado()){
                    case "En espera":
                        estadoBox.setSelectedIndex(0);
                        break;
                    case "Preparandose":
                        estadoBox.setSelectedIndex(1);
                        break;
                    case "Enplatado":
                        estadoBox.setSelectedIndex(2);
                        break;
                    case "Servido":
                        estadoBox.setSelectedIndex(3);
                        break;
                }
                panel.add(listaPlatos);
                panel.add(estadoBox);
                panel.add(actualizar);

                panelPedido.add(BorderLayout.NORTH, panel);
                panelPedido.setName(pedido_aux.getNumeroDeMesa());


                if(mesa != null && mesa.equals(pedido_aux.getNumeroDeMesa())){
                    tp.add(panelPedido, 0);
                    tp.setSelectedIndex(0);
                }
                else tp.add(pedido_aux.getNumeroDeMesa(), panelPedido);

                actualizar.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mousePressed(MouseEvent e) {
                        restaurante.getListaPedidos().get(indice).setEstado(estadoBox.getItemAt(estadoBox.getSelectedIndex()));

                        if(estadoBox.getItemAt(estadoBox.getSelectedIndex()).equals("Servido")){
                            Pedido pedido_aux = restaurante.getListaPedidos().get(indice);
                            restaurante.getListaPedidos().remove(pedido_aux);
                            restaurante.getListaPedidos().add(pedido_aux);
                        }
                        else if(estadoBox.getItemAt(estadoBox.getSelectedIndex()).equals("Finalizado")){
                            restaurante.actualizarListaPedido(pedido_aux);
                        }

                        JOptionPane.showMessageDialog(contenedor,"El pedido se a actualizado a: "+ estadoBox.getItemAt(estadoBox.getSelectedIndex()));
                        restaurante.resetItem2(restaurante, null);
                    }
                } );

            }
        }
    }

    public JPanel getContenedor() {
        return contenedor;
    }
}

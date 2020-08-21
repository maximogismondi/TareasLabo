import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class agregarPedidoGUI{
    JPanel contenedor = new JPanel(new BorderLayout());
    HashMap<String,Integer> dataPedido = new HashMap<>();

    public agregarPedidoGUI(GuiRestaurante restaurante){
        contenedor.setSize(300,300);
        contenedor.setVisible(true);
        contenedor.setBackground(Color.LIGHT_GRAY);
        contenedor.setLayout(new BorderLayout());
        contenedor.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.LIGHT_GRAY));

        JPanel panel1 = new JPanel(new GridLayout(1,2)); //divisor de contenedor
        JPanel panel2 = new JPanel(new GridLayout(15,1));//formulario
        JPanel panel3 = new JPanel(new GridLayout(1,2)); //divisor mesas
        JPanel panel4 = new JPanel(new GridLayout(1,2)); //divisor platos comboBox y botones
        JPanel panel5 = new JPanel(new GridLayout(1,4)); //divisor platos de botones
        JPanel panel6 = new JPanel(new GridLayout(1,2)); //divisor addPedido y label
        JPanel panel7 = new JPanel(new GridLayout(1,3));


        JPanel pedido = new JPanel(new GridLayout(20,1));
               pedido.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));

        panel2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY));

        JLabel label1 = new JLabel("■  Nro Mesa:");
               label1.setFont(new Font("Arial", Font.BOLD, 13));
        JLabel label2 = new JLabel("■  Nombre Plato:");
               label2.setFont(new Font("Arial", Font.BOLD, 13));
        JLabel label3 = new JLabel("   Pedido:");
               label3.setFont(new Font("Arial", Font.BOLD, 13));

        int cantPedidosEnEspera = cantPedidosActivos(restaurante);
        JLabel label4 = new JLabel(" Pedidos en espera:  " + cantPedidosEnEspera);
               label4.setFont(new Font("Arial", Font.BOLD, 13));
               label4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
               label4.setOpaque(true);
        if      (cantPedidosEnEspera < 5)  label4.setBackground(Color.WHITE);
        else if (cantPedidosEnEspera < 8)  label4.setBackground(Color.YELLOW);
        else                               label4.setBackground(Color.RED);


        JComboBox<String> mesas = new JComboBox<String>();
                          mesas.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, Color.DARK_GRAY));
        addMesasDisponibles(restaurante, mesas);
        mesas.setSelectedIndex(0);

        JComboBox<String> platos = new JComboBox<String>();
                          platos.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        addItemsPlatos(platos, restaurante);

        ImageIcon addPlatoIMG = new ImageIcon("C:/Users/maxim/Desktop/Cole casa/Labo/TareasLabo/Labo/GUIRestaurante/src/addBoton.png");
        JButton addPlato  = new JButton();
                addPlato.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
                addPlato.setIcon(addPlatoIMG);

        ImageIcon subPlatoIMG = new ImageIcon("C:/Users/maxim/Desktop/Cole casa/Labo/TareasLabo/Labo/GUIRestaurante/src/subBoton.png");
        JButton subPlato  = new JButton();
                subPlato.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
                subPlato.setIcon(subPlatoIMG);

        ImageIcon addPedidoIMG = new ImageIcon("C:/Users/maxim/Desktop/Cole casa/Labo/TareasLabo/Labo/GUIRestaurante/src/addPedido.png");
        JButton addPedido = new JButton();
                addPedido.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
                addPedido.setIcon(addPedidoIMG);

                panel2.setBackground(Color.LIGHT_GRAY);
                panel2.add(new JLabel());
                panel2.add(label1);
                    panel3.setBackground(Color.LIGHT_GRAY);
                    panel3.add(mesas);
                    panel3.add(new JLabel());
                panel2.add(panel3);
                panel2.add(label2);
                        panel5.setBackground(Color.LIGHT_GRAY);
                        panel5.add(new JLabel());
                        panel5.add(addPlato);
                        panel5.add(subPlato);
                        panel5.add(new JLabel());
                    panel4.add(platos);
                    panel4.add(panel5);
                panel2.add(panel4);
                panel2.add(new JLabel());
                panel2.add(new JLabel());
                panel2.add(new JLabel());
                panel2.add(new JLabel());
                panel2.add(new JLabel());
                panel2.add(new JLabel());
                panel2.add(new JLabel());
                panel2.add(new JLabel());
                panel2.add(new JLabel());
                    panel6.setBackground(Color.LIGHT_GRAY);
                        panel7.setBackground(Color.LIGHT_GRAY);
                        panel7.add(addPedido);
                        panel7.add(new JLabel());
                        panel7.add(new JLabel());
                    panel6.add(panel7);
                    panel6.add(label4);
                panel2.add(panel6);
        panel1.add(panel2);
            pedido.setBackground(Color.white);
        pedido.add(label3);
        panel1.add(pedido);

        contenedor.add(BorderLayout.CENTER, panel1);


        addPlato.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                pedido.removeAll();
                pedido.add(label3);
                if(!dataPedido.containsKey(platos.getItemAt(platos.getSelectedIndex()))){
                    dataPedido.put(platos.getItemAt(platos.getSelectedIndex()), 1);
                }
                else{
                    dataPedido.put(platos.getItemAt(platos.getSelectedIndex()), dataPedido.get(platos.getItemAt(platos.getSelectedIndex()))+1);
                }
                mostrarPedido(pedido);
            }
        } );

        subPlato.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                pedido.removeAll();
                pedido.add(label3);
                if (dataPedido.containsKey(platos.getItemAt(platos.getSelectedIndex()))) {
                    dataPedido.put(platos.getItemAt(platos.getSelectedIndex()), dataPedido.get(platos.getItemAt(platos.getSelectedIndex())) - 1);
                    if (dataPedido.get(platos.getItemAt(platos.getSelectedIndex())) == 0) {
                        dataPedido.remove(platos.getItemAt(platos.getSelectedIndex()));
                    }
                    mostrarPedido(pedido);
                }
            }
        } );

        addPedido.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(dataPedido.size() != 0){
                    restaurante.actualizarMenu(dataPedido, null, null);
                    Pedido nuevoPedido = new Pedido(mesas.getItemAt(mesas.getSelectedIndex()), dataPedido);
                    restaurante.getListaPedidos().add(nuevoPedido);
                    JOptionPane.showMessageDialog(contenedor,"El pedido se a registrado exitosamente");
                    restaurante.resetItem1(restaurante);
                }
                else{
                    JOptionPane.showMessageDialog(contenedor,"El pedido esta vacio","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        } );

    }

    //geters y seters

    public JPanel getContenedor() {
        return contenedor;
    }

    //metodos

    public void mostrarPedido(JPanel pedido){
        for (HashMap.Entry<String, Integer> entry : dataPedido.entrySet()) {
            JLabel platoAux = new JLabel("     » " + entry.getKey() + "  x" + Integer.toString(entry.getValue()));
            pedido.add(platoAux);
        }
        pedido.setVisible(false);
        pedido.setVisible(true);
    }

    public void addItemsPlatos(JComboBox platosBox, GuiRestaurante restaurante){
        platosBox.removeAllItems();
        for (HashMap.Entry<String, Integer> entry : restaurante.getMenu().entrySet()) {
            platosBox.addItem(entry.getKey());
        }
        platosBox.setSelectedIndex(0);

    }

    public int cantPedidosActivos(GuiRestaurante restaurante){
        int cont = 0;
        for(Pedido pedido_aux : restaurante.getListaPedidos()){
            if (!pedido_aux.getEstado().equals("Finalizado") && !pedido_aux.getEstado().equals("Servido")) cont++;
        }
        return cont;
    }

    public void addMesasDisponibles(GuiRestaurante restaurante, JComboBox<String> mesas){
        for (int i = 1; i <= restaurante.getCantMesas(); i++) {
            String  mesa  = "mesa" + i;
            boolean libre = true;
            for(Pedido pedido_aux : restaurante.getListaPedidos()){
                if(pedido_aux.getNumeroDeMesa().equals(mesa) && !pedido_aux.getEstado().equals("Finalizado")) libre = false;
            }
            if(libre) mesas.addItem(mesa);
        }
    }

}

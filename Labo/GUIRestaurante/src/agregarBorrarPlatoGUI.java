import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class agregarBorrarPlatoGUI{
    JPanel contenedor = new JPanel(new BorderLayout());

    public agregarBorrarPlatoGUI(GuiRestaurante restaurante){
        contenedor.setSize(300,300);
        contenedor.setVisible(true);
        contenedor.setBackground(Color.LIGHT_GRAY);
        contenedor.setLayout(new BorderLayout());
        contenedor.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.LIGHT_GRAY));

        JPanel panel1 = new JPanel(new GridLayout(2,1)); //divisor de contenedor
        JPanel panel2 = new JPanel(new GridLayout(1,2)); //divisor inferior
        JPanel panel3 = new JPanel(new GridLayout(8,1)); //formulario
        JPanel panel4 = new JPanel(new GridLayout(1,2)); //divisor platos textFiel y botones
        JPanel panel5 = new JPanel(new GridLayout(1,2)); //divisor platos comboBox y botones
        JPanel panel6 = new JPanel(new GridLayout(1,3)); //addPlato
        JPanel panel7 = new JPanel(new GridLayout(1,4)); //subPlato



        JPanel platos = new JPanel(new GridLayout(10,4));
               platos.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));

        JLabel label1 = new JLabel("■  Plato a añadir:");
               label1.setFont(new Font("Arial", Font.BOLD, 13));
        JLabel label2 = new JLabel("■  Plato a eliminar:");
               label2.setFont(new Font("Arial", Font.BOLD, 13));

        mostrarMenu(platos, restaurante);


        JTextField platoText = new JTextField();
                   platoText.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));

        JComboBox<String> platosBox = new JComboBox<String>();
                          platosBox.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        addItemsPlatos(platosBox, restaurante);

        ImageIcon addPlatoIMG = new ImageIcon("C:/Users/Franco/Desktop/COLEGIO/Laboratorio/Ejercicios de Java/src/com/company/RestauranteGUI/addBoton.png");
        JButton addPlato  = new JButton();
                addPlato.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        addPlato.setIcon(addPlatoIMG);

        ImageIcon subPlatoIMG = new ImageIcon("C:/Users/Franco/Desktop/COLEGIO/Laboratorio/Ejercicios de Java/src/com/company/RestauranteGUI/subBoton.png");
        JButton subPlato  = new JButton();
                subPlato.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        subPlato.setIcon(subPlatoIMG);

            platos.setBackground(Color.white);
        panel1.add(platos);
            panel2.setBackground(Color.LIGHT_GRAY);
                panel3.setBackground(Color.LIGHT_GRAY);
                panel3.add(label1);
                    panel4.add(platoText);
                        panel6.setBackground(Color.LIGHT_GRAY);
                        panel6.add(new JLabel());
                        panel6.add(addPlato);
                        panel6.add(new JLabel());
                    panel4.add(panel6);
                panel3.add(panel4);
                panel3.add(label2);
                    panel5.add(platosBox);
                        panel7.setBackground(Color.LIGHT_GRAY);
                        panel7.add(new JLabel());
                        panel7.add(subPlato);
                        panel7.add(new JLabel());
                    panel5.add(panel7);
                panel3.add(panel5);
                panel3.add(new JLabel());
                platosMenos_MasPedidos(panel3, restaurante);
            panel2.add(panel3);
            panel2.add(new JLabel());
        panel1.add(panel2);

        contenedor.add(BorderLayout.CENTER, panel1);

        addPlato.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(platoText.getText().length() != 0 && estaVacio(platoText.getText())){
                    restaurante.actualizarMenu(null, platoText.getText(), "add");
                    addItemsPlatos(platosBox, restaurante);
                    restaurante.resetMenu2(restaurante);
                }
                platoText.setText("");
            }
        } );

        subPlato.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(chequearPlato(platosBox.getItemAt(platosBox.getSelectedIndex()), restaurante)){
                    restaurante.actualizarMenu(null, platosBox.getItemAt(platosBox.getSelectedIndex()), "sub");
                    addItemsPlatos(platosBox, restaurante);
                    restaurante.resetMenu2(restaurante);
                }
                else{
                    JOptionPane.showMessageDialog(contenedor,"El plato esta en un pedido Activo","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        } );

    }

    //geters y seters

    public JPanel getContenedor() {
        return contenedor;
    }

    //metodos

    public boolean chequearPlato(String plato, GuiRestaurante restaurante){
        for (Pedido pedidoAux : restaurante.getListaPedidos()){
            if (!pedidoAux.getEstado().equals("Finalizado")){
                for (HashMap.Entry<String, Integer> entry : pedidoAux.getPlatos().entrySet()) {
                    if(entry.getKey().equals(plato)) return false;
                }
            }
        }
        return true;
    }

    public void mostrarMenu(JPanel platos, GuiRestaurante restaurante){
        platos.removeAll();
        JLabel labelAux = new JLabel("  Menu:");
               labelAux.setFont(new Font("Arial", Font.BOLD, 13));
        platos.add(BorderLayout.NORTH, labelAux);
        for (HashMap.Entry<String, Integer> entry : restaurante.getMenu().entrySet()) {
            JLabel platoAux = new JLabel("     » " + entry.getKey());
            platos.add(platoAux);
        }
        platos.setVisible(false);
        platos.setVisible(true);
    }

    public void addItemsPlatos(JComboBox platosBox, GuiRestaurante restaurante){
        platosBox.removeAllItems();
        platosBox.addItem("                     ___");
        for (HashMap.Entry<String, Integer> entry : restaurante.getMenu().entrySet()) {
            platosBox.addItem(entry.getKey());
        }
        platosBox.setSelectedIndex(0);

    }

    public void platosMenos_MasPedidos(JPanel panel3, GuiRestaurante restaurante){
        Integer menorPlato = 100, mayorPlato = 0;
        String  menorPlatoNombre = "___", mayorPlatoNombre = "___";
        for (HashMap.Entry<String, Integer> entry : restaurante.getMenu().entrySet()) {
            if(entry.getValue() > mayorPlato){
                mayorPlato = entry.getValue();
                mayorPlatoNombre = entry.getKey();
            }
            else if(entry.getValue() < menorPlato){
                menorPlato = entry.getValue();
                menorPlatoNombre = entry.getKey();
            }
        }
        JLabel label1 = new JLabel("    Plato mas pedido:       x" + mayorPlato + " " + mayorPlatoNombre);
               label1.setFont(new Font("Arial", Font.BOLD, 12));
               label1.setBackground(Color.WHITE);
               label1.setOpaque(true);
        JLabel label2 = new JLabel("    Plato menos pedido:  x" + menorPlato + " " + menorPlatoNombre);
               label2.setFont(new Font("Arial", Font.BOLD, 12));
               label2.setBackground(Color.WHITE);
               label2.setOpaque(true);
        panel3.add(label1);
        panel3.add(label2);
    }

    public boolean estaVacio(String plato){
        int j = 0;
        for (int i = 0; i < plato.length() && plato.charAt(i)==' ' ; i++) j=i;
        if (j == plato.length()-1) return false;
        return  true;
    }

}

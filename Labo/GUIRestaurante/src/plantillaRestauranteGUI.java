import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class plantillaRestauranteGUI{

    JPanel contenedor = new JPanel(new BorderLayout());

    public plantillaRestauranteGUI(GuiRestaurante restaurante) {
        contenedor.setSize(300, 300);
        contenedor.setVisible(true);
        contenedor.setBackground(Color.LIGHT_GRAY);
        contenedor.setLayout(new BorderLayout());

        JPanel panel1   = new JPanel(); //grilla
               panel1.setBackground(Color.LIGHT_GRAY);

        addMesas(restaurante, panel1, null);

        contenedor.add(panel1);

        JPanel panel2 = new JPanel (new GridLayout(1,3));
        JPanel panel3 = new JPanel (new GridLayout(1,3));

        JRadioButton radioButton = new JRadioButton("Activar mesas menos y mas usadas");

        SpinnerModel numMesas =
                new SpinnerNumberModel(restaurante.getCantMesas(), //initial value
                        4,  //min
                        24, //max
                          1);
        JSpinner spinner = new JSpinner(numMesas);
        JButton  boton   = new JButton("Aceptar");

        panel2.add(radioButton);
        if(!restaurante.getCantMesasDefinidas()){
                       panel3.add(new JLabel("          Cant. Mesas:"));
                       panel3.add(spinner);
                       panel3.add(boton);
            panel2.add(panel3);
        }


        contenedor.add(BorderLayout.SOUTH, panel2);

        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                restaurante.setCantMesas((int)spinner.getValue());
                addMesas(restaurante, panel1, null);
                System.out.println(restaurante.getCantMesas());
            }
        });

        radioButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(!radioButton.isSelected()) addMesas(restaurante, panel1, mesasMenos_MasOcupadas(restaurante));
                else addMesas(restaurante, panel1, null);
            }
        } );

        boton.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                restaurante.setCantMesasDefinidas(true);
                JOptionPane.showMessageDialog(contenedor,"Cantidad de mesas Definidas");
                restaurante.resetItem1(restaurante);
            }
        } );
    }

    //geters y seters

    public JPanel getContenedor() {
        return contenedor;
    }

    //metodos

    public void addMesas(GuiRestaurante restaurante, JPanel panel1, ArrayList<String> mesasDestacadas){
        panel1.removeAll();
        panel1.setLayout((new GridLayout(restaurante.getCantMesas()/3,restaurante.getCantMesas()/(restaurante.getCantMesas()/3))));
        for (int i = 1; i <= restaurante.getCantMesas(); i++) {

            JPanel panelMesa = new JPanel(new BorderLayout());
            panelMesa.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.LIGHT_GRAY));
            JButton mesaBoton = new JButton("mesa" + i);
            mesaBoton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
            mesaBoton.setName("mesa" + i);
            panelMesa.add(BorderLayout.CENTER, mesaBoton);

            if (mesasDestacadas != null) {
                if (mesasDestacadas.get(0).equals(mesaBoton.getName())) {
                    mesaBoton.setBackground(Color.YELLOW);
                    mesaBoton.setText(mesaBoton.getText() + " (Mayor)");
                } else if (mesasDestacadas.get(1).equals(mesaBoton.getName())) {
                    mesaBoton.setBackground(Color.PINK);
                    mesaBoton.setText(mesaBoton.getText() + " (Menor)");
                } else {
                    mesaBoton.setBackground(Color.DARK_GRAY);
                    mesaBoton.setText("");
                }
            } else {
                switch (estadoMesa("mesa" + i, restaurante)) {
                    case "Libre":
                        mesaBoton.setBackground(Color.green);
                        break;
                    case "SemiLibre":
                        mesaBoton.setBackground(Color.orange);
                        break;
                    case "Ocupada":
                        mesaBoton.setBackground(Color.red);
                        break;
                }
            }

            panel1.add(panelMesa);

            mesaBoton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (mesaBoton.getBackground().equals(Color.RED)) {
                        restaurante.resetItem2(restaurante, mesaBoton.getName());
                    }
                }
            });

        }
        panel1.setVisible(false);
        panel1.setVisible(true);
    }

    public ArrayList<String> mesasMenos_MasOcupadas(GuiRestaurante restaurante){
        HashMap<String, Integer> rankingMesas = new HashMap<>();
        ArrayList<String> listaMesas = new ArrayList<>();
                          listaMesas.add("");
                          listaMesas.add("");
        int mayorCant = -1, menorCant = 100;

        for (int i = 1; i <= restaurante.getCantMesas() ; i++) {
            rankingMesas.put("mesa"+i, 0);
        }
        for (Pedido pedido_aux : restaurante.getListaPedidos()) {
            rankingMesas.put(pedido_aux.getNumeroDeMesa(), rankingMesas.get(pedido_aux.getNumeroDeMesa())+1);
        }
        for (HashMap.Entry<String, Integer> entry : rankingMesas.entrySet()) {
            if (entry.getValue() > mayorCant){
                mayorCant = entry.getValue();
                listaMesas.set(0, entry.getKey());
            }
        }
        for (HashMap.Entry<String, Integer> entry : rankingMesas.entrySet()) {
            if (entry.getValue() < menorCant){
                menorCant = entry.getValue();
                listaMesas.set(1, entry.getKey());
            }
        }
        System.out.println(rankingMesas);
        return listaMesas;
    }


    public String estadoMesa(String mesa, GuiRestaurante restaurante){
        for(Pedido pedido_aux : restaurante.getListaPedidos()){
            if(pedido_aux.getNumeroDeMesa().equals(mesa) && !pedido_aux.getEstado().equals("Finalizado")){
                if(pedido_aux.getEstado().equals("Servido")) return "SemiLibre";
                else return "Ocupada";
            }
        }
        return "Libre";
    }
}
    
    



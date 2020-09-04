package com.company.RestauranteGUI;

import com.company.AccesoBaseDeDatos;

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

public class Login {

    public static void main(String[] args) {
        JFrame frame;
        JPanel paneliz,panelde,panelab,panelar,panelex;
        JLabel nombre,contra;
        JTextField user,password;
        JButton boton1;
        AccesoBaseDeDatos BaseAdmin = new AccesoBaseDeDatos("laboratorio", "administrador");

        frame    = new JFrame();
        paneliz  = new JPanel();
        panelde  = new JPanel();
        panelab  = new JPanel();
        panelar  = new JPanel();
        panelex  = new JPanel();
        nombre   = new JLabel();
        contra   = new JLabel();
        user     = new JTextField();
        password = new JPasswordField();
        boton1   = new JButton();
        BaseAdmin.conectar("root","");

        frame.setTitle("Log In ");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(550,200,300,180);

        nombre.setText("Nombre:");
        contra.setText("Contraseña:");

        boton1.setText("Log In");
        boton1.setBackground(Color.green);

        paneliz.setLayout(new GridLayout(4,0));
        paneliz.add(nombre);
        paneliz.add(contra);

        panelde.setLayout(new GridLayout(4,0));
        panelde.add(user);
        panelde.add(password);

        panelar.setLayout(new GridLayout(1,1));
        panelar.setPreferredSize(new Dimension(250,100));
        panelar.add(paneliz);
        panelar.add(panelde);

        panelab.setLayout(new FlowLayout());
        panelab.setPreferredSize(new Dimension(200,50));
        panelab.add(boton1);

        panelex.setLayout(new GridLayout(2,0));
        panelex.add(panelar);
        panelex.add(panelab);

        frame.add(panelex);

        boton1.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                try {
                    String userDB = "", passwordDB = "";
                    Statement st = BaseAdmin.getConexion().createStatement();
                    ResultSet resultado = st.executeQuery("SELECT User, Password FROM " + BaseAdmin.getNombreTabla());
                    resultado.next();
                    userDB = resultado.getString("User");
                    passwordDB = resultado.getString("Password");
                    System.out.println(userDB);
                    System.out.println(passwordDB);
                    if (userDB.equals(user.getText()) && passwordDB.equals(password.getText())){
                        JOptionPane.showMessageDialog(frame,"Acceso permitido","Alert",JOptionPane.WARNING_MESSAGE);
                        frame.dispose();
                        GuiRestaurante.main(args);
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,"Acceso denegado","Alert",JOptionPane.WARNING_MESSAGE);
                        user.setText("");
                        password.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } );

    }

}
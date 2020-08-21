package com.company;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
	    ventana.setLayout(null);
	    ventana.setSize(500,500);
	    ventana.setVisible(true);

	    JLabel palabra = new JLabel("Capoeria");
	    palabra.setSize(450,50);
	    palabra.setLocation(15,150);

    	JButton boton = new JButton("Tripicar");
    	boton.setSize(450,50);
    	boton.setLocation(15,315);

    	boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String palabra_aux = palabra.getText();
                palabra_aux = palabra_aux + palabra_aux + palabra_aux;
                palabra.setText(palabra_aux);
            }
        });

    	ventana.add(palabra);
        ventana.add(boton);
    }
}

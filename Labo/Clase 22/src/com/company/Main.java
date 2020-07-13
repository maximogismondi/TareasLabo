package com.company;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Persona> personas = new ArrayList<>();

        JFrame ventana = new JFrame();
        ventana.setLayout(null);
        ventana.setSize(500,475);
        ventana.setVisible(true);

        JLabel texto_nombre = new JLabel("Nombre");
        texto_nombre.setSize(100,50);
        texto_nombre.setLocation(25,25);

        JTextField campo_nombre = new JTextField();
        campo_nombre.setSize(300,50);
        campo_nombre.setLocation(150,25);

        JLabel texto_apellido = new JLabel("Apellido");
        texto_apellido.setSize(100,50);
        texto_apellido.setLocation(25,100);

        JTextField campo_apellido = new JTextField();
        campo_apellido.setSize(300,50);
        campo_apellido.setLocation(150,100);

        JLabel texto_edad = new JLabel("Edad");
        texto_edad.setSize(100,50);
        texto_edad.setLocation(25,175);

        JTextField campo_edad = new JTextField();
        campo_edad.setSize(300,50);
        campo_edad.setLocation(150,175);

        JLabel texto_ocupacion = new JLabel("Ocupacion");
        texto_ocupacion.setSize(100,50);
        texto_ocupacion.setLocation(25,250);

        JTextField campo_ocupacion = new JTextField();
        campo_ocupacion.setSize(300,50);
        campo_ocupacion.setLocation(150,250);

        JButton guardar = new JButton("Guardar");
        guardar.setSize(100,50);
        guardar.setLocation(200,325);

        JLabel mensaje = new JLabel("Esperando el ingreso de Persona");
        mensaje.setSize(400,50);
        mensaje.setLocation(25,375);


        guardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!campo_nombre.getText().equals("") && !campo_apellido.getText().equals("") && !campo_edad.getText().equals("") && !campo_ocupacion.getText().equals("")){
                    String nombre = campo_nombre.getText();
                    String apellido = campo_apellido.getText();
                    String edad = campo_edad.getText();
                    String ocupacion = campo_ocupacion.getText();
                    personas.add(new Persona(nombre, apellido, edad, ocupacion));
                    mensaje.setText("Se ha agregado correctamente");
                }
                else{
                    mensaje.setText("No se ha podido agregar, hay campos vacios");
                }
                if (personas.size()>0){
                    System.out.println(personas.get(personas.size()-1).getNombre() + ' ' + personas.get(personas.size()-1).getApellido() + ' ' + personas.get(personas.size()-1).getEdad() + ' ' + personas.get(personas.size()-1).getOcupacion());
                }
            }
        });

        ventana.add(texto_nombre);
        ventana.add(campo_nombre);
        ventana.add(texto_apellido);
        ventana.add(campo_apellido);
        ventana.add(texto_edad);
        ventana.add(campo_edad);
        ventana.add(texto_ocupacion);
        ventana.add(campo_ocupacion);
        ventana.add(guardar);
        ventana.add(mensaje);
    }
}

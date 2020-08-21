import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class HotelGUI {
    public static void main(String[] args){
        JFrame ventana=new JFrame();
        ventana.setLayout(null);
        ventana.setSize(500,500);

        JMenuBar barraMenu = new JMenuBar();
        ventana.setJMenuBar(barraMenu);

        JMenu Hotel = new JMenu("Hotel");
        barraMenu.add(Hotel);
        JMenu Huesped = new JMenu("Huesped");
        barraMenu.add(Huesped);
        JMenu Habitacion = new JMenu("Habitacion");
        barraMenu.add(Habitacion);
        JMenu Hospedaje = new JMenu("Hospedaje");
        barraMenu.add(Hospedaje);
        JMenu darDeAlta = new JMenu("Registrar");
        barraMenu.add(darDeAlta);

        JMenuItem op1= new JMenu("6 mas frecuentes");
        Huesped.add(op1);

        JMenuItem op2= new JMenu("Mas solicitada");
        Habitacion.add(op2);

        JMenuItem op3= new JMenu("Ingreso total");
        Hotel.add(op3);

        JMenuItem op4 = new JMenu("Estadias prolongadas");
        Hospedaje.add(op4);

        JMenuItem op5 = new JMenu("Disponibles");
        Habitacion.add(op5);

        JMenuItem op6 = new JMenu("Ocupadas");
        Habitacion.add(op6);

        JMenuItem op7 = new JMenu("Huespedes dentro");
        Habitacion.add(op7);

        JMenuItem op8 = new JMenu("Tiempo estadia");
        Hospedaje.add(op8);

        JMenuItem op9 = new JMenu("Fecha entrada y salida");
        Hospedaje.add(op9);

        JMenuItem op10 = new JMenu("Agregar monto");
        Hospedaje.add(op10);

        JMenuItem op11 = new JMenu("Nuevo importe a pagar");
        Huesped.add(op11);

        JMenuItem op12 = new JMenu("Registrar huesped");
        darDeAlta.add(op12);
        JMenuItem op13 = new JMenu("Registrar estadia");
        darDeAlta.add(op13);

        //---------------------------------------------------------------------//

        AccesoBaseDeDatos baseDatosHotel = new AccesoBaseDeDatos("laboratorio","huesped");
        AccesoBaseDeDatos baseDatosHospedaje = new AccesoBaseDeDatos("laboratorio","hospedaje");
        AccesoBaseDeDatos baseDatosHabitacion = new AccesoBaseDeDatos("laboratorio","habitacion");
        baseDatosHotel.conectar("root","");
        baseDatosHospedaje.conectar("root","");
        baseDatosHabitacion.conectar("root","");

        //---------------------------------------------------------------------//

        Huesped huesped1 = new Huesped("Manuel", "Ruiz", 24, 12345678, 4);
        Huesped huesped2 = new Huesped("Berta", "Gonzales", 25, 12345679, 3);
        Huesped huesped3 = new Huesped("Leonel", "Rodriguez", 22, 12453678, 10);
        Huesped huesped4 = new Huesped("Miriam", "Perez", 21, 12326478, 3);
        Huesped huesped5 = new Huesped("Oscar", "Ferro", 24, 34573428, 7);
        Huesped huesped6 = new Huesped("Lisa", "Fernandez", 45, 47665678, 1);
        Huesped huesped7 = new Huesped("Teresa", "Marin", 18, 12354338, 2);
        Huesped huesped8 = new Huesped("Olga", "Rodriguez", 54, 18645444, 6);
        Huesped huesped9 = new Huesped("Juan", "Ferro", 34, 74543234, 5);

        Habitacion habitacion1 = new Habitacion(1, 545, 1, 8, false); //false ocupada
        Habitacion habitacion2 = new Habitacion(2, 545, 1, 5, true);//true libre
        Habitacion habitacion3 = new Habitacion(3, 545, 1, 2, true);
        Habitacion habitacion4 = new Habitacion(4, 545, 1, 11, false);
        Habitacion habitacion5 = new Habitacion(5, 545, 1, 4, true);
        Habitacion habitacion6 = new Habitacion(6, 545, 1, 2, true);
        Habitacion habitacion7 = new Habitacion(7, 545, 1, 5, false);
        Habitacion habitacion8 = new Habitacion(8, 545, 1, 6, true);
        Habitacion habitacion9 = new Habitacion(9, 785, 2, 2, true);
        Habitacion habitacion10 = new Habitacion(10, 785, 2, 3, true);
        Habitacion habitacion11 = new Habitacion(11, 785, 2, 5, true);
        Habitacion habitacion12 = new Habitacion(12, 785, 2, 7, false);
        Habitacion habitacion13 = new Habitacion(13, 785, 2, 10, false);

        Hospedaje hospedaje1 = new Hospedaje(huesped1, habitacion8, "12-12-2019", "19-12-2019", 3815, 7);
        Hospedaje hospedaje2 = new Hospedaje(huesped5, habitacion13, "01-01-2020", "04-01-2020", 3140, 4);
        Hospedaje hospedaje3 = new Hospedaje(huesped8, habitacion4, "01-01-2020", "01-02-2020", 16350, 31);
        Hospedaje hospedaje4 = new Hospedaje(huesped8, habitacion4, "25-01-2020", "28-01-2020", 1635, 3);
        Hospedaje hospedaje5 = new Hospedaje(huesped5, habitacion13, "28-01-2020", "30-01-2020", 1570, 2);
        Hospedaje hospedaje6 = new Hospedaje(huesped4, habitacion8, "05-02-2020", "10-02-2020", 2725, 5);
        Hospedaje hospedaje7 = new Hospedaje(huesped9, habitacion1, "01-02-2020", "03-03-2020", 17440, 32);
        Hospedaje hospedaje8 = new Hospedaje(huesped5, habitacion13, "15-03-2020", "18-03-2020", 2355, 3);
        Hospedaje hospedaje9 = new Hospedaje(huesped8, habitacion5, "20-03-2020", "27-03-2020", 3815, 7);
        Hospedaje hospedaje10 = new Hospedaje(huesped6, habitacion4, "01-04-2020", "07-04-2020", 3815, 7);
        Hospedaje hospedaje11 = new Hospedaje(huesped3, habitacion7, "30-03-2020", "05-04-2020", 3815, 7);
        Hospedaje hospedaje12 = new Hospedaje(huesped9, habitacion1, "01-04-2020", "04-04-2020", 2180, 4);
        Hospedaje hospedaje13 = new Hospedaje(huesped8, habitacion12, "28-3-2020", "05-04-2020", 7065, 9);
        Hospedaje hospedaje14 = new Hospedaje(huesped1, habitacion13, "01-04-2020", "07-04-2020", 5495, 7);

        ArrayList<Huesped> huespedes = new ArrayList<>();
        huespedes.add(huesped1);
        huespedes.add(huesped2);
        huespedes.add(huesped3);
        huespedes.add(huesped4);
        huespedes.add(huesped5);
        huespedes.add(huesped6);
        huespedes.add(huesped7);
        huespedes.add(huesped8);
        huespedes.add(huesped9);

        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(habitacion1);
        habitaciones.add(habitacion2);
        habitaciones.add(habitacion3);
        habitaciones.add(habitacion4);
        habitaciones.add(habitacion5);
        habitaciones.add(habitacion6);
        habitaciones.add(habitacion7);
        habitaciones.add(habitacion8);
        habitaciones.add(habitacion9);
        habitaciones.add(habitacion10);
        habitaciones.add(habitacion11);
        habitaciones.add(habitacion12);
        habitaciones.add(habitacion13);

        ArrayList<Hospedaje> listaHospedaje = new ArrayList<>();
        listaHospedaje.add(hospedaje1);
        listaHospedaje.add(hospedaje2);
        listaHospedaje.add(hospedaje3);
        listaHospedaje.add(hospedaje4);
        listaHospedaje.add(hospedaje5);
        listaHospedaje.add(hospedaje6);
        listaHospedaje.add(hospedaje7);
        listaHospedaje.add(hospedaje8);
        listaHospedaje.add(hospedaje9);
        listaHospedaje.add(hospedaje10);
        listaHospedaje.add(hospedaje11);
        listaHospedaje.add(hospedaje12);
        listaHospedaje.add(hospedaje13);
        listaHospedaje.add(hospedaje14);

        //---------------------------------------------------------------------//
        JPanel seisFrecuentes = new JPanel();
        JPanel dosFrecuentes = new JPanel();
        JPanel plataTotal = new JPanel();
        JPanel lasEstadiasProlongadas = new JPanel();
        JPanel habitacionesQueEstanOcupadas = new JPanel();
        JPanel habitacionesQueEstanDisponibles = new JPanel();
        JPanel huespedesEnDetHabitacion = new JPanel();
        JPanel cantDiasQueQueda = new JPanel();
        JPanel fechaSalida = new JPanel();
        JPanel agregarDias = new JPanel();
        JPanel agregarMonto = new JPanel();
        JPanel insertarHuesped = new JPanel();
        JPanel regisEstadia = new JPanel();
        //---------------------------------------------------------------------//
            op1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    seisFrecuentes.setVisible(false);
                    dosFrecuentes.setVisible(false);
                    plataTotal.setVisible(false);
                    lasEstadiasProlongadas.setVisible(false);
                    habitacionesQueEstanOcupadas.setVisible(false);
                    habitacionesQueEstanDisponibles.setVisible(false);
                    huespedesEnDetHabitacion.setVisible(false);
                    cantDiasQueQueda.setVisible(false);
                    fechaSalida.setVisible(false);
                    agregarDias.setVisible(false);
                    agregarMonto.setVisible(false);
                    insertarHuesped.setVisible(false);
                    regisEstadia.setVisible(false);
                    seisFrecuentes.removeAll();
                    ventana.remove(seisFrecuentes);
                    dosFrecuentes.removeAll();
                    ventana.remove(dosFrecuentes);
                    plataTotal.removeAll();
                    ventana.remove(plataTotal);
                    lasEstadiasProlongadas.removeAll();
                    ventana.remove(lasEstadiasProlongadas);
                    habitacionesQueEstanDisponibles.removeAll();
                    ventana.remove(habitacionesQueEstanDisponibles);
                    habitacionesQueEstanOcupadas.removeAll();
                    ventana.remove(habitacionesQueEstanOcupadas);
                    huespedesEnDetHabitacion.removeAll();
                    ventana.remove(huespedesEnDetHabitacion);
                    cantDiasQueQueda.removeAll();
                    ventana.remove(cantDiasQueQueda);
                    fechaSalida.removeAll();
                    ventana.remove(fechaSalida);
                    agregarDias.removeAll();
                    ventana.remove(agregarDias);
                    agregarMonto.removeAll();
                    ventana.remove(agregarMonto);
                    insertarHuesped.removeAll();
                    ventana.remove(insertarHuesped);
                    regisEstadia.removeAll();
                    ventana.remove(regisEstadia);

                    seisFrecuentes.removeAll();

                    seisFrecuentes.setSize(500, 50);
                    seisFrecuentes.setLayout(new GridLayout(2, 1));

                    JLabel titulo = new JLabel();
                    titulo.setText("Los 6 huespedes mas frecuentes son:");
                    seisFrecuentes.add(titulo);

                    JLabel resp = new JLabel();
                    ArrayList<Huesped> seis = new ArrayList<>();
                    seis = huesped1.seisFrecuentes(huespedes);
                    resp.setText(seis.get(0).getNombre() + " " + seis.get(0).getApellido() + ", " + seis.get(1).getNombre() + " " + seis.get(1).getApellido() + ", " + seis.get(2).getNombre() + " " + seis.get(2).getApellido() + ", " + seis.get(3).getNombre() + " " + seis.get(3).getApellido() + ", " + seis.get(4).getNombre() + " " + seis.get(4).getApellido() + ", " + seis.get(5).getNombre() + " " + seis.get(5).getApellido());

                    seisFrecuentes.add(resp);
                    ventana.add(seisFrecuentes);
                    seisFrecuentes.setVisible(true);
                }
            });


            //---------------------------------------------------------------------//

        op2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                dosFrecuentes.removeAll();

                dosFrecuentes.setSize(600, 50);
                dosFrecuentes.setLayout(new GridLayout(2, 1));

                JLabel titulo2 = new JLabel();
                titulo2.setText("Las dos habitaciones mas solicitadas son:");
                dosFrecuentes.add(titulo2);

                JLabel resp2 = new JLabel();
                ArrayList<Habitacion> dos = new ArrayList<>();
                dos = habitacion1.masSolicitadas(habitaciones);
                resp2.setText("Num:" + dos.get(0).getNumero() + " Capacidad para:" + dos.get(0).getCantPersona() + "persona Cant veces:" + dos.get(0).getCantVecesSolicitadada() + ", " + "Num:" + dos.get(1).getNumero() + " Capacidad para:" + dos.get(1).getCantPersona() + "personas Cant veces:" + dos.get(1).getCantVecesSolicitadada());

                dosFrecuentes.add(resp2);
                ventana.add(dosFrecuentes);
                dosFrecuentes.setVisible(true);
            }});

            //---------------------------------------------------------------------//

        op3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                plataTotal.removeAll();

                plataTotal.setSize(500, 50);
                plataTotal.setLayout(new GridLayout(1, 1));

                JLabel resp3 = new JLabel();
                int plataTot = hospedaje1.dineroTotal(listaHospedaje);
                resp3.setText("La cant de dinero total es $" + plataTot);

                plataTotal.add(resp3);
                ventana.add(plataTotal);
                plataTotal.setVisible(true);
            }});

            //-----------------------------------------------------------------------//

        op4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                lasEstadiasProlongadas.removeAll();

                lasEstadiasProlongadas.setSize(800, 50);
                lasEstadiasProlongadas.setLayout(new GridLayout(2, 1));

                JLabel titulo4 = new JLabel();
                titulo4.setText("Los huespedes con estadia prolongada son:");
                lasEstadiasProlongadas.add(titulo4);

                JLabel resp4 = new JLabel();
                ArrayList<Hospedaje> prolongados = new ArrayList<>();
                prolongados = hospedaje1.estadiasProlongadas(listaHospedaje);
                String concatInfo = "";
                if (prolongados.size() > 0) {
                    for (int i = 0; i < prolongados.size(); i++) {
                        concatInfo = concatInfo + prolongados.get(i).getHuesp().getNombre() + " " + prolongados.get(i).getHuesp().getApellido() + " cant de dias:" + prolongados.get(i).getCantDias() + ", ";
                    }
                } else {
                    concatInfo = "No existe registro de estadias prolongadas.";
                }
                resp4.setText(concatInfo);
                lasEstadiasProlongadas.add(resp4);

                ventana.add(lasEstadiasProlongadas);
                lasEstadiasProlongadas.setVisible(true);
            }});

            //-----------------------------------------------------------------------//

        op6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                habitacionesQueEstanOcupadas.removeAll();

                habitacionesQueEstanOcupadas.setSize(400, 50);
                habitacionesQueEstanOcupadas.setLayout(new GridLayout(2, 1));

                JLabel titulo5 = new JLabel();
                titulo5.setText("Habitaciones ocupadas:");
                habitacionesQueEstanOcupadas.add(titulo5);

                JLabel resp5 = new JLabel();
                ArrayList<Habitacion> habOcupadas = new ArrayList<>();
                habOcupadas = habitacion1.ocupadas(habitaciones);
                String hOcupadas = "";
                if (habOcupadas.size() > 0) {
                    for (int i = 0; i < habOcupadas.size(); i++) {
                        hOcupadas = hOcupadas + habOcupadas.get(i).getNumero() + ", ";
                    }
                } else {
                    hOcupadas = "Todas las habitaciones estan disponibles.";
                }
                resp5.setText(hOcupadas);
                habitacionesQueEstanOcupadas.add(resp5);

                ventana.add(habitacionesQueEstanOcupadas);
                habitacionesQueEstanOcupadas.setVisible(true);
            }});

            //---------------------------------------------------------------//

        op5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                habitacionesQueEstanDisponibles.removeAll();

                habitacionesQueEstanDisponibles.setSize(400, 50);
                habitacionesQueEstanDisponibles.setLayout(new GridLayout(2, 1));

                JLabel titulo6 = new JLabel();
                titulo6.setText("Habitaciones disponibles:");
                habitacionesQueEstanDisponibles.add(titulo6);

                JLabel resp6 = new JLabel();
                ArrayList<Habitacion> habDisponibles = new ArrayList<>();
                habDisponibles = habitacion1.disponible(habitaciones);
                String hDisponibles = "";
                if (habDisponibles.size() > 0) {
                    for (int i = 0; i < habDisponibles.size(); i++) {
                        hDisponibles = hDisponibles + habDisponibles.get(i).getNumero() + ", ";
                    }
                } else {
                    hDisponibles = "Todas las habitaciones estan ocupadas.";
                }
                resp6.setText(hDisponibles);
                habitacionesQueEstanDisponibles.add(resp6);

                ventana.add(habitacionesQueEstanDisponibles);
                habitacionesQueEstanDisponibles.setVisible(true);
            }});

            //------------------------------------------------------------//

        op7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                huespedesEnDetHabitacion.removeAll();

                huespedesEnDetHabitacion.setSize(500, 500);
                huespedesEnDetHabitacion.setLayout(new GridLayout(4, 1));

                JLabel pedidor7 = new JLabel();
                pedidor7.setText("Ingrese numero de habitacion que quiera revisar:");
                huespedesEnDetHabitacion.add(pedidor7);

                JTextField llenado = new JTextField();
                huespedesEnDetHabitacion.add(llenado);

                JLabel titulo7 = new JLabel();
                titulo7.setText("Estado de la habitacion:");

                JLabel resp7 = new JLabel();

                JButton submit7 = new JButton("Buscar");
                huespedesEnDetHabitacion.add(submit7);

                huespedesEnDetHabitacion.add(resp7);

                submit7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int numHab = Integer.parseInt(llenado.getText());
                        Huesped aux = new Huesped("", "", 0, 0, 0);
                        for (Habitacion habAux : habitaciones) {
                            if (habAux.getNumero() == numHab) {
                                aux = habAux.huespedesActuales(listaHospedaje);
                            }
                        }
                        if (aux.getApellido() == "" && aux.getNombre() == "") {
                            resp7.setText("Habitacion no existente");
                        } else if (aux.getNombre() == "No Hay Nadie" && aux.getApellido() == "Habitacion Vacia") {
                            resp7.setText("La habitacion esta vacia");
                        } else {
                            resp7.setText(aux.getNombre() + " " + aux.getApellido());
                        }
                    }
                });
                ventana.add(huespedesEnDetHabitacion);
                huespedesEnDetHabitacion.setVisible(true);
            }});

            //------------------------------------------------------------------------------------//

        op8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                cantDiasQueQueda.removeAll();

                cantDiasQueQueda.setSize(500, 500);
                cantDiasQueQueda.setLayout(new GridLayout(9, 1));

                JLabel pedidor8 = new JLabel();
                pedidor8.setText("Ingrese el dni:");
                cantDiasQueQueda.add(pedidor8);

                JTextField llenador8 = new JTextField();
                cantDiasQueQueda.add(llenador8);

                JButton submit8 = new JButton("Buscar");
                cantDiasQueQueda.add(submit8);

                JLabel pedidor8p2 = new JLabel();
                cantDiasQueQueda.add(pedidor8p2);

                JLabel resp8 = new JLabel();

                submit8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        boolean encontrado = true;
                        String fechasHospedaje = "";
                        int dniIngresada = Integer.parseInt(llenador8.getText());
                        for (int i = 0; i < huespedes.size(); i++) {
                            if (huespedes.get(i).getDni() == dniIngresada) {
                                encontrado = false;
                                for (Hospedaje hosAux : listaHospedaje) {
                                    if (hosAux.getHuesp().getDni() == dniIngresada) {
                                        fechasHospedaje = fechasHospedaje + hosAux.getFechaEntrada() + ", ";
                                    }
                                }
                                pedidor8p2.setText("Las fechas disponibles son:" + fechasHospedaje);
                                JLabel pedidor8p3 = new JLabel();
                                pedidor8p3.setText("Ingrese la fecha la cual desea corroborar (Ej. 31-12-2000)");
                                cantDiasQueQueda.add(pedidor8p3);
                                JTextField llenador8p2 = new JTextField();
                                cantDiasQueQueda.add(llenador8p2);
                                JButton submit8p2 = new JButton("Buscar");
                                cantDiasQueQueda.add(submit8p2);
                                submit8p2.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        cantDiasQueQueda.add(resp8);
                                        boolean encontrada2 = true;
                                        for (Hospedaje haux2 : listaHospedaje) {
                                            String fechaEntradaIng = llenador8p2.getText();
                                            if (haux2.getHuesp().getDni() == dniIngresada && haux2.getFechaEntrada().equals(fechaEntradaIng)) {
                                                encontrada2 = false;
                                                int diasTot = haux2.cantDiasQueSeQueda();
                                                resp8.setText("La cantidad de dias fue:" + diasTot);
                                            }
                                        }
                                        if (encontrada2) {
                                            resp8.setText("Revise la fecha ingresada");
                                        }
                                    }
                                });
                            }
                            if (encontrado) {
                                pedidor8p2.setText("No existe ese huesped");
                            }
                        }
                    }
                });
                ventana.add(cantDiasQueQueda);
                cantDiasQueQueda.setVisible(true);
            }});

            //-------------------------------------------------------------------------------------//

        op9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                fechaSalida.removeAll();

                fechaSalida.setSize(500, 200);
                fechaSalida.setLayout(new GridLayout(5, 1));

                JLabel titulo9 = new JLabel();
                titulo9.setText("Ingrese la fecha de entrada");
                fechaSalida.add(titulo9);

                JTextField llenador9 = new JTextField();
                fechaSalida.add(llenador9);

                JButton submit9 = new JButton("Buscar");
                fechaSalida.add(submit9);

                JLabel resp9 = new JLabel();
                fechaSalida.add(resp9);

                submit9.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        boolean encontrado3 = true;
                        String fechasSalidaHuesped = "";
                        for (Hospedaje hosAux2 : listaHospedaje) {
                            if (hosAux2.getFechaEntrada().equals(llenador9.getText())) {
                                encontrado3 = false;
                                fechasSalidaHuesped = fechasSalidaHuesped + "Huesped DNI " + hosAux2.getHuesp().getDni() + "-Fecha salida:" + hosAux2.getFechaSalida() + " ,";
                            }
                        }
                        if (encontrado3) {
                            fechasSalidaHuesped = "No se encontro la fecha";
                        }
                        resp9.setText(fechasSalidaHuesped);
                    }
                });

                ventana.add(fechaSalida);
                fechaSalida.setVisible(true);
            }});

            //-------------------------------------------------//

        op10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                agregarDias.removeAll();

                agregarDias.setSize(500, 500);
                agregarDias.setLayout(new GridLayout(7, 1));

                JLabel pedidor10 = new JLabel();
                pedidor10.setText("Ingresar un dni:");
                agregarDias.add(pedidor10);

                JTextField llenador10 = new JTextField();
                agregarDias.add(llenador10);

                JButton submit10 = new JButton("Buscar");
                submit10.setSize(50,50);
                agregarDias.add(submit10);

                JLabel titulo10 = new JLabel();
                agregarDias.add(titulo10);

                submit10.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        boolean encontrado = true;
                        for (Huesped huesAux : huespedes) {
                            if (huesAux.getDni() == Integer.parseInt(llenador10.getText())) {
                                encontrado = false;
                                titulo10.setText("Ingresar cuantos dias se agregan:");

                                JTextField llenador10p2 = new JTextField();
                                agregarDias.add(llenador10p2);

                                JButton submit10p2 = new JButton("Aceptar");
                                agregarDias.add(submit10p2);

                                JLabel resp10 = new JLabel();
                                agregarDias.add(resp10);

                                submit10p2.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        boolean salir = true;
                                        for (int x = listaHospedaje.size() - 1; x > 0 && salir; x--) {
                                            if (listaHospedaje.get(x).getHuesp().getDni() == Integer.parseInt(llenador10.getText())) {
                                                salir = false;
                                                listaHospedaje.get(x).agregarDias(Integer.parseInt(llenador10p2.getText()));
                                                resp10.setText("Nueva fecha de salida:" + listaHospedaje.get(x).getFechaSalida());
                                            }
                                        }
                                    }
                                });
                            }
                        }
                        if (encontrado) {
                            titulo10.setText("DNI no encontrado");
                        }
                    }
                });

                ventana.add(agregarDias);
                agregarDias.setVisible(true);

            }});
            //---------------------------------------------------------//

        op11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                agregarMonto.removeAll();

                agregarMonto.setSize(500, 500);
                agregarMonto.setLayout(new GridLayout(7, 1));

                JLabel pedidor11 = new JLabel();
                pedidor11.setText("Ingresar un dni:");
                agregarMonto.add(pedidor11);

                JTextField llenador11 = new JTextField();
                agregarMonto.add(llenador11);

                JButton submit11 = new JButton("Buscar");
                agregarMonto.add(submit11);

                submit11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JLabel titulo11 = new JLabel();
                        agregarMonto.add(titulo11);
                        boolean encontrado = true;
                        for (Huesped huesAux : huespedes) {
                            if (huesAux.getDni() == Integer.parseInt(llenador11.getText())) {
                                encontrado = false;
                                titulo11.setText("Ingresar cuantos dias se agregan:");

                                JTextField llenador11p2 = new JTextField();
                                agregarMonto.add(llenador11p2);

                                JButton submit11p2 = new JButton("Aceptar");
                                agregarMonto.add(submit11p2);

                                submit11p2.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        boolean salir = true;
                                        JLabel resp11 = new JLabel();
                                        agregarMonto.add(resp11);
                                        for (int x = listaHospedaje.size() - 1; x > 0 && salir; x--) {
                                            if (listaHospedaje.get(x).getHuesp().getDni() == Integer.parseInt(llenador11.getText())) {
                                                salir = false;
                                                listaHospedaje.get(x).nuevoMontoTotal(Integer.parseInt(llenador11p2.getText()));
                                                resp11.setText("El nuevo monto total es: $" + listaHospedaje.get(x).getCostoTotal());
                                            }
                                        }
                                    }
                                });
                            }
                        }
                        if (encontrado) {
                            titulo11.setText("DNI no encontrado");
                        }
                    }
                });

                ventana.add(agregarMonto);
                agregarMonto.setVisible(true);
            }});

        //-------------------------------------------------------------------------------------//

        op12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                insertarHuesped.removeAll();

                insertarHuesped.setSize(500,500);
                insertarHuesped.setLayout(new GridLayout(10,1));

                JLabel ingNom = new JLabel();
                ingNom.setText("Ingrese el nombre:");
                JTextField regNom = new JTextField();
                insertarHuesped.add(ingNom);
                insertarHuesped.add(regNom);

                JLabel ingApe = new JLabel();
                ingApe.setText("Ingrese el apellido:");
                JTextField regApe = new JTextField();
                insertarHuesped.add(ingApe);
                insertarHuesped.add(regApe);

                JLabel ingDNI = new JLabel();
                ingDNI.setText("Ingrese el dni:");
                JTextField regDNI = new JTextField();
                insertarHuesped.add(ingDNI);
                insertarHuesped.add(regDNI);

                JLabel ingEdad = new JLabel();
                ingEdad.setText("Ingrese la edad:");
                JTextField regEdad = new JTextField();
                insertarHuesped.add(ingEdad);
                insertarHuesped.add(regEdad);

                JButton submit12 = new JButton("Aceptar");
                insertarHuesped.add(submit12);

                JLabel resp12 = new JLabel();
                insertarHuesped.add(resp12);

                submit12.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(regNom.getText().equals("") || regApe.getText().equals("") || regDNI.getText().equals("") || regEdad.getText().equals("")){
                            resp12.setText("Por favor complete todos los campos.");
                        }
                        else{
                            Huesped hARegistrar = new Huesped(regNom.getText(),regApe.getText(),Integer.parseInt(regEdad.getText()),Integer.parseInt(regDNI.getText()),0);
                            boolean corroborar = true;
                            for(int i= 0;i<huespedes.size() && corroborar;i++){
                                if(huespedes.get(i).getDni()==hARegistrar.getDni()){
                                    corroborar=false;
                                }

                            }
                            if(corroborar){
                                huespedes.add(hARegistrar);
                                String consulta ="INSERT INTO "+ baseDatosHotel.getNombreTabla();
                                consulta += " (DNI,nombre,apellido,edad,cantEstadias) values(" + Integer.parseInt(regDNI.getText()) + ",'" + regNom.getText() + "','" + regApe.getText() + "'," + Integer.parseInt(regEdad.getText()) + "," + 0 + ");" ;
                                System.out.println(consulta);
                                try {
                                    PreparedStatement sentenciaSQL = baseDatosHotel.getConexion().prepareStatement(consulta);
                                    int result = sentenciaSQL.executeUpdate();
                                    if(result>0){
                                        resp12.setText("Registrado correctamente!");
                                    }
                                    else{
                                        resp12.setText("Error al registrar el huesped.");
                                    }
                                    sentenciaSQL.close();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                            else{
                                resp12.setText("Ese dni ya se encuentra registrado");
                            }
                        }
                    }
                });
                ventana.add(insertarHuesped);
                insertarHuesped.setVisible(true);
            }});

        //------------------------------------------------------------------------------------------//

        op13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seisFrecuentes.setVisible(false);
                dosFrecuentes.setVisible(false);
                plataTotal.setVisible(false);
                lasEstadiasProlongadas.setVisible(false);
                habitacionesQueEstanOcupadas.setVisible(false);
                habitacionesQueEstanDisponibles.setVisible(false);
                huespedesEnDetHabitacion.setVisible(false);
                cantDiasQueQueda.setVisible(false);
                fechaSalida.setVisible(false);
                agregarDias.setVisible(false);
                agregarMonto.setVisible(false);
                insertarHuesped.setVisible(false);
                regisEstadia.setVisible(false);
                seisFrecuentes.removeAll();
                ventana.remove(seisFrecuentes);
                dosFrecuentes.removeAll();
                ventana.remove(dosFrecuentes);
                plataTotal.removeAll();
                ventana.remove(plataTotal);
                lasEstadiasProlongadas.removeAll();
                ventana.remove(lasEstadiasProlongadas);
                habitacionesQueEstanDisponibles.removeAll();
                ventana.remove(habitacionesQueEstanDisponibles);
                habitacionesQueEstanOcupadas.removeAll();
                ventana.remove(habitacionesQueEstanOcupadas);
                huespedesEnDetHabitacion.removeAll();
                ventana.remove(huespedesEnDetHabitacion);
                cantDiasQueQueda.removeAll();
                ventana.remove(cantDiasQueQueda);
                fechaSalida.removeAll();
                ventana.remove(fechaSalida);
                agregarDias.removeAll();
                ventana.remove(agregarDias);
                agregarMonto.removeAll();
                ventana.remove(agregarMonto);
                insertarHuesped.removeAll();
                ventana.remove(insertarHuesped);
                regisEstadia.removeAll();
                ventana.remove(regisEstadia);

                regisEstadia.removeAll();

                regisEstadia.setSize(500, 500);
                regisEstadia.setLayout(new GridLayout(11, 1));

                JLabel titulo13 = new JLabel();
                titulo13.setText("Ingrese un dni:");
                regisEstadia.add(titulo13);

                JTextField llenador13 = new JTextField();
                regisEstadia.add(llenador13);

                JButton submit13 = new JButton("Buscar");
                regisEstadia.add(submit13);

                JLabel pedidor13 = new JLabel();
                regisEstadia.add(pedidor13);


                submit13.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        boolean corroborador=true;
                        int dniIng = Integer.parseInt(llenador13.getText());
                        for(Huesped huesAux:huespedes){
                            if(huesAux.getDni()==dniIng){
                                corroborador=false;
                                pedidor13.setText("Ingrese la fecha de ingreso (Ej. 31-01-2019)");

                                JTextField llenador13p2 = new JTextField();
                                regisEstadia.add(llenador13p2);

                                JLabel pedidor13p2 = new JLabel();
                                regisEstadia.add(pedidor13p2);
                                pedidor13p2.setText("Ingrese la cantidad de huespedes");

                                JComboBox selectorHuespedes=new JComboBox<>();
                                selectorHuespedes.addItem(1);
                                selectorHuespedes.addItem(2);
                                regisEstadia.add(selectorHuespedes);

                                JLabel pedidor13p3 = new JLabel();
                                pedidor13p3.setText("Ingrese la cantidad de dias que se quedara");
                                regisEstadia.add(pedidor13p3);

                                JTextField llenador13p3 = new JTextField();
                                regisEstadia.add(llenador13p3);

                                JButton submit13p2 = new JButton("Aceptar");
                                regisEstadia.add(submit13p2);

                                JLabel resp13 = new JLabel();
                                regisEstadia.add(resp13);

                                submit13p2.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        int numHab=0;
                                        int diasQuedarse=Integer.parseInt(llenador13p3.getText());
                                        Hospedaje hospAux = new Hospedaje(huesAux,habitacion1,llenador13p2.getText(),llenador13p2.getText(),0,diasQuedarse);
                                        boolean habitacionIngresada = true;
                                        if(Integer.parseInt(selectorHuespedes.getSelectedItem().toString())==1){
                                            for (Habitacion hHab:habitaciones) {
                                                if(hHab.getCantPersona()==1 && hHab.getDisponibilidad()){
                                                    if(habitacionIngresada){
                                                        habitacionIngresada=false;
                                                        hospAux.setHabit(hHab);
                                                        hospAux.setCostoTotal(545*hospAux.getCantDias());
                                                        hHab.setDisponibilidad(false);
                                                        numHab=hHab.getNumero();
                                                    }
                                                }
                                            }
                                        }
                                        else{
                                            for (Habitacion hHab:habitaciones) {
                                                if(hHab.getCantPersona()==2 && hHab.getDisponibilidad()){
                                                    if(habitacionIngresada){
                                                        habitacionIngresada=false;
                                                        hospAux.setHabit(hHab);
                                                        hospAux.setCostoTotal(785*hospAux.getCantDias());
                                                        hHab.setDisponibilidad(false);
                                                        numHab=hHab.getNumero();
                                                    }
                                                }
                                            }
                                        }
                                        if(habitacionIngresada){
                                            resp13.setText("No hay habitaciones de ese tipo disponibles.");
                                        }
                                        else {
                                            hospAux.agregarDias(diasQuedarse);
                                            hospAux.setCantDias(hospAux.getCantDias()-diasQuedarse);
                                            listaHospedaje.add(hospAux);
                                            hospAux.getHuesp().setCantDeEstadias(hospAux.getHuesp().getCantDeEstadias()+1);

                                            String consulta = "INSERT INTO "+ baseDatosHospedaje.getNombreTabla();
                                            consulta += " (idHospedaje,DNIhuesped,numHabitacion,fechaEntrada,fechaSalida,costoTotal,cantDias) values (null," + hospAux.getHuesp().getDni() + "," + hospAux.getHabit().getNumero() + ",'" + hospAux.getFechaEntrada() + "','" + hospAux.getFechaSalida() + "'," + hospAux.getCostoTotal() + "," + hospAux.getCantDias() + ");";
                                            System.out.println(consulta);
                                            try{
                                                PreparedStatement sentenciaSQL = baseDatosHospedaje.getConexion().prepareStatement(consulta);
                                                int result = sentenciaSQL.executeUpdate();
                                                if(result>0){
                                                    String consulta2 = "UPDATE habitacion set disponibilidad=false where numHabitacion="+hospAux.getHabit().getNumero();
                                                    System.out.println(consulta2);
                                                    try{
                                                        PreparedStatement sentenciaSQL2 = baseDatosHabitacion.getConexion().prepareStatement(consulta2);
                                                        int result2 = sentenciaSQL2.executeUpdate();
                                                        if(!(result2>0)){
                                                            resp13.setText("Error al cambiar el estado de la habitacion.");
                                                        }
                                                        sentenciaSQL2.close();
                                                    }
                                                    catch (SQLException ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    resp13.setText("Hospedaje registrado correctamente!");
                                                }
                                                else{
                                                    resp13.setText("Error al registrar el hospedaje.");
                                                }
                                                sentenciaSQL.close();
                                            }
                                            catch (SQLException ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    }
                                });
                            }
                        }
                        if(corroborador){
                            pedidor13.setText("El dni no corresponde a ningun huesped registrado.");
                        }
                    }
                });

                ventana.add(regisEstadia);
                regisEstadia.setVisible(true);
            }});
        ventana.setVisible(true);
    }
}

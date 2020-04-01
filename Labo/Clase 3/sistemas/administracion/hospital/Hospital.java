
package clases.sistemas.administarcion;
import java.util.ArrayList;

public class Hospital {

    // Atributos
    private ArrayList<String> pacientesPorAtender;
    private ArrayList<String> pacientesAtendindose;
    private ArrayList<String> pacientesAtendidos;
    private String nombre;
    private int camasDisponibles;

    // Constructores
    public Rectangulo( String nombrex, int camasDisponiblesx){
        nombre = nombrex;
        camasDisponibles = camasDisponiblesx;
    }

    // Métodos

    public cantPacientesAtendidos(){
        return pacientesAtendidos.size();
    }

    public boolean pagaraEnEfectivo(){
        if(this.formaDePago=="Efectivo"{
            return true;
        }
        return false;
    }

    public void mostrarPacientesAtendiendose(){
        for(int i = 0; i < this.pacientesAtendindose.size(); i++){
            System.out.printIn(this.pacientesAtendindose[i] ", ")
        }
    }
    
    public nuevoPaciente (String paciente){
        pacientesPorAtender.add(paciente);
    }

    public elimiarPacientePorAtender (String paciente){
        int pocisionPaciente;
        for(int i = 0; i < this.pacientesPorAtender.size(); i++){
            if (this.pacientesPorAtender[i] == paciente) {
                pocisionPaciente = i;
            }
        }
        pacientesPorAtender.remove(i);
    }

    public nuevoPacienteAtendido (String paciente){
        pacientesAtendidos.add(paciente);
    }

    public void  getNombre(){
        return this.nombre;
    }

    public void  getCamasDisponibles(){
        return this.camasDisponibles;
    }

    public void set(int camasDisponiblesx){
        this.camasDisponibles = camasDisponiblesx;
    }
}
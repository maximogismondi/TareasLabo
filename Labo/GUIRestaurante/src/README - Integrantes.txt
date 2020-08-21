import IPM.3computacion.*;
import Alumno;

public class TPGuiRestaurante{

	private ArrayList<Alumnos> integrantes;
	privare String             codigo;
	
	public TPGuiRestaurante(ArrayList<Alumnos> integrantes, String codigo){
		this.integrantes = integrantes;
		this.codigo      = codigo;
	}

	public void readMe(TPGuiRestaurante TP){
		System.out.print(TP.getCodigo());
	}

	public void intro(){
		System.out.print("Hola, profe buenos dias/tardes/noches. 
				Estuvimos un par de semanas trabajando en este 
				proyecto y como lo hacimos en grupo, 
				teniamos ganas de hacer un trabajo 
				que este bien presentado y en eso trabajamos. 
				No pudimos entregarlo antes ya que, 
				estuvimos cargados con las demas materias y 
				como dice el dicho 'mejor tarde que nunca'. 
				Espero que te guste :slight_smile:)");
	}

	public static void main(String[] args){
		intro();

		ArrayList<Alumnos> Integrantes = new ArrayList<Alumnos>();
				   Integrantes.add(new Alumno("Demian Blum"));
				   Integrantes.add(new Alumno("Francisco Callipo"));
				   Integrantes.add(new Alumno("Emiliano Di Napoli"));
				   Integrantes.add(new Alumno("Maximiliano Gismondi"));
				   Integrantes.add(new Alumno("Juan Moggia"));
				   Integrantes.add(new Alumno("Marcos Pontoriero"));
		String Codigo;
		gianpa_dibujos(Codigo);

		TPGuiRestaurante TP = new TPGuiRestaurante(Integrantes, Codigo);	
				 
		readMe(TP);
	} 

	public String getCodigo(){
		return this.codigo;
	} 
}



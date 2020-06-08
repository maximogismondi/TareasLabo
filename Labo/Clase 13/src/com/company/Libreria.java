package com.company;
import java.util.Map;
import java.util.HashMap;

public class Libreria {

    private HashMap<String, Integer> editoriales;

    public Libreria(){
        this.editoriales = new HashMap<String, Integer>();
        this.editoriales.put("Kapelusz",0);
        this.editoriales.put("Sudamericana",0);
        this.editoriales.put("Atlantida",0);
        this.editoriales.put("ElAteneo",0);
        this.editoriales.put("Interzona",0);
        this.editoriales.put("Sur",0);
        this.editoriales.put("Alianza",0);
    }

    public void agregarEditorial(String editorial){
        this.editoriales.put(editorial, 0);
    }

    public void eliminarEditorial(String editorial){
        this.editoriales.remove(editorial);
    }

    public void agregarVenta(String editorial){
        this.editoriales.replace(editorial, (this.editoriales.get(editorial)+1));
    }

    public void eliminarVenta(String editorial){
        if (this.editoriales.get(editorial) > 0) {
            this.editoriales.replace(editorial, this.editoriales.get(editorial) - 1);
        }
        else{
            System.out.println("Hay 0 libros vendidos, no se puede elimiar otro");
        }
    }

    public int cantidadVendidaEditorial(String editorial){
        return this.editoriales.get(editorial);
    }

    public String editorialConMasVentas(){
        String editorialConMasVentas = "";
        for (HashMap.Entry<String, Integer> editorial : editoriales.entrySet()){
            editorialConMasVentas = editorial.getKey();
        }
        for (HashMap.Entry<String, Integer> editorial : editoriales.entrySet()){
            if (editorial.getValue() > editoriales.get(editorialConMasVentas)){
                editorialConMasVentas = editorial.getKey();
            }
        }
        return editorialConMasVentas;
    }

    public void imprimirTodo(){
        for (HashMap.Entry<String, Integer> editorial : this.getEditoriales().entrySet()){
            System.out.println("Editorial: " + editorial.getKey() +  " Ventas: " + editorial.getValue());
        }
    }

    public HashMap<String, Integer> getEditoriales() {
        return editoriales;
    }
}


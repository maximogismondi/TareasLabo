package com.company;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Libreria {

    private HashMap<StringEditoriales, Integer> editoriales;

    public Libreria(){
        this.editoriales = new HashMap<StringEditoriales, Integer>();
        this.editoriales.put(StringEditoriales.Alianza,0);
        this.editoriales.put(StringEditoriales.Atlántida,0);
        this.editoriales.put(StringEditoriales.ElAteneo,0);
        this.editoriales.put(StringEditoriales.Interzona,0);
        this.editoriales.put(StringEditoriales.Kapelusz,0);
        this.editoriales.put(StringEditoriales.Sudamericana,0);
        this.editoriales.put(StringEditoriales.Sur,0);
    }

    public void agregarVenta(String editorial){
        switch (editorial){
            case "Kapelusz":
                this.editoriales.replace(StringEditoriales.Kapelusz, (this.editoriales.get(editorial)+1));
            case "Sudamericana":
                this.editoriales.replace(StringEditoriales.Sudamericana, (this.editoriales.get(editorial)+1));
            case "Atlántida":
                this.editoriales.replace(StringEditoriales.Atlántida, (this.editoriales.get(editorial)+1));
            case "ElAteneo":
                this.editoriales.replace(StringEditoriales.ElAteneo, (this.editoriales.get(editorial)+1));
            case "Interzona":
                this.editoriales.replace(StringEditoriales.Interzona, (this.editoriales.get(editorial)+1));
            case "Sur":
                this.editoriales.replace(StringEditoriales.Sur, (this.editoriales.get(editorial)+1));
            case "Alianza":
                this.editoriales.replace(StringEditoriales.Alianza, (this.editoriales.get(editorial)+1));
        }
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
}


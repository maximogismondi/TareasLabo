package com.company;

public enum StringEditoriales{
    Kapelusz("Kapelusz"), Sudamericana("Sudamericana"), Atlántida("Atlántida"), ElAteneo("ElAteneo"), Interzona("Interzona"), Sur("Sur") , Alianza("Alianza");

    private String nombre_editorial;

    private StringEditoriales(String nombre_editorial){
        this.nombre_editorial = nombre_editorial;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }
}

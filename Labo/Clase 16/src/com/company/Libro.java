package com.company;

public enum Libro {
    Chico(24, 50), Mediano (48, 100), Grande (98, 175);

    private int cant_paginas;
    private int precio;

    private Libro(int cant_paginas, int precio){
        this.cant_paginas = cant_paginas;
        this.precio = precio;
    }

    public int getCant_paginas() {
        return cant_paginas;
    }

    public void setCant_paginas(int cant_paginas) {
        this.cant_paginas = cant_paginas;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

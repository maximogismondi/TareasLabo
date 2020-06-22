package com.company;
import java.util.ArrayList;
import java.util.Objects;

public class ArrayLIstV2 extends ArrayList{
    public void agregar_elementos(Objects... elementos){
        for (Objects elemento : elementos) {
            this.add(elemento);
        }
    }
}
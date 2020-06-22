package com.company;
import java.util.HashSet;
import java.util.Objects;

public class HashSetV2 extends HashSet {
    public void agregar_elementos(Objects... elementos){
        for (Objects elemento : elementos) {
            this.add(elementos);
        }
    }
}

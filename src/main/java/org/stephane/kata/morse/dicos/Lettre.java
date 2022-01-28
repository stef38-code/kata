package org.stephane.kata.morse.dicos;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lettre extends Dictionnaire {

    @Override
    protected void initDico() {
        addCode("A", ".-");
        addCode("B", "-...");
        addCode("C", "-.-.");
        addCode("D", "-..");
        addCode("E", ".");
        addCode("F", "..-.");
        addCode("G", "--.");
        addCode("H", "....");
        addCode("I", "..");
        addCode("J", ".---");
        addCode("K", "-.-");
        addCode("L", ".-..");
        addCode("M", "--");
        addCode("N", "-.");
        addCode("O", "---");
        addCode("P", ".--.");
        addCode("Q", "--.-");
        addCode("R", ".-.");
        addCode("S", "...");
        addCode("T", "-");
        addCode("U", "..-");
        addCode("V", "...-");
        addCode("W", ".--");
        addCode("X", "-..-");
        addCode("Y", "-.--");
        addCode("Z", "--..");
    }

}

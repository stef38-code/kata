package org.stephane.kata.morse.dicos;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chiffre extends Dictionnaire {

    public Chiffre() {
        initDico();
    }

    @Override
    protected void initDico() {
        addCode("0", "-----");
        addCode("1", ".----");
        addCode("2", "..---");
        addCode("3", "..--");
        addCode("4", "....-");
        addCode("5", ".....");
        addCode("6", "-....");
        addCode("7", "- -...");
        addCode("8", "---..");
        addCode("9", "----.");


    }
}

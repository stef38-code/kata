package org.stephane.kata.morse.dicos;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
@Slf4j
public class Chiffre extends DictionnaireImpl {

    public Chiffre() {
        initDico();
    }

    private void initDico() {
        dicoMap.put("0", "-----");
        dicoMap.put("1", ".----");
        dicoMap.put("2", "..---");
        dicoMap.put("3", "..--");
        dicoMap.put("4", "....-");
        dicoMap.put("5", ".....");
        dicoMap.put("6", "-....");
        dicoMap.put("7", "- -...");
        dicoMap.put("8", "---..");
        dicoMap.put("9", "----.");


    }
}

package org.stephane.kata.morse;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class DicoChiffre {
    private final Map<String, String> dicoChiffres;

    public DicoChiffre() {
        this.dicoChiffres = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        initDico();
    }

    private void initDico() {
        dicoChiffres.put("0", "-----");
        dicoChiffres.put("1", ".----");
        dicoChiffres.put("2", "..---");
        dicoChiffres.put("3", "..--");
        dicoChiffres.put("4", "....-");
        dicoChiffres.put("5", ".....");
        dicoChiffres.put("6", "-....");
        dicoChiffres.put("7", "- -...");
        dicoChiffres.put("8", "---..");
        dicoChiffres.put("9", "----.");


    }

    public Optional<String> getChiffre(String text) {
        return Optional.ofNullable(dicoChiffres.get(text));
    }

}

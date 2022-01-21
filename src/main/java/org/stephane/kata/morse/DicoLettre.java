package org.stephane.kata.morse;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class DicoLettre {
    private final Map<String, String> dicoLettres;

    public DicoLettre() {
        this.dicoLettres = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        initDico();
    }

    private void initDico() {
        dicoLettres.put("A", ".-");
        dicoLettres.put("B", "-...");
        dicoLettres.put("C", "-.-.");
        dicoLettres.put("D", "-..");
        dicoLettres.put("E", ".");
        dicoLettres.put("F", "..-.");
        dicoLettres.put("G", "--.");
        dicoLettres.put("H", "....");
        dicoLettres.put("I", "..");
        dicoLettres.put("J", ".---");
        dicoLettres.put("K", "-.-");
        dicoLettres.put("L", ".-..");
        dicoLettres.put("M", "--");
        dicoLettres.put("N", "-.");
        dicoLettres.put("O", "---");
        dicoLettres.put("P", ".--.");
        dicoLettres.put("Q", "--.-");
        dicoLettres.put("R", ".-.");
        dicoLettres.put("S", "...");
        dicoLettres.put("T", "-");
        dicoLettres.put("U", "..-");
        dicoLettres.put("V", "...-");
        dicoLettres.put("W", ".--");
        dicoLettres.put("X", "-..-");
        dicoLettres.put("Y", "-.--");
        dicoLettres.put("Z", "--..");
    }

    public Optional<String> getCode(String text) {
        return Optional.ofNullable(dicoLettres.get(text));
    }
}

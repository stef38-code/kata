package org.stephane.kata.morse;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class DicoCaracteresSpeciaux {
    private final Map<String, String> dicoCaractSpeciaux;

    public DicoCaracteresSpeciaux() {
        this.dicoCaractSpeciaux = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        initDico();
    }

    private void initDico() {
        dicoCaractSpeciaux.put(".", ".-.-.-");
        dicoCaractSpeciaux.put(",", "--..--");
        dicoCaractSpeciaux.put("?", "..--..");
        dicoCaractSpeciaux.put("'", ".----.");
        dicoCaractSpeciaux.put("!", "-.-.--");
        dicoCaractSpeciaux.put("/", "-..-.");
        dicoCaractSpeciaux.put("(", "-.--.");
        dicoCaractSpeciaux.put(")", "-.--.-");
        dicoCaractSpeciaux.put("&", ".-...");
        dicoCaractSpeciaux.put(":", "---...");
        dicoCaractSpeciaux.put(";", "-.-.-.");
        dicoCaractSpeciaux.put("=", "-...-");
        dicoCaractSpeciaux.put("+", ".-.-.");
        dicoCaractSpeciaux.put("-", "-....-");
        dicoCaractSpeciaux.put("_", "..--.-");
        dicoCaractSpeciaux.put("\"", ".-..-.");
        dicoCaractSpeciaux.put("$", "...-..-");
        dicoCaractSpeciaux.put("@", ".--.-.");

    }

    public Optional<String> getCaracteresSpeciaux(String text) {
        return Optional.ofNullable(dicoCaractSpeciaux.get(text));
    }

}

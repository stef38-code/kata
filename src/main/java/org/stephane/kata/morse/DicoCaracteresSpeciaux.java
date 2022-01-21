package org.stephane.kata.morse;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
@Slf4j
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
//        dicoCaractSpeciaux.put("à","·−−·−");
//dicoCaractSpeciaux.put("ä","·−·−");
//dicoCaractSpeciaux.put("ç","−·−··");
//dicoCaractSpeciaux.put("é","··−··");
//dicoCaractSpeciaux.put("è","·−··−");
//dicoCaractSpeciaux.put("ö","−−−·");
    }

    public Optional<String> getCaracteresSpeciaux(String text) {
        log.info("Caracteres Speciaux {}",text);
        return Optional.ofNullable(dicoCaractSpeciaux.get(text));
    }

}

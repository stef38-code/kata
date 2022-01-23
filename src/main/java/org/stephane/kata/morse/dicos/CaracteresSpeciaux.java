package org.stephane.kata.morse.dicos;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CaracteresSpeciaux extends Dictionnaire {
     public CaracteresSpeciaux() {
        initDico();
    }

    private void initDico() {
        dicoMap.put(".", ".-.-.-");
        dicoMap.put(",", "--..--");
        dicoMap.put("?", "..--..");
        dicoMap.put("'", ".----.");
        dicoMap.put("!", "-.-.--");
        dicoMap.put("/", "-..-.");
        dicoMap.put("(", "-.--.");
        dicoMap.put(")", "-.--.-");
        dicoMap.put("&", ".-...");
        dicoMap.put(":", "---...");
        dicoMap.put(";", "-.-.-.");
        dicoMap.put("=", "-...-");
        dicoMap.put("+", ".-.-.");
        dicoMap.put("-", "-....-");
        dicoMap.put("_", "..--.-");
        dicoMap.put("\"", ".-..-.");
        dicoMap.put("$", "...-..-");
        dicoMap.put("@", ".--.-.");
    }

}

package org.stephane.kata.morse.dicos;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
@Slf4j
public class Lettre extends DictionnaireImpl {
    public Lettre() {
        initDico();
    }

    private void initDico() {
        dicoMap.put("A", ".-");
        dicoMap.put("B", "-...");
        dicoMap.put("C", "-.-.");
        dicoMap.put("D", "-..");
        dicoMap.put("E", ".");
        dicoMap.put("F", "..-.");
        dicoMap.put("G", "--.");
        dicoMap.put("H", "....");
        dicoMap.put("I", "..");
        dicoMap.put("J", ".---");
        dicoMap.put("K", "-.-");
        dicoMap.put("L", ".-..");
        dicoMap.put("M", "--");
        dicoMap.put("N", "-.");
        dicoMap.put("O", "---");
        dicoMap.put("P", ".--.");
        dicoMap.put("Q", "--.-");
        dicoMap.put("R", ".-.");
        dicoMap.put("S", "...");
        dicoMap.put("T", "-");
        dicoMap.put("U", "..-");
        dicoMap.put("V", "...-");
        dicoMap.put("W", ".--");
        dicoMap.put("X", "-..-");
        dicoMap.put("Y", "-.--");
        dicoMap.put("Z", "--..");
    }

}

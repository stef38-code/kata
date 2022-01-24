package org.stephane.kata.morse.dicos;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
@Slf4j
public abstract class Dictionnaire {
    private final Map<String, String> dicoMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    protected Dictionnaire() {
        initDico();
    }

    public Optional<String> getMorseCode(String caractere) {
        log.debug("ecncodage du caractere {}",caractere);
        return Optional.ofNullable(dicoMap.get(caractere));
    }
    protected abstract void initDico() ;

    protected void addCode(String mot,String code){
        dicoMap.put(mot,code);
    }
}

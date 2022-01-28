package org.stephane.kata.morse.dicos;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
@Slf4j
public abstract class Dictionnaire {
    private final Map<String, String> dicoCaractereCodeMorseMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private final Map<String, String> dicoCodeMorseCaractereMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    protected Dictionnaire() {
        initDico();
    }

    public Optional<String> getMorseCode(String caractere) {
        log.debug("encodage du caractere {}",caractere);
        return Optional.ofNullable(dicoCaractereCodeMorseMap.get(caractere));
    }
    public Optional<String> getCaractere(String caractere) {
        log.debug("deccodage du caractere {}",caractere);
        return Optional.ofNullable(dicoCodeMorseCaractereMap.get(caractere));
    }
    protected abstract void initDico() ;

    protected void addCode(String caractere,String codeMorse){
        dicoCaractereCodeMorseMap.put(caractere,codeMorse);
        dicoCodeMorseCaractereMap.put(codeMorse,caractere);
    }

}

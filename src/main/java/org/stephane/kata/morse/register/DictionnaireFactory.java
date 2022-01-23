package org.stephane.kata.morse.register;

import org.stephane.kata.morse.dicos.Dictionnaire;

import java.util.Optional;

public interface DictionnaireFactory {
    Optional<String> getMorseCode(String caractere);
    void addDictionnaire(Dictionnaire dico);
}

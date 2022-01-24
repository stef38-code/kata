package org.stephane.kata.morse.register;

import org.stephane.kata.morse.dicos.Dictionnaire;

import java.util.Optional;

/**
 * Definition d'un factory
 */
public interface DictionnaireFactory {
    /**
     * Donne le code morse d'un caractare
     * @param caractere le caractere
     * @return optional si il existe une correspondance
     */
    Optional<String> getMorseCode(String caractere);

    /**
     * Ajout d'un Dico dans le register
     * @param dico le dico
     */
    void addDictionnaire(Dictionnaire dico);
}

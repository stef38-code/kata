package org.stephane.kata.morse.register;

import org.stephane.kata.morse.dicos.Dictionnaire;

import java.util.Optional;

/**
 * Definition d'un factory
 */
public interface DictionnaireFactory {
    /**
     * Donne le code morse en fonction du caractere donné
     * @param caractere le caractere
     * @return le caractere si trouvé, sinon Optional.empty()
     */
    Optional<String> getMorseCode(String caractere);

    /**
     * Ajout d'un Dico dans le register
     * @param dico le dico
     */
    void addDictionnaire(Dictionnaire dico);
    /**
     * Donne le caractere en fonction du code morse donné
     * @param codeMorseDuCaractere le code morse d'un caractere
     * @return le code morse si trouvé, sinon Optional.empty()
     */
    Optional<String> getDecode(String codeMorseDuCaractere);
}

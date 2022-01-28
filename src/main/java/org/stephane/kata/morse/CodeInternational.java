package org.stephane.kata.morse;

import lombok.extern.slf4j.Slf4j;
import org.stephane.kata.morse.business.DuText;
import org.stephane.kata.morse.exceptions.DictionnaireException;

/**
 * Classe principale pour
 * l'écriture en morse d'un text
 * lecture du text en morse
 */
@Slf4j
public class CodeInternational {
    private final DuText text = new DuText();

    /**
     * Donne le code morse du text
     * @param text le text à convertir
     * @return le code morse
     * @throws DictionnaireException si un des caractères n'est pas défini dans les dictionnaires
     */
    public String toMorse(String text) throws DictionnaireException {
        return this.text.getCodeMorseDuText(text);
    }

    /**
     * Donne le text depuis le code morse
     * @param code le code morse
     * @return le text
     * @throws DictionnaireException si un des codes morses n'est pas défini dans les dictionnaires
     */
    public String toText(String code) throws DictionnaireException {
        return text.getTextDuMorse(code);
    }
}

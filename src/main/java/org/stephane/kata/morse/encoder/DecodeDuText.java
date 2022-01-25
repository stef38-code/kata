package org.stephane.kata.morse.encoder;

import lombok.extern.slf4j.Slf4j;
import org.stephane.kata.morse.exceptions.DictionnaireException;

/**
 * Encode du text
 */
@Slf4j
public class DecodeDuText extends EncodeUnMot {
    public static final String TEMPS_ENTRE_DEUX_MOTS = " ....... ";

    /**
     * Donne le code Morse du text
     * @param text le text
     * @return le code Morse sous une forme d'une string
     * @throws DictionnaireException  si un caractere est inconnu
     */
    public String getCodeDuText(String text) throws DictionnaireException {
        log.debug("encode le text: {}",text);
        //split en un tabeau de mot
        String[] words = text.split("\\s+");
        StringBuilder valueBuilder = new StringBuilder();
        encodeLesMots(words,words.length-1,valueBuilder);
        return valueBuilder.toString();
    }

    /**
     * Construction d'une chaine de caractere de code Morse depuis un tableau de mot
     * @param mots tableau de mot
     * @param position position de départ
     * @param valueBuilder chaine pour le code morse
     * @throws DictionnaireException si un caractere est inconnu
     */
    private void encodeLesMots(String[] mots,int position,StringBuilder valueBuilder) throws DictionnaireException {
        if (  position >= 1 ) {
            encodeLesMots(mots,position -1,valueBuilder);
            valueBuilder.append(DecodeDuText.TEMPS_ENTRE_DEUX_MOTS);
        }
        valueBuilder.append(getCodeDuMot(mots[position])) ;
    }
}

package org.stephane.kata.morse.business;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.stephane.kata.morse.exceptions.DictionnaireException;

/**
 * Encode du text
 */
@Slf4j
public class DuText extends UnMot {
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
            valueBuilder.append(TEMPS_ENTRE_DEUX_MOTS);
        }
        valueBuilder.append(getCodeDuMot(mots[position])) ;
    }

    public String getDecodeDuText(String code) throws DictionnaireException {
        log.debug("Decode le code: {}",code);
        //split en un tabeau de mot
        String[] codes = code.split(TEMPS_ENTRE_DEUX_MOTS);
        StringBuilder valueBuilder = new StringBuilder();
        decodeLesCodes(codes,codes.length-1,valueBuilder);
        return valueBuilder.toString();
    }
    private void decodeLesCodes(String[] codes,int position,StringBuilder valueBuilder) throws DictionnaireException {
        if (  position >= 1 ) {
            decodeLesCodes(codes,position -1,valueBuilder);
            valueBuilder.append(DuText.TEMPS_ENTRE_DEUX_MOTS);
        }
        valueBuilder.append(getDecodeDuMot(codes[position])) ;
    }


}

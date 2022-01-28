package org.stephane.kata.morse.business;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.stephane.kata.morse.exceptions.DictionnaireException;

/**
 * Encode/Decode du text
 */
@Slf4j
public class DuText extends UnMot {
    /**
     * Code morse pour l'entre deux mot
     */
    public static final String TEMPS_ENTRE_DEUX_MOTS = " ....... ";
    /**
     * Expression pour extraire les mots codés
     */
    public static final String REG_TEMPS_ENTRE_DEUX_MOTS = " \\.\\.\\.\\.\\.\\.\\. ";

    /**
     * Donne le code Morse du text
     * @param text le text
     * @return le code Morse sous une forme d'une string
     * @throws DictionnaireException  si un caractere est inconnu
     */
    public String getCodeMorseDuText(String text) throws DictionnaireException {
        log.debug("encode le text: {}",text);
        //split en un tabeau de mot
        String[] words = text.split("\\s+");
        StringBuilder valueBuilder = new StringBuilder();
        //Parcourt le tableau de mot
        encodeLesMots(words,words.length-1,valueBuilder);
        return valueBuilder.toString();
    }

    /**
     * Donne le text
     * @param code le code morse
     * @return le text sous une forme d'une string
     * @throws DictionnaireException  si un caractere est inconnu
     */
    public String getTextDuMorse(String code) throws DictionnaireException {
        StringBuilder valueBuilder = new StringBuilder();
        log.info("Decode le code: {}",code);
        //split en un tabeau de mot
        String[] codes = code.split(REG_TEMPS_ENTRE_DEUX_MOTS);
        //Parcourt le tableau de code
        decodeLesCodes(codes,codes.length-1,valueBuilder);
        return valueBuilder.toString();
    }
    /**
     * Construction d'une chaine de caractere de code Morse depuis un tableau de mot
     * @param mots tableau de mot
     * @param position position en cours
     * @param valueBuilder chaine pour le code morse
     * @throws DictionnaireException si un caractere est inconnu
     */
    private void encodeLesMots(String[] mots,int position,StringBuilder valueBuilder) throws DictionnaireException {
        if (  position >= 1 ) {
            encodeLesMots(mots,position -1,valueBuilder);
            valueBuilder.append(TEMPS_ENTRE_DEUX_MOTS);
        }
        valueBuilder.append(getCodeMorseDuMot(mots[position])) ;

    }
    private void decodeLesCodes(String[] codes,int position,StringBuilder valueBuilder) throws DictionnaireException {
        if (  position >= 1 ) {
            decodeLesCodes(codes,position -1,valueBuilder);
            valueBuilder.append(StringUtils.SPACE);
        }
        valueBuilder.append(getMotDuCodeMorse(codes[position])) ;
    }


}

package org.stephane.kata.morse.encoder;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.stephane.kata.morse.exceptions.DictionnaireException;

/**
 * Encode un mot
 */
@Slf4j
public class EncodeUnMot extends EncodeUnCaractere {
    public static final String TEMPS_ENTRE_DEUX_LETTRES = StringUtils.SPACE;

    /**
     * Donne le code Morse d'un mot
     * @param mot le mot
     * @return le code morse du mot
     * @throws DictionnaireException si un caractere est inconnu
     */
    public String getCodeDuMot(String mot) throws DictionnaireException {
        log.debug("encode le mot: {}",mot);
        StringBuilder valueBuilder = new StringBuilder();
        char[] ch = mot.toCharArray();
        encodeMot(ch,ch.length-1,valueBuilder);
         return valueBuilder.toString();
    }

    /**
     * Construction d'une chaine de caractere de code Morse depuis un tableau de caractere
     * Appel récursif
     * @param tableauDeCaracteres tableau de caracteres
     * @param position position de depart
     * @param valueBuilder chaine pour le code morse
     * @throws DictionnaireException si un caractere est inconnu
     */
    private void encodeMot(char[] tableauDeCaracteres,int position,StringBuilder valueBuilder) throws DictionnaireException {
        if (  position >= 1 ) {
            encodeMot(tableauDeCaracteres,position -1,valueBuilder);
            valueBuilder.append(EncodeUnMot.TEMPS_ENTRE_DEUX_LETTRES);
        }
        valueBuilder.append(getCode(tableauDeCaracteres[position])) ;
    }
}

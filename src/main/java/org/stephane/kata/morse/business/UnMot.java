package org.stephane.kata.morse.business;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.stephane.kata.morse.exceptions.DictionnaireException;

/**
 * Encode un mot
 */
@Slf4j
public class UnMot extends UnCaractere {
    public static final String TEMPS_ENTRE_DEUX_LETTRES = StringUtils.SPACE;

    /**
     * Donne le code Morse d'un mot
     * @param mot le mot
     * @return le code morse du mot
     * @throws DictionnaireException si un caractere est inconnu
     */
    public String getCodeMorseDuMot(String mot) throws DictionnaireException {
        StringBuilder valueBuilder = new StringBuilder();
        char[] ch = mot.toCharArray();
        //parcourt les lettres
        encodeLettre(ch,ch.length-1,valueBuilder);
        log.info("encode le mot: '{}' '{}'",mot,valueBuilder);
         return valueBuilder.toString();
    }

    /**
     * Donne le mot correspondant au code morse donnée
     * @param code le code morse d'un mot
     * @return le mot
     * @throws DictionnaireException si un code morse est inconnu
     */
    public String getMotDuCodeMorse(String code) throws DictionnaireException {

        StringBuilder valueBuilder = new StringBuilder();
        String[] codes = code.split(TEMPS_ENTRE_DEUX_LETTRES);
        //Parcourt les lettres en morse
        decodeLettre(codes,codes.length-1,valueBuilder);
        log.info("Decode le code '{}' '{}'",code,valueBuilder);
        return valueBuilder.toString();
    }
    /**
     * Construction d'une chaine de caractere de code Morse depuis un tableau de caractere
     * Appel récursif
     * @param tableauDeCaracteres tableau de caracteres
     * @param position position en cours
     * @param valueBuilder chaine pour le code morse
     * @throws DictionnaireException si un caractere est inconnu
     */
    private void encodeLettre(char[] tableauDeCaracteres, int position, StringBuilder valueBuilder) throws DictionnaireException {
        if (  position >= 1 ) {
            encodeLettre(tableauDeCaracteres,position -1,valueBuilder);
            valueBuilder.append(UnMot.TEMPS_ENTRE_DEUX_LETTRES);
        }
        valueBuilder.append(getCodeMorseDuCaractere(tableauDeCaracteres[position])) ;
    }

    /**
     * Construction d'une chaine de caractere de lettre depuis un tableau de code morse
     * Appel récursif
     * @param tableauDeCodes tableau de code morse
     * @param position la position en cours
     * @param valueBuilder chaine pour le mot
     * @throws DictionnaireException si un code morse est inconnu
     */
    private void decodeLettre(String[] tableauDeCodes, int position, StringBuilder valueBuilder) throws DictionnaireException {
        if (  position >= 1 ) {
            decodeLettre(tableauDeCodes,position -1,valueBuilder);
        }
        valueBuilder.append(getCaractereDuCodeMorse(tableauDeCodes[position])) ;
    }


}

package org.stephane.kata.morse.business;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.stephane.kata.morse.exceptions.DictionnaireException;
import org.stephane.kata.morse.register.DictionnaireFactory;
import org.stephane.kata.morse.register.DictionnaireFactoryRegister;

import java.util.Optional;

/**
 * Encodage d'un caractere
 */
@Slf4j
public class UnCaractere {
    private final DictionnaireFactory register = new DictionnaireFactoryRegister();

    /**
     * Donne le code morse d'un seul caractere
     * @param caracatere le caractere
     * @return le code sous forme de String
     * @throws DictionnaireException si le caractere est inconnu
     */
    public String getCodeMorseDuCaractere(String caracatere) throws DictionnaireException {
        log.info("encode le caracatere: {}",caracatere);
        Optional<String> codeMorse = register.getMorseCode( getMotSansAccent(caracatere));
        if (codeMorse.isPresent()) {
            return codeMorse.get();
        }
        throw new DictionnaireException("Le caractere ["+caracatere+"] n'existe pas dans le dictionnaire des codes morse !!");
    }

    /**
     * Donne le code morse d'un seul caractere
     * @param codeAscii valeur ascii(Unicode) du caractere
     * @return le code sous forme de String
     * @throws DictionnaireException si le caractere est inconnu
     */
    public String getCodeMorseDuCaractere(int codeAscii) throws DictionnaireException {
        return getCodeMorseDuCaractere(Character.toString(codeAscii));
    }

    /**
     * Donne une chaine de caractere sans accents
     * @param text chaine de caractere avec/sans accents
     * @return chaine de caractere sans accents
     */
    private String getMotSansAccent(String text) {
        return StringUtils.stripAccents(text);
    }

    public String getCaractereDuCodeMorse(String codeUnCaractere) throws DictionnaireException {

        Optional<String> caractere = register.getDecode( codeUnCaractere);
        if (caractere.isPresent()) {
            log.info("decode '{}' le caracatere: {}",caractere.get(),codeUnCaractere);
            return caractere.get();
        }
        throw new DictionnaireException("Le code morse ["+codeUnCaractere+"] n'existe pas dans le dictionnaire des codes morse !!");
    }
}

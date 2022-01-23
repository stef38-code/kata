package org.stephane.kata.morse.encoder;

import org.apache.commons.lang3.StringUtils;
import org.stephane.kata.morse.exceptions.DictionnaireException;
import org.stephane.kata.morse.register.DictionnaireFactory;
import org.stephane.kata.morse.register.DictionnaireFactoryRegister;

import java.util.Optional;

public class EncodeUnCaractere {
    private final DictionnaireFactory register = new DictionnaireFactoryRegister();

    public String getCodeCaractereValue(String text) throws DictionnaireException {
        Optional<String> codeMorse = register.getMorseCode( getMotSansAccent(text));
        if (codeMorse.isPresent()) {
            return codeMorse.get();
        }
        throw new DictionnaireException("Le caractere ["+text+"] n'existe pas dans le dictionnaire des codes morse !!");
    }

    public String getCodeCaractereValue(int caractere) throws DictionnaireException {
        return getCodeCaractereValue(Character.toString(caractere));
    }

    /**
     * Retourne la chaine de caractere sans accents
     * @param text chaine de caractere avec/sans accents
     * @return chaine de caractere sans accents
     */
    private String getMotSansAccent(String text) {
        String motSansAccent = StringUtils.stripAccents(text);
        return motSansAccent;
    }
}

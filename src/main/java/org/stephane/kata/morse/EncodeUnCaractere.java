package org.stephane.kata.morse;

import org.stephane.kata.morse.dicos.*;

import java.util.Optional;

public class EncodeUnCaractere {
    final Dictionnaire lettre = new Lettre();
    final Dictionnaire chiffre = new Chiffre();
    final Dictionnaire caracteresSpeciaux = new CaracteresSpeciaux();

    public String getCodeCaractereValue(String text) throws DictionnaireException {
        Optional<String> codeLettre = lettre.getMorseCode(text);
        if (codeLettre.isPresent()) {
            return codeLettre.get();
        } else {
            Optional<String> codeChiffre = chiffre.getMorseCode(text);
            if (codeChiffre.isPresent()) {
                return codeChiffre.get();
            } else {
                Optional<String> codeCaracteresSpeciaux = caracteresSpeciaux.getMorseCode(text);
                if (codeCaracteresSpeciaux.isPresent()) {
                    return codeCaracteresSpeciaux.get();
                }
            }
        }
        throw new DictionnaireException("Le caractere ["+text+"] n'existe pas dans le dictionnaire des codes morse !!");
    }

    public String getCodeCaractereValue(int caractere) throws DictionnaireException {
        return getCodeCaractereValue(Character.toString(caractere));
    }
}

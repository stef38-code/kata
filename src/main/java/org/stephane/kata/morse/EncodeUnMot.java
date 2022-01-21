package org.stephane.kata.morse;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class EncodeUnMot {
    public static final String TEMPS_ENTRE_DEUX_LETTRES = StringUtils.SPACE;
    final DicoLettre dicoLettre = new DicoLettre();
    final DicoChiffre dicoChiffre = new DicoChiffre();
    final DicoCaracteresSpeciaux dicoCaracteresSpeciaux = new DicoCaracteresSpeciaux();

    String getCodeValue(int caractere) {
        return getCodeValue(Character.toString(caractere));
    }

    String getCodeValue(String text) {
        Optional<String> code = dicoLettre.getCode(text);
        return code.orElseGet(
                () -> dicoChiffre.getChiffre(text).orElseGet(
                        () -> dicoCaracteresSpeciaux.getCaracteresSpeciaux(text).orElse(StringUtils.EMPTY))
        );
    }
}

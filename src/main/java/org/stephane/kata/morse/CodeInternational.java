package org.stephane.kata.morse;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class CodeInternational {
    private final DicoLettre dicoLettre = new DicoLettre();
    private final DicoChiffre dicoChiffre = new DicoChiffre();
    private final DicoCaracteresSpeciaux dicoCaracteresSpeciaux = new DicoCaracteresSpeciaux();


    public String toMorse(String text) {
        Optional<String> code = dicoLettre.getCode(text);
        return code.orElseGet(
                () -> dicoChiffre.getChiffre(text).orElseGet(
                        ()->dicoCaracteresSpeciaux.getCaracteresSpeciaux(text).orElse(StringUtils.EMPTY))
        );
    }

}

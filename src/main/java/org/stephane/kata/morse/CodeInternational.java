package org.stephane.kata.morse;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

@Slf4j
public class CodeInternational {
    public static final String TEMPS_ENTRE_DEUX_LETTRES = StringUtils.SPACE;
    private final DicoLettre dicoLettre = new DicoLettre();
    private final DicoChiffre dicoChiffre = new DicoChiffre();
    private final DicoCaracteresSpeciaux dicoCaracteresSpeciaux = new DicoCaracteresSpeciaux();


    public String toMorse(String text) {

        StringBuilder valueBuilder = new StringBuilder();
        text.chars().forEach( caractere -> valueBuilder.append(
                getCodeValue(caractere)
        ).append(TEMPS_ENTRE_DEUX_LETTRES));

        return valueBuilder.toString().trim();
    }

    private String getCodeValue(int caractere) {
        return getCodeValue(Character.toString(caractere));
    }
    private String getCodeValue(String text) {
        Optional<String> code = dicoLettre.getCode(text);
        return code.orElseGet(
                () -> dicoChiffre.getChiffre(text).orElseGet(
                        () -> dicoCaracteresSpeciaux.getCaracteresSpeciaux(text).orElse(StringUtils.EMPTY))
        );
    }

}

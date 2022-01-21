package org.stephane.kata.morse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeInternational {
    private final EncodeUnMot encodeUnMot = new EncodeUnMot();


    public String toMorse(String text) {

        StringBuilder valueBuilder = new StringBuilder();
        text.chars().forEach( caractere -> valueBuilder.append(
                encodeUnMot.getCodeValue(caractere)
        ).append(EncodeUnMot.TEMPS_ENTRE_DEUX_LETTRES));

        return valueBuilder.toString().trim();
    }


}

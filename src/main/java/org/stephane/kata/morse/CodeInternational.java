package org.stephane.kata.morse;

import org.apache.commons.lang3.StringUtils;

public class CodeInternational {
    private final DicoLettre dicoLettre = new DicoLettre();


    public String toMorse(String text) {
        return dicoLettre.getCode(text).orElse(StringUtils.EMPTY);
    }

}

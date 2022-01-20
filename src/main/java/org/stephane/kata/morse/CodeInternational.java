package org.stephane.kata.morse;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class CodeInternational {
    private Map<String,String> dicoLettres = new LinkedHashMap<>();

    public CodeInternational() {
        dicoLettres.put("A",".-");
        dicoLettres.put("S","...");
        dicoLettres.put("Z","--..");
    }

    public String toMorse(String text) {
        if(isEquals(text)) {
            return dicoLettres.get(text);
        }
        return StringUtils.EMPTY;
    }

    private boolean isEquals(String text) {
        return dicoLettres.containsKey(text);
    }
}

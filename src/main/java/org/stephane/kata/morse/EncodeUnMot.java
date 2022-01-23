package org.stephane.kata.morse;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.stephane.kata.morse.dicos.DictionnaireException;

import java.util.stream.IntStream;

@Slf4j
public class EncodeUnMot extends EncodeUnCaractere {
    public static final String TEMPS_ENTRE_DEUX_LETTRES = StringUtils.SPACE;

    public String getCodeMotValue(String text) throws DictionnaireException {
        log.debug("encode le mot: {}",text);
        StringBuilder valueBuilder = new StringBuilder();
        char[] ch = getMotSansAccent(text).toCharArray();
        for (char c : ch) {
            valueBuilder.append(
                    getCodeCaractereValue(c)
            ).append(EncodeUnMot.TEMPS_ENTRE_DEUX_LETTRES);
        }
        return valueBuilder.toString().trim();
    }

    private String getMotSansAccent(String text) {
        String motSansAccent = StringUtils.stripAccents(text);
        return motSansAccent;
    }
}

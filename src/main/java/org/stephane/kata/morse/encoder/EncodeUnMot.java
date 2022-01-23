package org.stephane.kata.morse.encoder;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.stephane.kata.morse.exceptions.DictionnaireException;

@Slf4j
public class EncodeUnMot extends EncodeUnCaractere {
    public static final String TEMPS_ENTRE_DEUX_LETTRES = StringUtils.SPACE;

    public String getCodeMotValue(String text) throws DictionnaireException {
        log.debug("encode le mot: {}",text);
        StringBuilder valueBuilder = new StringBuilder();
        char[] ch = text.toCharArray();
        encodeMot(ch,ch.length-1,valueBuilder);
         return valueBuilder.toString();
    }
    private void encodeMot(char[] ch,int position,StringBuilder valueBuilder) throws DictionnaireException {
        if (  position >= 1 ) {
            encodeMot(ch,position -1,valueBuilder);
            valueBuilder.append(EncodeUnMot.TEMPS_ENTRE_DEUX_LETTRES);
        }

        valueBuilder.append(getCodeCaractereValue(ch[position])) ;

    }
}

package org.stephane.kata.morse.encoder;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.stephane.kata.morse.exceptions.DictionnaireException;

@Slf4j
public class EncodeDuText extends EncodeUnMot {
    public static final String TEMPS_ENTRE_DEUX_LETTRES = StringUtils.SPACE;

    public String getCodeTextValue(String text) throws DictionnaireException {
        log.debug("encode le text: {}",text);
        String[] words = text.split("\\s+");
        StringBuilder valueBuilder = new StringBuilder();
        for (String mot:words){
            valueBuilder.append(getCodeMotValue(mot));
        }
         return valueBuilder.toString();
    }
    /*private void encodeMot(char[] ch,int position,StringBuilder valueBuilder) throws DictionnaireException {
        if (  position >= 1 ) {
            encodeMot(ch,position -1,valueBuilder);
            valueBuilder.append(EncodeDuText.TEMPS_ENTRE_DEUX_LETTRES);
        }
        valueBuilder.append(getCodeCaractereValue(ch[position])) ;
    }*/
}

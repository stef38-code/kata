package org.stephane.kata.morse;

import lombok.extern.slf4j.Slf4j;
import org.stephane.kata.morse.encoder.DecodeDuText;
import org.stephane.kata.morse.encoder.EncodeDuText;
import org.stephane.kata.morse.exceptions.DictionnaireException;

@Slf4j
public class CodeInternational {
    private final EncodeDuText encode = new EncodeDuText();
    private final DecodeDuText decode = new DecodeDuText();


    public String toMorse(String text) throws DictionnaireException {
        return encode.getCodeDuText(text);
    }


    public String toText(String code) throws DictionnaireException {
        return encode.getDecodeDuText(code);
    }
}

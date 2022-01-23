package org.stephane.kata.morse;

import lombok.extern.slf4j.Slf4j;
import org.stephane.kata.morse.encoder.EncodeUnMot;
import org.stephane.kata.morse.exceptions.DictionnaireException;

@Slf4j
public class CodeInternational {
    private final EncodeUnMot encodeUnMot = new EncodeUnMot();


    public String toMorse(String text) throws DictionnaireException {
        return encodeUnMot.getCodeMotValue(text);
    }




}

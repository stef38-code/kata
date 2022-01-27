package org.stephane.kata.morse;

import lombok.extern.slf4j.Slf4j;
import org.stephane.kata.morse.business.DuText;
import org.stephane.kata.morse.exceptions.DictionnaireException;

@Slf4j
public class CodeInternational {
    private final DuText text = new DuText();

    public String toMorse(String text) throws DictionnaireException {
        return this.text.getCodeDuText(text);
    }


    public String toText(String code) throws DictionnaireException {
        return text.getDecodeDuText(code);
    }
}

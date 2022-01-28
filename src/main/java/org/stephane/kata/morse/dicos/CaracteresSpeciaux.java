package org.stephane.kata.morse.dicos;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CaracteresSpeciaux extends Dictionnaire {
     public CaracteresSpeciaux() {
        initDico();
    }
@Override
    protected void initDico() {
       addCode(".", ".-.-.-");
       addCode(",", "--..--");
       addCode("?", "..--..");
       addCode("'", ".----.");
       addCode("!", "-.-.--");
       addCode("/", "-..-.");
       addCode("(", "-.--.");
       addCode(")", "-.--.-");
       addCode("&", ".-...");
       addCode(":", "---...");
       addCode(";", "-.-.-.");
       addCode("=", "-...-");
       addCode("+", ".-.-.");
       addCode("-", "-....-");
       addCode("_", "..--.-");
       addCode("\"", ".-..-.");
       addCode("$", "...-..-");
       addCode("@", ".--.-.");
    }

}

package org.stephane.kata.morse;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.stephane.kata.morse.exceptions.DictionnaireException;

import static org.assertj.core.api.BDDAssertions.then;

class MotTest {
    private CodeInternational codeInternational;

    @BeforeEach
    void setUp() {
        codeInternational = new CodeInternational();
    }

    @ParameterizedTest
    @CsvSource({
            "Lapin,.-.. .- .--. .. -.",
            "barbecue,-... .- .-. -... . -.-. ..- .",
            "déjeuner,-.. . .--- . ..- -. . .-.",
            "20220128,..--- ----- ..--- ..--- ----- .---- ..--- ---.."
    })
    void encode_decode_unMot(String text, String resulatCodeMorse) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(text);
        String mot = codeInternational.toText(resulatCodeMorse);
        //Vérifier la sortie (then)

        then(codeMorse).isNotEmpty().hasToString(resulatCodeMorse);
        then(mot).isNotEmpty().isEqualToIgnoringCase(StringUtils.stripAccents(text));
    }
    @ParameterizedTest
    @CsvSource({
            "Lapin,.-.. .- .--. .. -.",
            "barbecue,-... .- .-. -... . -.-. ..- .",
            "déjeuner,-.. . .--- . ..- -. . .-.",
            "20220128,..--- ----- ..--- ..--- ----- .---- ..--- ---.."
    })
    @Test
    void encode_unMot() throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String text = "lapin";
        String codeMorse = codeInternational.toMorse(text);
        String resulatCodeMorse = ".-.. .- .--. .. -.";
        //Vérifier la sortie (then)

        then(codeMorse).isNotEmpty().hasToString(resulatCodeMorse);
    }
    @Test
    void decode_unMot() throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String text = "lapin";
        String resulatCodeMorse = ".-.. .- .--. .. -.";
        String mot = codeInternational.toText(resulatCodeMorse);
        //Vérifier la sortie (then)

        then(mot).isNotEmpty().isEqualToIgnoringCase(text);
    }
}

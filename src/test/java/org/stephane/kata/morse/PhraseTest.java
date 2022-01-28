package org.stephane.kata.morse;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.stephane.kata.morse.exceptions.DictionnaireException;

import static org.assertj.core.api.BDDAssertions.then;

class PhraseTest {
    private CodeInternational codeInternational;

    @BeforeEach
    void setUp() {
        codeInternational = new CodeInternational();
    }

    @ParameterizedTest
    @CsvSource({
            "Au revoir,.- ..- ....... .-. . ...- --- .. .-.",
            "Au secours,.- ..- ....... ... . -.-. --- ..- .-. ...",
            "Comment ça va ?,-.-. --- -- -- . -. - ....... -.-. .- ....... ...- .- ....... ..--.."
    })
    void encode_decode_unePhrase(String text, String resulatCodeMorse) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(text);
        String phrase = codeInternational.toText(resulatCodeMorse);
        //Vérifier la sortie (then)

        then(codeMorse).isNotEmpty().hasToString(resulatCodeMorse);
        then(phrase).isNotEmpty().isEqualToIgnoringCase(StringUtils.stripAccents(text));
    }
}

package org.stephane.kata.morse;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.stephane.kata.morse.exceptions.DictionnaireException;

import static org.assertj.core.api.BDDAssertions.then;

class TexteTest {
    private CodeInternational codeInternational;

    @BeforeEach
    void setUp() {
        codeInternational = new CodeInternational();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Une orange sur la table Ta robe sur le tapis Et toi dans mon lit Doux présent du présent Fraîcheur de la nuit Chaleur de ma vie.@@..- -. . ....... --- .-. .- -. --. . ....... ... ..- .-. ....... .-.. .- ....... - .- -... .-.. . ....... - .- ....... .-. --- -... . ....... ... ..- .-. ....... .-.. . ....... - .- .--. .. ... ....... . - ....... - --- .. ....... -.. .- -. ... ....... -- --- -. ....... .-.. .. - ....... -.. --- ..- -..- ....... .--. .-. . ... . -. - ....... -.. ..- ....... .--. .-. . ... . -. - ....... ..-. .-. .- .. -.-. .... . ..- .-. ....... -.. . ....... .-.. .- ....... -. ..- .. - ....... -.-. .... .- .-.. . ..- .-. ....... -.. . ....... -- .- ....... ...- .. . .-.-.-",
    },delimiterString = "@@")
    void encode_decode_duText(String text, String resulatCodeMorse) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(text);
        String textValue = codeInternational.toText(resulatCodeMorse);
        //Vérifier la sortie (then)

        then(codeMorse).isNotEmpty().hasToString(resulatCodeMorse);
        then(textValue).isNotEmpty().isEqualToIgnoringCase(StringUtils.stripAccents(text));
    }
}

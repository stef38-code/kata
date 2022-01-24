package org.stephane.kata.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.stephane.kata.morse.exceptions.DictionnaireException;

import static org.assertj.core.api.BDDAssertions.then;

class EncodeTexteTest {
    private CodeInternational codeInternational;

    @BeforeEach
    void setUp() {
        codeInternational = new CodeInternational();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Une orange sur la table Ta robe sur le tapis Et toi dans mon lit Doux présent du présent Fraîcheur de la nuit Chaleur de ma vie.@@..- -. . ....... --- .-. .- -. --. . ....... ... ..- .-. ....... .-.. .- ....... - .- -... .-.. . ....... - .- ....... .-. --- -... . ....... ... ..- .-. ....... .-.. . ....... - .- .--. .. ... ....... . - ....... - --- .. ....... -.. .- -. ... ....... -- --- -. ....... .-.. .. - ....... -.. --- ..- -..- ....... .--. .-. . ... . -. - ....... -.. ..- ....... .--. .-. . ... . -. - ....... ..-. .-. .- .. -.-. .... . ..- .-. ....... -.. . ....... .-.. .- ....... -. ..- .. - ....... -.-. .... .- .-.. . ..- .-. ....... -.. . ....... -- .- ....... ...- .. . .-.-.-",
    },delimiterString = "@@")
    void toMorse_Lorsque_UnePhrase_Attend_PhraseCodeEnMorses(String text, String resulatCodeMorse) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(text);
        //Vérifier la sortie (then)

        then(codeMorse).isNotEmpty().hasToString(resulatCodeMorse);
    }
}

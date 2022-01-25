package org.stephane.kata.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.stephane.kata.morse.exceptions.DictionnaireException;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class EncodeLettreTest {

    private CodeInternational codeInternational;

    private static Stream<Arguments> toMorseEttoText_Lorsque_LettreAlphaB_Attend_CodeMorse() {
        return Stream.of(arguments("A", ".-"),
                arguments("B", "-..."),
                arguments("C", "-.-."),
                arguments("D", "-.."),
                arguments("E", "."),
                arguments("F", "..-."),
                arguments("G", "--."),
                arguments("H", "...."),
                arguments("I", ".."),
                arguments("J", ".---"),
                arguments("K", "-.-"),
                arguments("L", ".-.."),
                arguments("M", "--"),
                arguments("N", "-."),
                arguments("O", "---"),
                arguments("P", ".--."),
                arguments("Q", "--.-"),
                arguments("R", ".-."),
                arguments("S", "..."),
                arguments("T", "-"),
                arguments("U", "..-"),
                arguments("V", "...-"),
                arguments("W", ".--"),
                arguments("X", "-..-"),
                arguments("Y", "-.--"),
                arguments("Z", "--..")
        );
    }

    @BeforeEach
    void setUp() {
        codeInternational = new CodeInternational();
    }

    @ParameterizedTest
    @CsvSource({"A, .-", "a, .-", "C,-.-.", "S, ...", "Z,--.."})
    void toMorse_Lorsque_Lettre_Attend_CodeMorse(String lettre, String code) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(lettre);
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(code);
    }

    @ParameterizedTest
    @MethodSource
    void toMorseEttoText_Lorsque_LettreAlphaB_Attend_CodeMorse(String lettre, String code) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(lettre);
        String caractere = codeInternational.toText(code);
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(code);
        then(caractere).isNotNull().isEqualToIgnoringCase(lettre);
    }
    @ParameterizedTest
    @CsvSource({"A, .-", "a, .-", "C,-.-.", "S, ...", "Z,--.."})
    void toText_Lorsque_CodeMorse_Attend_Lettre(String lettre, String code) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toText(code);
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().isEqualToIgnoringCase(lettre);
    }

}

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


class EncodeChiffreTest {

    private CodeInternational codeInternational;

    private static Stream<Arguments> toMorse_Lorsque_TousLesChiffres_Attend_CodeMorse() {
        return Stream.of(
                arguments("1", ".----"),
                arguments("2", "..---"),
                arguments("3", "..--"),
                arguments("4", "....-"),
                arguments("5", "....."),
                arguments("6", "-...."),
                arguments("7", "- -..."),
                arguments("8", "---.."),
                arguments("9", "----.")
        );
    }

    @BeforeEach
    void setUp() {
        codeInternational = new CodeInternational();
    }

    @ParameterizedTest
    @CsvSource({
            "0,-----",
            "2,..---",
            "5,....."
    })
    void toMorse_Lorsque_Chiffres_Attend_CodeMorse(String chiffre, String code) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(chiffre);
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(code);
    }

    @ParameterizedTest
    @MethodSource
    void toMorse_Lorsque_TousLesChiffres_Attend_CodeMorse(String chiffre, String code) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(chiffre);
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(code);
    }

}

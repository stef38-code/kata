package org.stephane.kata.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stephane.kata.morse.exceptions.DictionnaireException;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class ChiffreTest {

    private CodeInternational codeInternational;

    private static Stream<Arguments> encode_decode_unChiffre() {
        return Stream.of(
                arguments("0", "-----"),
                arguments("1", ".----"),
                arguments("2", "..---"),
                arguments("3", "..--"),
                arguments("4", "....-"),
                arguments("5", "....."),
                arguments("6", "-...."),
                arguments("7", "--..."),
                arguments("8", "---.."),
                arguments("9", "----.")
        );
    }

    @BeforeEach
    void setUp() {
        codeInternational = new CodeInternational();
    }
    @ParameterizedTest
    @MethodSource
    void encode_decode_unChiffre(String chiffre, String code) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(chiffre);
        String caractere = codeInternational.toText(code);
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(code);
        then(caractere).isNotNull().isEqualToIgnoringCase(chiffre);
    }

}

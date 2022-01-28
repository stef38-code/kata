package org.stephane.kata.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stephane.kata.morse.exceptions.DictionnaireException;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class CaracteresSpeciauxTest {

    private CodeInternational codeInternational;

    private static Stream<Arguments> encode_decode_unCaracteresSpeciaux() {
        return Stream.of(
                arguments(".", ".-.-.-"),
                arguments(",", "--..--"),
                arguments("?", "..--.."),
                arguments("'", ".----."),
                arguments("!", "-.-.--"),
                arguments("/", "-..-."),
                arguments("(", "-.--."),
                arguments(")", "-.--.-"),
                arguments("&", ".-..."),
                arguments(":", "---..."),
                arguments(";", "-.-.-."),
                arguments("=", "-...-"),
                arguments("+", ".-.-."),
                arguments("-", "-....-"),
                arguments("_", "..--.-"),
                arguments("\"", ".-..-."),
                arguments("$", "...-..-"),
                arguments("@", ".--.-.")
        );
    }

    @BeforeEach
    void setUp() {
        codeInternational = new CodeInternational();
    }



    @ParameterizedTest
    @MethodSource
    void encode_decode_unCaracteresSpeciaux(String caractereSpec, String code) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(caractereSpec);
        String caractere = codeInternational.toText(code);
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(code);
        then(caractere).isNotNull().isEqualToIgnoringCase(caractereSpec);
    }


}

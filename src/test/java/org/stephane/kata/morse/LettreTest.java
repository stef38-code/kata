package org.stephane.kata.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stephane.kata.morse.exceptions.DictionnaireException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class LettreTest {

    private CodeInternational codeInternational;

    private static Stream<Arguments> encode_decode_uneLettre() {
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
    @MethodSource
    void encode_decode_uneLettre(String lettre, String code) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(lettre);
        String caractere = codeInternational.toText(code);
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(code);
        then(caractere).isNotNull().isEqualToIgnoringCase(lettre);
    }

    @Test
    void decode_Lorsque_paramNull_Attend_DictionnaireException() {
        //Conditions préalables (given)

        //Une action se produit (when)
        thenThrownBy(()->codeInternational.toText(null))
                .isInstanceOf(DictionnaireException.class)
                        .hasMessage("Le code morse ne peut pas être null");
        //Vérifier la sortie (then)
    }
    @Test
    void encode_Lorsque_paramNull_Attend_DictionnaireException() {
        //Conditions préalables (given)

        //Une action se produit (when)
        thenThrownBy(()->codeInternational.toMorse(null))
                .isInstanceOf(DictionnaireException.class)
                .hasMessage("Le texte ne peut pas être null");
        //Vérifier la sortie (then)
    }
}

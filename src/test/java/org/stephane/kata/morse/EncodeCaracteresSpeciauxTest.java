package org.stephane.kata.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.stephane.kata.morse.exceptions.DictionnaireException;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class EncodeCaracteresSpeciauxTest {

    private CodeInternational codeInternational;

    private static Stream<Arguments> toMorse_Lorsque_TousCaracteresSpeciaux_Attend_CodeMorse() {
        return Stream.of(
                arguments("1", ".----"),
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
    @CsvSource({
            "+,.-.-.",
            "/,-..-.",
            "@,.--.-."
    })
    void toMorse_Lorsque_CaracteresSpeciaux_Attend_CodeMorse(String chiffre, String code) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(chiffre);
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(code);
    }

    @ParameterizedTest
    @MethodSource
    void toMorse_Lorsque_TousCaracteresSpeciaux_Attend_CodeMorse(String chiffre, String code) throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(chiffre);
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(code);
    }
    @Test
    void toMorse_Lorsque_CaracteresSpeciaux_Attend_Exception() throws DictionnaireException {
        //Conditions préalables (given)
        //Une action se produit (when)
        thenThrownBy(() -> codeInternational.toMorse("#"))
                .isInstanceOf(DictionnaireException.class)
                        .hasMessageContaining("n'existe pas dans le dictionnaire des codes morse !!");
    }
}

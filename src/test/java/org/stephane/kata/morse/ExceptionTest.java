package org.stephane.kata.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stephane.kata.morse.exceptions.DictionnaireException;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;

/**
 * Test les exceptions si un caractere inconnu ou bien un code inconnu
 */
public class ExceptionTest {
    private CodeInternational codeInternational;
    @BeforeEach
    void setUp() {
        codeInternational = new CodeInternational();
    }
    @Test
    void toMorse_Lorsque_CaracteresSpeciaux_Attend_Exception() {
        //Conditions préalables (given)
        //Une action se produit (when)
        thenThrownBy(() -> codeInternational.toMorse("#"))
                .isInstanceOf(DictionnaireException.class)
                .hasMessageContaining("n'existe pas dans le dictionnaire des codes morse !!");
    }

    @Test
    void toText_Lorsque_CodeBidon_Attend_Exception() {
        //Conditions préalables (given)
        //Une action se produit (when)
        thenThrownBy(() -> codeInternational.toText("......---"))
                .isInstanceOf(DictionnaireException.class)
                .hasMessageContaining("n'existe pas dans le dictionnaire des codes morse !!");
    }
}

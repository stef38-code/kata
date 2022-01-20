package org.stephane.kata.morse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;


public class EncodeLettreTest {

    @ParameterizedTest
    @CsvSource({ "1, 100", "2, 200", "3, 300" })
    void toMorse_Lorsque_Lettre_Attend_CodeMorse(String lettre, String code) {

    }


    @Test
    void toMorse_Lorsque_A_Attend_CodeMorse() {
        //Conditions préalables (given)
        CodeInternational codeInternational = new CodeInternational();
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse("A");
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(".-");
    }
    @Test
    void toMorse_Lorsque_a_Attend_CodeMorse() {
        //Conditions préalables (given)
        CodeInternational codeInternational = new CodeInternational();
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse("A");
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString(".-");
    }
    @Test
    void toMorse_Lorsque_S_Attend_CodeMorse() {
        //Conditions préalables (given)
        CodeInternational codeInternational = new CodeInternational();
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse("S");
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString("...");
    }

    @Test
    void toMorse_Lorsque_Z_Attend_CodeMorse() {
        //Conditions préalables (given)
        CodeInternational codeInternational = new CodeInternational();
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse("Z");
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString("--..");
    }
    @Test
    void toMorse_Lorsque_C_Attend_CodeMorse() {
        //Conditions préalables (given)
        CodeInternational codeInternational = new CodeInternational();
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse("C");
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString("-.-.");
    }
}

package org.stephane.kata.morse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class EncodeLettreTest {
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
    void toMorse_Lorsque_Z_Attend_CodeMorse() {
        //Conditions préalables (given)
        CodeInternational codeInternational = new CodeInternational();
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse("Z");
        //Vérifier la sortie (then)
        then(codeMorse).isNotNull().hasToString("--..");
    }

}

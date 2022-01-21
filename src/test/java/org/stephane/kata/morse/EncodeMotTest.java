package org.stephane.kata.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.BDDAssertions.then;

class EncodeMotTest {
    private CodeInternational codeInternational;

    @BeforeEach
    void setUp() {
        codeInternational = new CodeInternational();
    }

    @ParameterizedTest
    @CsvSource({
            "Lapin,.-.. .- .--. .. -.",
            "barbecue,-... .- .-. -... . -.-. ..- .",
            "déjeuner,-.. . .--- . ..- -. . .-.",
            "20220128,..--- ----- ..--- ..--- ----- .---- ..--- ---.."
    })
    void toMorse_Lorsque_UnMot_Attend_MotCodeEnMorses(String text, String resulatCodeMorse) {
        //Conditions préalables (given)
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(text);
        //Vérifier la sortie (then)
        then(codeMorse).isNotEmpty().hasToString(resulatCodeMorse);
    }

    @Test
    void toMorse_Lorsque_UnMot_CaracteresSpeciaux_Attend_MotCodeEnMorses() {
        //Conditions préalables (given)
        String text = ",;:";
        String resulatCodeMorse = "--..-- -.-.-. ---...";
        //Une action se produit (when)
        String codeMorse = codeInternational.toMorse(text);
        //Vérifier la sortie (then)
        then(codeMorse).isNotEmpty().hasToString(resulatCodeMorse);
    }
}

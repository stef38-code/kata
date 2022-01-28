package org.stephane.kata.morse.register;

import org.stephane.kata.morse.dicos.CaracteresSpeciaux;
import org.stephane.kata.morse.dicos.Chiffre;
import org.stephane.kata.morse.dicos.Dictionnaire;
import org.stephane.kata.morse.dicos.Lettre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Registre des dictionnaires de correspondances caractere/Morse
 */
public class DictionnaireFactoryRegister implements DictionnaireFactory {
    List<Dictionnaire> dicos = new ArrayList<>();

    public DictionnaireFactoryRegister() {
        addDictionnaire(new Lettre());
        addDictionnaire(new Chiffre());
        addDictionnaire(new CaracteresSpeciaux());
    }

    /**
     * Donne le code morse en fonction du caractere donné
     * @param caractere le caractere
     * @return le caractere si trouvé, sinon Optional.empty()
     */
    @Override
    public Optional<String> getMorseCode(String caractere) {
        for (Dictionnaire dico : dicos) {
            Optional<String> codeMorse = dico.getMorseCode(caractere);
            if (codeMorse.isPresent()) return codeMorse;
        }
        return Optional.empty();
    }

    /**
     * Ajout d'un dico dans le registre
     * @param dico le dico nouveau dico
     */
    @Override
    public void addDictionnaire(Dictionnaire dico) {
        dicos.add(dico);
    }

    /**
     * Donne le caractere en fonction du code morse donné
     * @param codeMorseDuCaractere le code morse d'un caractere
     * @return le code morse si trouvé, sinon Optional.empty()
     */
    @Override
    public Optional<String> getDecode(String codeMorseDuCaractere) {
        for (Dictionnaire dico : dicos) {
            Optional<String> caractere = dico.getCaractere(codeMorseDuCaractere);
            if (caractere.isPresent()) return caractere;
        }
        return Optional.empty();
    }
}

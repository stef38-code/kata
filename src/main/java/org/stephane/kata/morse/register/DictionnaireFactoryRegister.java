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

    @Override
    public Optional<String> getMorseCode(String caractere) {
        for (Dictionnaire dico : dicos) {
            Optional<String> codeMorse = dico.getMorseCode(caractere);
            if (codeMorse.isPresent()) return codeMorse;
        }
        return Optional.empty();
    }

    @Override
    public void addDictionnaire(Dictionnaire dico) {
        dicos.add(dico);
    }

    @Override
    public Optional<String> getDecode(String codeUnCaractere) {
        for (Dictionnaire dico : dicos) {
            Optional<String> caractere = dico.getCaractere(codeUnCaractere);
            if (caractere.isPresent()) return caractere;
        }
        return Optional.empty();
    }
}

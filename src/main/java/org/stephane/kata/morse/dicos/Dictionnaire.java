package org.stephane.kata.morse.dicos;

import java.util.Optional;

public interface Dictionnaire {
    Optional<String> getMorseCode(String caractere);
}

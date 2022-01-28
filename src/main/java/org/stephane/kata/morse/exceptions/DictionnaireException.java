package org.stephane.kata.morse.exceptions;

/**
 * Exception dans le cas d'un caractère inconnu
 */
public class DictionnaireException extends Exception {
    public DictionnaireException(String message) {
        super(message);
    }
}

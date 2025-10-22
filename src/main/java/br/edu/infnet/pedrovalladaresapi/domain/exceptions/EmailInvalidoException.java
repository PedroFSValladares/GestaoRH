package br.edu.infnet.pedrovalladaresapi.domain.exceptions;

public class EmailInvalidoException extends RuntimeException {
    public EmailInvalidoException(String message) {
        super(message);
    }
}

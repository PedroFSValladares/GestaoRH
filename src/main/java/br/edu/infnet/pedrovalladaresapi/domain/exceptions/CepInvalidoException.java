package br.edu.infnet.pedrovalladaresapi.domain.exceptions;

public class CepInvalidoException extends RuntimeException {
    public CepInvalidoException(String message) {
        super(message);
    }
}

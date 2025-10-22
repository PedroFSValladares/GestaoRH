package br.edu.infnet.pedrovalladaresapi.domain.exceptions;

public class CpfInvalidoException extends RuntimeException{
    public CpfInvalidoException(String mensagem){
        super(mensagem);
    }
}

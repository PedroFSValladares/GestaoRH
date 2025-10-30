package br.edu.infnet.pedrovalladaresapi.domain.models;


import br.edu.infnet.pedrovalladaresapi.exceptions.CepInvalidoException;
import jakarta.persistence.Id;

public class Endereco {
    @Id
    private String CEP;
    private String Logradouro;
    private String Complemento;
    private String Bairro;
    private String UF;

    @Override
    public String toString(){
        return String.format("CEP: %s | Logradouro: %s | Complemento: %s | Bairro: %s | UF: %s",
                CEP, Logradouro, Complemento, Bairro, UF);
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.Logradouro = logradouro;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
}

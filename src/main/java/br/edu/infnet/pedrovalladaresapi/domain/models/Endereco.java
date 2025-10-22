package br.edu.infnet.pedrovalladaresapi.domain.models;


import br.edu.infnet.pedrovalladaresapi.domain.exceptions.CepInvalidoException;

public class Endereco {
    private String CEP;
    private String Logradouro;
    private String Complemento;
    private String Bairro;
    private String UF;

    @Override
    public String toString(){
        return String.format("CEP: %s\nLogradouro: %s\nComplemento: %s\nBairro: %s\nUF: %s",
                CEP, Logradouro, Complemento, Bairro, UF);
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        if(CEP.isEmpty())
            throw new IllegalArgumentException("O CEP deve ser informado!");
        else if(CEP.length() < 8)
            throw new CepInvalidoException("O CEP informado é inválido");
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) {
        if(logradouro.isEmpty())
            throw new IllegalArgumentException("O logradouro do endereço deve ser informado!");
        this.Logradouro = logradouro;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        if(complemento.isEmpty())
            throw new IllegalArgumentException("O complemento do endereço deve ser informado!");
        Complemento = complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        if(bairro.isEmpty())
            throw new IllegalArgumentException("O bairro do endereço deve ser informado!");
        Bairro = bairro;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        if(UF.isEmpty())
            throw new IllegalArgumentException("A UF do endereço deve ser informado!");
        this.UF = UF;
    }
}

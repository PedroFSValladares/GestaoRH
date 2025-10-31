package br.edu.infnet.pedrovalladaresapi.domain.models;


import br.edu.infnet.pedrovalladaresapi.exceptions.CepInvalidoException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @Column(name = "cep")
    private String CEP;
    @Column(name = "logradouro")
    private String Logradouro;
    @Column(name = "complemento")
    private String Complemento;
    @Column(name = "bairro")
    private String Bairro;
    @Column(name = "uf")
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

package br.edu.infnet.pedrovalladaresapi.model.domain;

public class Pessoa {
    private String Nome;
    private String CPF;
    private String Email;
    private String Telefone;
    private Endereco Endereco;

    @Override
    public String toString(){
        return String.format("Nome: %s\n| CPF: %s\nEmail: %s\nTelefone: %s\nEndereço: %s",
                Nome, CPF, Email, Telefone, Endereco.toString());
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco endereco) {
        Endereco = endereco;
    }
}

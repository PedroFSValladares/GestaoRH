package br.edu.infnet.pedrovalladaresapi.domain.models;

import br.edu.infnet.pedrovalladaresapi.domain.exceptions.CpfInvalidoException;
import br.edu.infnet.pedrovalladaresapi.domain.exceptions.EmailInvalidoException;
import br.edu.infnet.pedrovalladaresapi.domain.objetosDeValor.CPF;

public abstract class Pessoa {
    private String Nome;
    private CPF CPF;
    private String Email;
    private String Telefone;
    private Endereco Endereco;


    private Boolean emailValido(String email){
        return email.matches("^[^@\\s]+@[^@\\s]+(\\.com|\\.com\\.br)$");
    }

    @Override
    public String toString(){
        return String.format("Nome: %s\nCPF: %s\nEmail: %s\nTelefone: %s\n%s",
                Nome, CPF, Email, Telefone, Endereco.toString());
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("O nome da pessoa deve ser informado!");
        Nome = nome;
    }

    public String getCPF() {
        return CPF.getCpf();
    }

    public void setCPF(String cpf) {
        if(cpf.isEmpty())
            throw new IllegalArgumentException("CPF da pessoa deve ser informado!");

        CPF novoCpf = new CPF(cpf);

        if(!novoCpf.valido())
            throw new CpfInvalidoException("O CPF informado não é válido!");
        this.CPF = novoCpf;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        if(email.isEmpty())
            throw new IllegalArgumentException("O Email da pessoa deve ser informado!");
        else if (!emailValido(email))
            throw new EmailInvalidoException("O e-mail informado é inválido!");
        Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone.isEmpty())
            throw new IllegalArgumentException("O Email da pessoa deve ser informado!");

        Telefone = telefone;
    }

    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco endereco) {
        if(endereco == null)
            throw new IllegalArgumentException("Endereço deve ser informado!");
        Endereco = endereco;
    }
}

package br.edu.infnet.pedrovalladaresapi.domain.models;

import br.edu.infnet.pedrovalladaresapi.domain.exceptions.CpfInvalidoException;
import br.edu.infnet.pedrovalladaresapi.domain.exceptions.EmailInvalidoException;

public abstract class Pessoa {
    private String Nome;
    private String CPF;
    private String Email;
    private String Telefone;
    private Endereco Endereco;


    private Boolean cpfValido(String cpf){
        int somatorio = 0,
                primeiroDigitoVerificador,
                segundoDigitoVerificador;
        char[] primeiraSequencia = new char[9],
                segundaSequencia = new char[10];
        String digitosVerificadoresOriginais = cpf.substring(9),
                digitoVerificadorFinal;

        cpf.getChars(0, 8, primeiraSequencia, 0);
        cpf.getChars(0, 8, segundaSequencia, 0);

        for(int i = 0,  multiplicador = 10; i < primeiraSequencia.length; i++, multiplicador--){
            somatorio += (int) primeiraSequencia[i] * multiplicador;
        }

        int restoPrimeiraDivisao = somatorio % 11;
        primeiroDigitoVerificador = restoPrimeiraDivisao < 2 ? 0 : 11 - restoPrimeiraDivisao;

        segundaSequencia[9] = (char) primeiroDigitoVerificador;
        somatorio = 0;

        for(int i = 0,  multiplicador = 11; i < segundaSequencia.length; i++, multiplicador--){
            somatorio += (int) segundaSequencia[i] * multiplicador;
        }

        int restoSegundaDivisao = somatorio % 11;
        segundoDigitoVerificador = 11 - restoSegundaDivisao;

        digitoVerificadorFinal = String.valueOf(primeiroDigitoVerificador) + String.valueOf(segundoDigitoVerificador);

        return digitosVerificadoresOriginais.equals(digitoVerificadorFinal);
    }

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
        return CPF;
    }

    public void setCPF(String CPF) {
        if(CPF.isEmpty())
            throw new IllegalArgumentException("CPF da pessoa deve ser informado!");
        else if(!cpfValido(CPF))
            throw new CpfInvalidoException("O CPF informado não é válido!");
        this.CPF = CPF;
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

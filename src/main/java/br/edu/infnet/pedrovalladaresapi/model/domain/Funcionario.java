package br.edu.infnet.pedrovalladaresapi.model.domain;

public class Funcionario {
    private String Nome;
    private String CPF;
    private String Email;
    private String Matricula;
    private int CargoId;

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

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public int getCargoId() {
        return CargoId;
    }

    public void setCargoId(int cargoId) {
        CargoId = cargoId;
    }
}

package br.edu.infnet.pedrovalladaresapi.model.domain;

public class Funcionario extends Pessoa{

    private String Matricula;
    private Cargo Cargo;

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public Cargo getCargo() {
        return Cargo;
    }

    public void setCargo(Cargo cargo) {
        Cargo = cargo;
    }
}

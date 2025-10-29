package br.edu.infnet.pedrovalladaresapi.domain.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class Funcionario extends Pessoa{
    @NotEmpty(message = "O campo matrícula deve ser informado.")
    private String Matricula;

    //@Embedded
    private Cargo Cargo;
    private Boolean Ativo;

    @Override
    public String toString(){
        return String.format("%s\nMatrícula: %s\nAtivo: %s\n%s",
                super.toString() ,Matricula, Ativo ? "Sim" : "Não", Cargo.toString());
    }

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

    public void setAtivo(Boolean ativo){
        Ativo = ativo;
    }

    public Boolean getAtivo(){
        return Ativo;
    }
}

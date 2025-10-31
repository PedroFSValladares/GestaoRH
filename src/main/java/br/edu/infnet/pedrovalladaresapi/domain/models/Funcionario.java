package br.edu.infnet.pedrovalladaresapi.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Funcionario extends Pessoa{
    @Column(name = "matricula", unique = true)
    @NotEmpty(message = "O campo matrícula deve ser informado.")
    private String Matricula;

    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo Cargo;
    @Column(name = "ativo")
    private Boolean Ativo;

    @Override
    public String toString(){
        return String.format("%s | Matrícula: %s | Ativo: %s | %s",
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

    public Ponto criarPonto(){
        Ponto ponto = new Ponto();
        ponto.getFuncionario().setCPF(this.getCPF());
        ponto.setHorarioPonto(LocalTime.now());
        ponto.setData(LocalDate.now());

        return ponto;
    }
}

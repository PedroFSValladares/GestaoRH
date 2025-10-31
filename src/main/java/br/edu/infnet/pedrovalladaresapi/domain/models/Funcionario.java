package br.edu.infnet.pedrovalladaresapi.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

@Entity
public class Funcionario extends Pessoa{
    @Column(name = "matricula", unique = true)
    @NotEmpty(message = "O campo matrícula deve ser informado.")
    private String Matricula;
    @ManyToOne
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
        ponto.setFuncionario(this);
        ponto.setHorarioPonto(LocalTime.now());
        ponto.setData(LocalDate.now());

        return ponto;
    }

    public String gerarMatricula(){
        Random random = new Random();
        return getCpf().substring(0, 3) + getTelefone().substring(6) + random.nextInt(10);
    }
}

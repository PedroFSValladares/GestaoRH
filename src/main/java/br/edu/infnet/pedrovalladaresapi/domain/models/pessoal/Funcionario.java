package br.edu.infnet.pedrovalladaresapi.domain.models.pessoal;

import br.edu.infnet.pedrovalladaresapi.domain.models.frequencia.Ponto;
import br.edu.infnet.pedrovalladaresapi.domain.models.transporte.Viagem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Entity
public class Funcionario extends Pessoa {
    @Column(name = "matricula", unique = true, length = 8)
    @NotEmpty(message = "O campo matrícula deve ser informado.")
    private String Matricula;
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo Cargo;
    @OneToMany(orphanRemoval = true)
    @JoinTable(
            name = "funcionario_viagens",
            joinColumns = @JoinColumn(name = "cpf"),
            inverseJoinColumns = @JoinColumn(name = "viagem_id")
    )
    private List<Viagem> viagens;
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
        String matricula = getCpf().substring(0, 3) + getTelefone().substring(7) + random.nextInt(10);
        return String.format("%" + 8 + "s", matricula).replace(" ","0");
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }
}

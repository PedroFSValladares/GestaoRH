package br.edu.infnet.pedrovalladaresapi.domain.models;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoPonto;
import br.edu.infnet.pedrovalladaresapi.domain.objetosDeValor.CPF;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "pontos")
public class Ponto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ponto_id")
    private Integer Id;
    @ManyToOne
    @JoinColumn(name = "cpf")
    private Funcionario Funcionario;
    //private CPF cpfFuncionario;
    @Column(name = "data")
    private LocalDate Data;
    @Column(name = "hora")
    private LocalTime HorarioPonto;
    @Column(name = "tipo_ponto")
    private TipoPonto TipoPonto;

    public Funcionario getFuncionario() {
        return Funcionario;
    }

    public void setId(Integer id){
        Id = id;
    }

    public Integer getId(){
        return Id;
    }

    public void setFuncionario(Funcionario funcionario) {
        if (funcionario == null)
            throw new IllegalArgumentException("O funcionário não pode ser nulo!");
        Funcionario = funcionario;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate data) {
        Data = data;
    }

    public LocalTime getHorarioPonto() {
        return HorarioPonto;
    }

    public void setHorarioPonto(LocalTime horarioPonto) {
        HorarioPonto = horarioPonto;
    }

    public TipoPonto getTipoPonto() {
        return TipoPonto;
    }

    public void setTipoPonto(TipoPonto tipoPonto) {
        TipoPonto = tipoPonto;
    }
/*
    public String getCpfFuncionario() {
        return cpfFuncionario.getCpf();
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = new CPF(cpfFuncionario);
    }

 */
}

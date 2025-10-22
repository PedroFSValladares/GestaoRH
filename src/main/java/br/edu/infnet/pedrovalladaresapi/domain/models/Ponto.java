package br.edu.infnet.pedrovalladaresapi.domain.models;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoPonto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ponto {
    private Integer Id;
    private Funcionario Funcionario;
    private LocalDate Data;
    private LocalTime HorarioPonto;
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
}

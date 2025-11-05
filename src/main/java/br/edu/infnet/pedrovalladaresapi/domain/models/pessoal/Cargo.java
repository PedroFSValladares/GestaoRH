package br.edu.infnet.pedrovalladaresapi.domain.models.pessoal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cargo_id")
    private int Id;
    @Column(name = "nome_cargo")
    @NotEmpty(message = "O Campo nome deve ser informado.")
    private String Nome;
    @Column(name = "remuneracao")
    @NotNull(message = "O campo Remuneração deve ser informado.")
    @Positive(message = "A remuneração deve ser maior que 0.")
    private Double Remuneracao;
    @Column(name = "v_vale_alimentacao")
    @NotNull(message = "O campo Vale alimentação deve ser informado.")
    @PositiveOrZero(message = "O vale alimentação não pode ser negativo.")
    private Double ValeAlimentacao;
    @Column(name = "v_vale_transporte")
    @NotNull(message = "O campo Vale transporte deve ser informado.")
    @PositiveOrZero(message = "O vale transporte não pode ser negativo.")
    private Double ValeTransporte;
    @Column(name = "adicional_periculosidade")
    @NotNull(message = "O campo adicional de periculosidade deve ser informado.")
    private Boolean AdicionalDePericulosidade;
    @Column(name = "adcional_insalubridade")
    @NotNull(message = "O campo adicional de insalubridade deve ser informado.")
    private Boolean AdicionalDeInsalubridade;
    @Column(name = "carga_horaria")
    @NotNull(message = "O campo carga horária deve ser informado.")
    @Positive(message = "A carga horária deve ser maior que 0.")
    private Integer CargaHoraria;
    @Column(name = "ativo")
    private Boolean Ativo;

    @Override
    public String toString(){
        return String.format("Cargo: %s | Id: %d | Carga Horária: %d | Remuneração: %.2f | Vale Alimentação: %.2f | Vale Transporte: %.2f | Periculosidade: %s | Insalubridade: %s",
                Nome, Id, CargaHoraria, Remuneracao, ValeAlimentacao, ValeTransporte,
                AdicionalDePericulosidade ? "Sim" : "Não", AdicionalDeInsalubridade ? "Sim" : "Não");
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Double getRemuneracao() {
        return Remuneracao;
    }

    public void setRemuneracao(Double remuneracao) {
        Remuneracao = remuneracao;
    }

    public Double getValeAlimentacao() {
        return ValeAlimentacao;
    }

    public void setValeAlimentacao(Double valeAlimentacao) {
        ValeAlimentacao = valeAlimentacao;
    }

    public Double getValeTransporte() {
        return ValeTransporte;
    }

    public void setValeTransporte(Double valeTransporte) {
        ValeTransporte = valeTransporte;
    }

    public Boolean getAdicionalDePericulosidade() {
        return AdicionalDePericulosidade;
    }

    public void setAdicionalDePericulosidade(Boolean adicionalDePericulosidade) {
        AdicionalDePericulosidade = adicionalDePericulosidade;
    }

    public Boolean getAdicionalDeInsalubridade() {
        return AdicionalDeInsalubridade;
    }

    public void setAdicionalDeInsalubridade(Boolean adicionalDeInsalubridade) {
        AdicionalDeInsalubridade = adicionalDeInsalubridade;
    }

    public Integer getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

    public Boolean getAtivo() {
        return Ativo;
    }

    public void setAtivo(Boolean ativo) {
        Ativo = ativo;
    }
}

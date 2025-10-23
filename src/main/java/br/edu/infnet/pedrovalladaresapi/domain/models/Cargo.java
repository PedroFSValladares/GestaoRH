package br.edu.infnet.pedrovalladaresapi.domain.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Embeddable
public class Cargo {
    @Id
    private int Id;
    private String Nome;
    private Double Remuneracao;
    private Double ValeAlimentacao;
    private Double ValeTransporte;
    private Boolean AdicionalDePericulosidade;
    private Boolean AdicionalDeInsalubridade;
    private Integer CargaHoraria;

    @Override
    public String toString(){
        return String.format("Nome: %s\nCarga Horária: %d\nRemuneração: %.2f\nVale Alimentação: %.2f\nVale Transporte: %.2f\nPericulosidade: %s\nInsalubridade: %s",
                Nome, CargaHoraria, Remuneracao, ValeAlimentacao, ValeTransporte,
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
        if (remuneracao == null || remuneracao <= 0)
            throw new IllegalArgumentException("Valor de remuneração informado inválido!");
        Remuneracao = remuneracao;
    }

    public Double getValeAlimentacao() {
        return ValeAlimentacao;
    }

    public void setValeAlimentacao(Double valeAlimentacao) {
        if (valeAlimentacao == null || valeAlimentacao <= 0)
            throw new IllegalArgumentException("Valor do vale alimentação informado inválido!");
        ValeAlimentacao = valeAlimentacao;
    }

    public Double getValeTransporte() {
        return ValeTransporte;
    }

    public void setValeTransporte(Double valeTransporte) {
        if (valeTransporte == null || valeTransporte <= 0)
            throw new IllegalArgumentException("Valor do vale transporte informado inválido!");
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
        if (cargaHoraria == null || cargaHoraria <= 0)
            throw new IllegalArgumentException("Carga horária informada inválida!");
        CargaHoraria = cargaHoraria;
    }
}

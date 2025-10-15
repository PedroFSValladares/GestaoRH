package br.edu.infnet.pedrovalladaresapi.model.domain;

public class Cargo {
    private int Id;
    private String Nome;
    private Double Remuneracao;
    private Double ValeAlimentacao;
    private Double ValeTransporte;
    private Boolean AdicionalDePericulosidade;
    private Boolean AdicionalDeInsalubridade;

    @Override
    public String toString(){
        return String.format("Nome: %s\nRemuneração: %.2f\nVale Alimentação: %.2f\nVale Transporte: %.2f\nPericulosidade: %s\nInsalubridade: %s",
                Nome, Remuneracao, ValeAlimentacao, ValeTransporte,
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
}

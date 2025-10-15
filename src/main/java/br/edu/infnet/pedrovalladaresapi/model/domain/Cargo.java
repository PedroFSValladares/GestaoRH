package br.edu.infnet.pedrovalladaresapi.model.domain;

public class Cargo {
    private int Id;
    private String Nome;
    private Double Remuneracao;

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
}

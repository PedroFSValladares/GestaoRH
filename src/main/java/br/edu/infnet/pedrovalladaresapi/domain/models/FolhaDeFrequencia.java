package br.edu.infnet.pedrovalladaresapi.domain.models;

import java.util.List;

public class FolhaDeFrequencia {
    private Funcionario funcionario;
    private List<DiaUtil> diasFrequentados;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<DiaUtil> getDiasFrequentados() {
        return diasFrequentados;
    }

    public void setDiasFrequentados(List<DiaUtil> diasFrequentados) {
        this.diasFrequentados = diasFrequentados;
    }
}

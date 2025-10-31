package br.edu.infnet.pedrovalladaresapi.domain.factories;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoPonto;
import br.edu.infnet.pedrovalladaresapi.domain.models.DiaUtil;
import br.edu.infnet.pedrovalladaresapi.domain.models.FolhaDeFrequencia;
import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.models.Ponto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FolhaDeFrequenciaFactory {
    public static FolhaDeFrequencia gerarFolhaDeFrequencia(Funcionario funcionario, List<Ponto> pontos){
        FolhaDeFrequencia folhaDeFrequencia = new FolhaDeFrequencia();
        Map<LocalDate, DiaUtil> entradas = new HashMap<>();
        Map<LocalDate, DiaUtil> saidas = new HashMap<>();

        pontos.forEach(ponto -> {

            DiaUtil diaUtil = new DiaUtil();
            diaUtil.setData(ponto.getData());

            if (ponto.getTipoPonto().equals(TipoPonto.Entrada)){
                diaUtil.setEntrada(ponto.getHorarioPonto());
                entradas.put(diaUtil.getData(), diaUtil);
            }

            if (ponto.getTipoPonto().equals(TipoPonto.Saida)){
                diaUtil.setSaida(ponto.getHorarioPonto());
                saidas.put(diaUtil.getData(), diaUtil);
            }
        });

        entradas.forEach((localDate, diaUtil) -> {
            var diaSaida = saidas.get(localDate);
            diaUtil.setSaida(diaSaida.getSaida());
        });

        folhaDeFrequencia.setDiasFrequentados(new ArrayList<>(entradas.values()));
        folhaDeFrequencia.setFuncionario(funcionario);

        return folhaDeFrequencia;
    }
}

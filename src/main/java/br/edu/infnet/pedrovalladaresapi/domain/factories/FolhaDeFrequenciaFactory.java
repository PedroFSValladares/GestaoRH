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
        Map<LocalDate, DiaUtil> mapa = new HashMap<>();

        pontos.forEach(ponto -> {
            if (!mapa.containsKey(ponto.getData())){
                DiaUtil diaUtil = new DiaUtil();
                diaUtil.setData(ponto.getData());
                mapa.put(ponto.getData(), diaUtil);
            } else if (ponto.getTipoPonto() == TipoPonto.Entrada) {
                var diaUtil = mapa.get(ponto.getData());
                diaUtil.setEntrada(ponto.getHorarioPonto());
                mapa.replace(ponto.getData(), diaUtil);
            } else if (ponto.getTipoPonto() == TipoPonto.Saida) {
                var diaUtil = mapa.get(ponto.getData());
                diaUtil.setSaida(ponto.getHorarioPonto());
                mapa.replace(ponto.getData(), diaUtil);
            }
        });
        folhaDeFrequencia.setDiasFrequentados(new ArrayList<>(mapa.values()));
        folhaDeFrequencia.setFuncionario(funcionario);

        return folhaDeFrequencia;
    }
}

package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoPonto;
import br.edu.infnet.pedrovalladaresapi.domain.models.Ponto;
import br.edu.infnet.pedrovalladaresapi.interfaces.ICrudService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FolhaDeFrequenciaService implements ICrudService<Ponto, Integer> {

    private final Map<Integer, Ponto> mapa = new HashMap<>();
    private final AtomicInteger ids = new AtomicInteger(1);

    @Override
    public Ponto incluir(Ponto ponto) {
        var pontos = obterPorDataEFuncionario(ponto.getData(), ponto.getFuncionario().getCpf());

        if (pontos.isEmpty())
            ponto.setTipoPonto(TipoPonto.Entrada);
        else if (pontos.size() == 1)
            ponto.setTipoPonto(TipoPonto.Saida);
        else
            return null;

        int id = ids.getAndAdd(1);
        ponto.setId(id);
        mapa.put(id, ponto);

        return ponto;
    }

    @Override
    public List<Ponto> listarTodos() {
        return List.of();
    }

    @Override
    public Ponto alterar(Integer i, Ponto entidade) {
        return null;
    }

    @Override
    public void deletar(Integer i) {

    }

    public Ponto obterPorId(Integer id){
        return mapa.get(id);
    }

    public List<Ponto> obterPorData(LocalDate data){
        List<Ponto> pontos = new ArrayList<>();
        mapa.values().forEach((ponto) -> {
            if(ponto.getData().equals(data))
                pontos.add(ponto);
        });

        return pontos;
    }

    public List<Ponto> obterPorDataEFuncionario(LocalDate data, String cpf){
        var pontos = mapa.values();

        pontos = pontos.stream().filter((p -> p.getData().equals(data) && p.getFuncionario().getCpf().equals(cpf))).toList();

        return new ArrayList<>(pontos);
    }

    public List<Ponto> obterPorMesEFuncionario(Integer mes, String cpf){
        List<Ponto> pontos = new ArrayList<>();
        pontos = mapa.values().stream().filter((p) -> p.getData().getMonth().getValue() == mes && p.getFuncionario().getCpf().equals(cpf)).toList();
        return pontos;
    }
}

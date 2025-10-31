package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoPonto;
import br.edu.infnet.pedrovalladaresapi.domain.models.Ponto;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.IPontoRepository;
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

    private final IPontoRepository pontoRepository;

    public FolhaDeFrequenciaService(IPontoRepository pontoRepository){
        this.pontoRepository = pontoRepository;
    }

    @Override
    public Ponto incluir(Ponto ponto) {
        var pontos = obterPorDataEFuncionario(ponto.getData(), ponto.getFuncionario().getCpf());

        if (pontos.isEmpty())
            ponto.setTipoPonto(TipoPonto.Entrada);
        else if (pontos.size() == 1)
            ponto.setTipoPonto(TipoPonto.Saida);
        else
            return null;

        return pontoRepository.save(ponto);
    }

    @Override
    public List<Ponto> listarTodos() {
        return pontoRepository.findAll();
    }

    @Override
    public Ponto alterar(Integer i, Ponto entidade) {
        return null;
    }

    @Override
    public void deletar(Integer i) {

    }

    public Ponto obterPorId(Integer id){
        return pontoRepository.findById(id).orElse(null);
    }

    public List<Ponto> obterPorDataEFuncionario(LocalDate data, String cpf){
        return pontoRepository.findByDataAndFuncionario(data, cpf);
    }

    public List<Ponto> obterPorMesEFuncionario(Integer mes, String cpf){
        return pontoRepository.findByMesAndFuncionario(mes, cpf);
    }
}

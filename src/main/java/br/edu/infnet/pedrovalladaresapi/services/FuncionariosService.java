package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.interfaces.ICrudService;
import br.edu.infnet.pedrovalladaresapi.model.domain.Funcionario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FuncionariosService implements ICrudService<Funcionario, Integer> {

    private final Map<Integer, Funcionario> mapa = new ConcurrentHashMap<Integer, Funcionario>();
    private final AtomicInteger Ids = new AtomicInteger(1);

    @Override
    public Funcionario incluir(Funcionario entidade) {
        return null;
    }

    @Override
    public List<Funcionario> listarTodos() {
        return List.of();
    }

    @Override
    public Funcionario alterar(Integer id, Funcionario entidade) {
        return null;
    }

    @Override
    public void inativar(Integer id) {

    }
}

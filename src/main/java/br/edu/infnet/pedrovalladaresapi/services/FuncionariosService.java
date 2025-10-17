package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.interfaces.ICrudService;
import br.edu.infnet.pedrovalladaresapi.model.domain.Funcionario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FuncionariosService implements ICrudService<Funcionario, String> {

    private final Map<String, Funcionario> mapa = new ConcurrentHashMap<String, Funcionario>();

    @Override
    public Funcionario incluir(Funcionario funcionario) {
        mapa.put(funcionario.getCPF(), funcionario);
        return funcionario;
    }

    @Override
    public List<Funcionario> listarTodos() {
        return new ArrayList<>(mapa.values());
    }

    @Override
    public Funcionario alterar(String id, Funcionario funcionario) {
        if(!mapa.containsKey(id))
            throw new NullPointerException();
        mapa.replace(id, funcionario);

        return funcionario;
    }

    @Override
    public void deletar(String CPF) {
        mapa.remove(CPF);
    }

    public void inativar(String CPF){
        if(!mapa.containsKey(CPF))
            throw new NullPointerException();

        Funcionario funcionario = mapa.get(CPF);
        funcionario.setAtivo(false);
        mapa.replace(CPF, funcionario);
    }
}

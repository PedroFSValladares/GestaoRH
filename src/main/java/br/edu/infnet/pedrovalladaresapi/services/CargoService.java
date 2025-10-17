package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.interfaces.ICrudService;
import br.edu.infnet.pedrovalladaresapi.model.domain.Cargo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CargoService implements ICrudService<Cargo, Integer> {

    private final Map<Integer, Cargo> mapa = new ConcurrentHashMap<Integer, Cargo>();
    private final AtomicInteger id = new AtomicInteger(1);
    @Override
    public Cargo incluir(Cargo entidade) {
        return null;
    }

    @Override
    public List<Cargo> listarTodos() {
        return List.of();
    }

    @Override
    public Cargo alterar(Integer integer, Cargo entidade) {
        return null;
    }

    @Override
    public void deletar(Integer integer) {

    }
}

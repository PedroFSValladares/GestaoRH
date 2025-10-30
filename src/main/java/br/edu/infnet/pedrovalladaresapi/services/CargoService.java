package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.interfaces.ICrudService;
import br.edu.infnet.pedrovalladaresapi.domain.models.Cargo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CargoService implements ICrudService<Cargo, Integer> {

    private final Map<Integer, Cargo> mapa = new ConcurrentHashMap<Integer, Cargo>();
    private final AtomicInteger id = new AtomicInteger(1);
    @Override
    public Cargo incluir(Cargo cargo) {
        int novoId = id.getAndIncrement();
        cargo.setId(novoId);
        mapa.put(novoId, cargo);
        return cargo;
    }

    @Override
    public List<Cargo> listarTodos() {
        return new ArrayList<>(mapa.values());
    }

    @Override
    public Cargo alterar(Integer id, Cargo cargo) {
        Cargo cargoASerAlterado = mapa.get(id);

        if (cargoASerAlterado == null)
            return null;
        else{
            cargo.setId(cargoASerAlterado.getId());
            mapa.replace(id, cargo);
            return cargo;
        }
    }

    @Override
    public void deletar(Integer id) {
        mapa.remove(id);
    }

    public Cargo obterPorId(Integer id){
        return mapa.get(id);
    }

    public void inativar(Integer id){
        Cargo cargo = obterPorId(id);

        if (cargo != null){
            cargo.setAtivo(false);
        }
    }
}

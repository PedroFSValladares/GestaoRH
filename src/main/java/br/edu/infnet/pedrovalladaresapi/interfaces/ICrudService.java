package br.edu.infnet.pedrovalladaresapi.interfaces;

import java.util.List;

public interface ICrudService<T, ID> {
    T incluir(T entidade);
    List<T> listarTodos();
    T alterar(ID id, T entidade);
    void deletar(ID id);
}

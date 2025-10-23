package br.edu.infnet.pedrovalladaresapi.interfaces;

import java.util.List;

public interface IRepository<T, ID> {
    public T incluir(T entidade);
    public T alterar(ID id, T entidade);
    public List<T> lista();
    public T obterPorId(ID id);
    public void excluir(ID id);
}

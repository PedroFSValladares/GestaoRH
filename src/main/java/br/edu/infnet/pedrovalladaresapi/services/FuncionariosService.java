package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.IEnderecoRespository;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.IFuncionarioRepository;
import br.edu.infnet.pedrovalladaresapi.interfaces.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService implements ICrudService<Funcionario, String> {
    private final IFuncionarioRepository funcionarioRepository;
    private final IEnderecoRespository enderecoRespository;

    public FuncionariosService(IFuncionarioRepository funcionarioRepository, IEnderecoRespository enderecoRespository){
        this.funcionarioRepository = funcionarioRepository;
        this.enderecoRespository = enderecoRespository;
    }

    @Override
    public Funcionario incluir(Funcionario funcionario) {
        var endereco = enderecoRespository.findById(funcionario.getEndereco().getCEP());
        if(endereco.isEmpty())
            enderecoRespository.save(funcionario.getEndereco());
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario alterar(String id, Funcionario funcionario) {
        if(!funcionarioRepository.existsById(id))
            return null;
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void deletar(String CPF) {
        funcionarioRepository.deleteById(CPF);
    }

    public void inativar(String CPF){
        Funcionario funcionario = obterPorCPF(CPF);
        if(funcionario != null){
            funcionario.setAtivo(false);
            funcionarioRepository.save(funcionario);
        }
    }

    public Funcionario obterPorCPF(String CPF){
        var funcionario = funcionarioRepository.findById(CPF);
        return funcionario.orElse(null);
    }
}

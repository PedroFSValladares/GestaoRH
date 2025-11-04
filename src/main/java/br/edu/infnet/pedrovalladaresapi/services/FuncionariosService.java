package br.edu.infnet.pedrovalladaresapi.services;

import br.edu.infnet.pedrovalladaresapi.domain.DTOs.viagem.IncluirViagemDTO;
import br.edu.infnet.pedrovalladaresapi.domain.models.Endereco;
import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.models.Transporte;
import br.edu.infnet.pedrovalladaresapi.domain.models.Viagem;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.IEnderecoRespository;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.IFuncionarioRepository;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.ITransporteRepository;
import br.edu.infnet.pedrovalladaresapi.domain.repositories.IViagemRepository;
import br.edu.infnet.pedrovalladaresapi.interfaces.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService implements ICrudService<Funcionario, String> {
    private final IFuncionarioRepository funcionarioRepository;
    private final IEnderecoRespository enderecoRespository;
    private final IViagemRepository viagemRepository;

    public FuncionariosService(IFuncionarioRepository funcionarioRepository, IEnderecoRespository enderecoRespository, IViagemRepository viagemRepository){
        this.funcionarioRepository = funcionarioRepository;
        this.enderecoRespository = enderecoRespository;
        this.viagemRepository = viagemRepository;
    }

    @Override
    public Funcionario incluir(Funcionario funcionario) {
        var endereco = enderecoRespository.findById(funcionario.getEndereco().getCEP());
        if(endereco.isEmpty())
            enderecoRespository.save(funcionario.getEndereco());
        if(funcionario.getViagens() != null)
            viagemRepository.saveAll(funcionario.getViagens());
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

        viagemRepository.saveAll(funcionario.getViagens());
        enderecoRespository.save(funcionario.getEndereco());

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

    public Funcionario adicionarViagem(String cpf, List<Viagem> viagens){
        var funcionario = obterPorCPF(cpf);
        if(funcionario == null)
            return null;
        funcionario.setViagens(viagens);
        return funcionarioRepository.save(funcionario);
    }
}

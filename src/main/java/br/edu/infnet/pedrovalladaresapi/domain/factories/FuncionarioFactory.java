package br.edu.infnet.pedrovalladaresapi.domain.factories;

import br.edu.infnet.pedrovalladaresapi.domain.DTOs.IncluirFuncionarioDTO;
import br.edu.infnet.pedrovalladaresapi.domain.models.Endereco;
import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;

public class FuncionarioFactory {
    public static Funcionario criarFuncionario(IncluirFuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCPF(funcionarioDTO.getCPF());
        funcionario.setAtivo(true);
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        return funcionario;
    }
}

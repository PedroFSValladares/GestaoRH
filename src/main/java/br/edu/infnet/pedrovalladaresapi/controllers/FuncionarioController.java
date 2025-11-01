package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.clients.ViaCepFeignClient;
import br.edu.infnet.pedrovalladaresapi.domain.DTOs.funcionario.AlterarFuncionarioDTO;
import br.edu.infnet.pedrovalladaresapi.domain.DTOs.funcionario.IncluirFuncionarioDTO;
import br.edu.infnet.pedrovalladaresapi.domain.factories.FuncionarioFactory;
import br.edu.infnet.pedrovalladaresapi.domain.models.Endereco;
import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.models.Ponto;
import br.edu.infnet.pedrovalladaresapi.requests.ResponseBody;
import br.edu.infnet.pedrovalladaresapi.services.FolhaDeFrequenciaService;
import br.edu.infnet.pedrovalladaresapi.services.FuncionariosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionariosService funcionariosService;
    private final ViaCepFeignClient viaCepFeignClient;

    public FuncionarioController(FuncionariosService funcionariosService, ViaCepFeignClient viaCepFeignClient){
        this.funcionariosService = funcionariosService;
        this.viaCepFeignClient = viaCepFeignClient;
    }

    @PostMapping
    public ResponseEntity<ResponseBody> incluir(@Valid @RequestBody IncluirFuncionarioDTO funcionario){
        Funcionario funcionarioAIncluir = FuncionarioFactory.criarFuncionario(funcionario);
        funcionariosService.incluir(funcionarioAIncluir);
        return ResponseBody.getByCode(HttpStatus.CREATED, funcionario);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ResponseBody> obterPorCPF(@PathVariable String cpf){
        var funcionario = funcionariosService.obterPorCPF(cpf);
        return funcionario == null ? ResponseBody.getByCode(HttpStatus.NOT_FOUND, null) : ResponseBody.getByCode(HttpStatus.OK, funcionario);
    }

    @GetMapping
    public ResponseEntity<ResponseBody> obterTodos(){
        var funcionarios = funcionariosService.listarTodos();
        return funcionarios.isEmpty() ? ResponseBody.getByCode(HttpStatus.NO_CONTENT, null) : ResponseBody.getByCode(HttpStatus.OK, funcionarios);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ResponseBody> alterar(@PathVariable String cpf, @RequestBody AlterarFuncionarioDTO funcionarioParaAtualizar){
        var funcionario = funcionariosService.obterPorCPF(cpf);
        if(funcionario == null)
            return ResponseBody.getByCode(HttpStatus.NOT_FOUND, null);
        else{
            funcionario.setNome(funcionarioParaAtualizar.getNome());
            funcionario.setTelefone(funcionarioParaAtualizar.getTelefone());
            funcionario.setEmail(funcionarioParaAtualizar.getEmail());
            funcionario.setAtivo(funcionarioParaAtualizar.getAtivo());

            funcionariosService.alterar(cpf, funcionario);
            return ResponseBody.getByCode(HttpStatus.OK, funcionario);
        }
    }

    @PatchMapping("/inativar/{cpf}")
    public ResponseEntity<ResponseBody> inativar(@PathVariable String cpf){
        var funcionario = funcionariosService.obterPorCPF(cpf);
        if(funcionario == null)
            return ResponseBody.getByCode(HttpStatus.NOT_FOUND, null);
        else {
            funcionariosService.inativar(cpf);
            return ResponseBody.getByCode(HttpStatus.NO_CONTENT, null);
        }
    }

    @GetMapping("/endereco/{cep}")
    public ResponseEntity<ResponseBody> obterEnderecoPeloCep(@PathVariable String cep){
        Endereco endereco = viaCepFeignClient.findByCep(cep);
        return endereco.getCEP() == null ? ResponseBody.getByCode(HttpStatus.NOT_FOUND, null) : ResponseBody.getByCode(HttpStatus.OK, endereco);
    }
}

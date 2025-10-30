package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.clients.ViaCepFeignClient;
import br.edu.infnet.pedrovalladaresapi.domain.DTOs.funcionario.AlterarFuncionarioDTO;
import br.edu.infnet.pedrovalladaresapi.domain.DTOs.funcionario.IncluirFuncionarioDTO;
import br.edu.infnet.pedrovalladaresapi.domain.factories.FuncionarioFactory;
import br.edu.infnet.pedrovalladaresapi.domain.models.Endereco;
import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;
import br.edu.infnet.pedrovalladaresapi.requests.ResponseBody;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseBody.Ok(funcionarioAIncluir));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ResponseBody> obterPorCPF(@PathVariable String cpf){
        var funcionario = funcionariosService.obterPorCPF(cpf);
        var resposeBody = funcionario == null ? ResponseBody.NotFound() : ResponseBody.Ok(funcionario);
        return ResponseEntity.status(resposeBody.getStatus()).body(resposeBody);
    }

    @GetMapping
    public ResponseEntity<ResponseBody> obterTodos(){
        var funcionarios = funcionariosService.listarTodos();
        var responseBody = funcionarios.isEmpty() ? ResponseBody.NoContent() : ResponseBody.Ok(funcionarios);
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ResponseBody> alterar(@PathVariable String cpf, @RequestBody AlterarFuncionarioDTO funcionarioParaAtualizar){
        var funcionario = funcionariosService.obterPorCPF(cpf);
        ResponseBody responseBody;
        if(funcionario == null)
            responseBody = ResponseBody.NotFound();
        else{
            funcionario.setNome(funcionarioParaAtualizar.getNome());
            funcionario.setTelefone(funcionarioParaAtualizar.getTelefone());
            funcionario.setEmail(funcionarioParaAtualizar.getEmail());
            funcionario.setAtivo(funcionarioParaAtualizar.getAtivo());
            // TODO lógica pra atualizar o cargo
            funcionariosService.alterar(cpf, funcionario);
            responseBody = ResponseBody.Ok(funcionario);
        }
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }

    @PatchMapping("/inativar/{cpf}")
    public ResponseEntity<ResponseBody> inativar(@PathVariable String cpf){
        var funcionario = funcionariosService.obterPorCPF(cpf);
        ResponseBody responseBody;
        if(funcionario == null)
            responseBody = ResponseBody.NotFound();
        else {
            funcionariosService.inativar(cpf);
            responseBody = ResponseBody.Ok(funcionario);
        }

        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }

    @GetMapping("/endereco/{cep}")
    public ResponseEntity<ResponseBody> obterEnderecoPeloCep(@PathVariable String cep){
        Endereco endereco = viaCepFeignClient.findByCep(cep);
        var responseBody = endereco.getCEP() == null ? ResponseBody.NotFound() : ResponseBody.Ok(endereco);
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }
}

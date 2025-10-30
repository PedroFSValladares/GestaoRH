package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.domain.factories.FolhaDeFrequenciaFactory;
import br.edu.infnet.pedrovalladaresapi.domain.models.FolhaDeFrequencia;
import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.models.Ponto;
import br.edu.infnet.pedrovalladaresapi.requests.ResponseBody;
import br.edu.infnet.pedrovalladaresapi.services.FolhaDeFrequenciaService;
import br.edu.infnet.pedrovalladaresapi.services.FuncionariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/folhaDeFrequencia")
public class FolhaDeFrequenciaController {

    private final FolhaDeFrequenciaService folhaDeFrequenciaService;
    private final FuncionariosService funcionariosService;

    public FolhaDeFrequenciaController(FolhaDeFrequenciaService folhaDeFrequenciaService, FuncionariosService funcionariosService){
        this.folhaDeFrequenciaService = folhaDeFrequenciaService;
        this.funcionariosService = funcionariosService;
    }

    @PostMapping("/resgistrarPonto/{cpf}")
    public ResponseEntity<ResponseBody> baterPonto(@PathVariable String cpf){
        Funcionario funcionario = funcionariosService.obterPorCPF(cpf);
        Ponto ponto = funcionario.criarPonto();
        ponto = folhaDeFrequenciaService.incluir(ponto);

        ResponseBody responseBody = ponto == null ? ResponseBody.BadRequest("Não é possível registrar nenhuma entrada ou saída mais.") : ResponseBody.Created(ponto);
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }

    @GetMapping("/{cpf}/{mes}")
    public ResponseEntity<ResponseBody> obterFolhaDeFuncionarioPorMes(@PathVariable String cpf, @PathVariable int mes){
        ResponseBody responseBody;
        Funcionario funcionario = funcionariosService.obterPorCPF(cpf);
        var pontos = folhaDeFrequenciaService.obterPorMesEFuncionario(mes, cpf);

        if(funcionario == null)
            responseBody = ResponseBody.NotFound();
        else{
            FolhaDeFrequencia folhaDeFrequencia = FolhaDeFrequenciaFactory.gerarFolhaDeFrequencia(funcionario, pontos);
            responseBody = ResponseBody.Ok(folhaDeFrequencia);
        }
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }
}

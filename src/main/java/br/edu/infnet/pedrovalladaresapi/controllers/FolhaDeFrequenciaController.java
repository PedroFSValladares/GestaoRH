package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.domain.factories.FolhaDeFrequenciaFactory;
import br.edu.infnet.pedrovalladaresapi.domain.models.FolhaDeFrequencia;
import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.models.Ponto;
import br.edu.infnet.pedrovalladaresapi.requests.ResponseBody;
import br.edu.infnet.pedrovalladaresapi.services.FolhaDeFrequenciaService;
import br.edu.infnet.pedrovalladaresapi.services.FuncionariosService;
import org.springframework.http.HttpStatus;
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

        return ponto == null ? ResponseBody.getByCode(HttpStatus.BAD_REQUEST, "Não é possível registrar nenhuma entrada ou saída mais.") : ResponseBody.getByCode(HttpStatus.CREATED, ponto);
    }

    @GetMapping("/{cpf}/{mes}")
    public ResponseEntity<ResponseBody> obterFolhaDeFuncionarioPorMes(@PathVariable String cpf, @PathVariable int mes){
        ResponseBody responseBody;
        Funcionario funcionario = funcionariosService.obterPorCPF(cpf);
        var pontos = folhaDeFrequenciaService.obterPorMesEFuncionario(mes, cpf);

        if(funcionario == null)
            return ResponseBody.getByCode(HttpStatus.NOT_FOUND, null);
        else{
            FolhaDeFrequencia folhaDeFrequencia = FolhaDeFrequenciaFactory.gerarFolhaDeFrequencia(funcionario, pontos);
            return ResponseBody.getByCode(HttpStatus.OK, folhaDeFrequencia);
        }
    }
}

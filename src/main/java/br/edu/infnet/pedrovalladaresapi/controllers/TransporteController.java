package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.domain.models.Transporte;
import br.edu.infnet.pedrovalladaresapi.requests.RequestResponse;
import br.edu.infnet.pedrovalladaresapi.services.TransporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transporte")
public class TransporteController {

    private final TransporteService transporteService;

    public TransporteController(TransporteService transporteService){
        this.transporteService = transporteService;
    }

    @PostMapping
    public ResponseEntity<RequestResponse> incluir(@RequestBody Transporte transporte){
        Transporte transporteCriado = transporteService.incluir(transporte);
        return RequestResponse.getByCode(HttpStatus.CREATED, transporteCriado);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<RequestResponse> obterPorCodigo(@PathVariable String codigo){
        Transporte transporte = transporteService.obterPorCodigo(codigo);
        return transporte == null ? RequestResponse.getByCode(HttpStatus.NOT_FOUND, null) : RequestResponse.getByCode(HttpStatus.OK, transporte);
    }
}

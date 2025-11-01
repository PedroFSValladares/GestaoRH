package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.domain.models.Transporte;
import br.edu.infnet.pedrovalladaresapi.requests.ResponseBody;
import br.edu.infnet.pedrovalladaresapi.services.TransporteService;
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
    public ResponseEntity<ResponseBody> incluir(@RequestBody Transporte transporte){
        ResponseBody responseBody = ResponseBody.Created(transporteService.incluir(transporte));
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ResponseBody> obterPorCodigo(@PathVariable String codigo){
        Transporte transporte = transporteService.obterPorCodigo(codigo);
        ResponseBody responseBody = transporte == null ? ResponseBody.NotFound() : ResponseBody.Ok(transporte);
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }
}

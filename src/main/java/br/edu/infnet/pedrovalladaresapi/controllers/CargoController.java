package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.domain.DTOs.cargo.AlterarCargoDTO;
import br.edu.infnet.pedrovalladaresapi.domain.DTOs.cargo.IncluirCargoDTO;
import br.edu.infnet.pedrovalladaresapi.domain.factories.CargoFactory;
import br.edu.infnet.pedrovalladaresapi.domain.models.Cargo;
import br.edu.infnet.pedrovalladaresapi.services.CargoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.infnet.pedrovalladaresapi.requests.ResponseBody;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService){
        this.cargoService = cargoService;
    }

    @PostMapping
    public ResponseEntity<ResponseBody> incluir(@Valid @RequestBody IncluirCargoDTO incluirCargoDTO){
        Cargo cargo = CargoFactory.criarCargo(incluirCargoDTO);
        cargo = cargoService.incluir(cargo);
        ResponseBody responseBody = ResponseBody.Created(cargo);

        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }

    @GetMapping
    public ResponseEntity<ResponseBody> listarTodos(){
        var cargos = cargoService.listarTodos();
        ResponseBody responseBody = cargos.isEmpty() ? ResponseBody.NoContent() : ResponseBody.Ok(cargos);
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obterPorId(@PathVariable Integer id){
        Cargo cargo = cargoService.obterPorId(id);
        ResponseBody responseBody = cargo == null ? ResponseBody.NotFound() : ResponseBody.Ok(cargo);
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> alterar(@PathVariable Integer id, @Valid @RequestBody AlterarCargoDTO alterarCargoDTO){
        Cargo cargo = cargoService.obterPorId(id);
        ResponseBody responseBody;
        if(cargo == null)
            responseBody = ResponseBody.NotFound();
        else{
            cargo.setNome(alterarCargoDTO.getNome());
            cargo.setRemuneracao(alterarCargoDTO.getRemuneracao());
            cargo.setValeTransporte(alterarCargoDTO.getValeTransporte());
            cargo.setValeAlimentacao(alterarCargoDTO.getValeAlimentacao());
            cargo.setAdicionalDeInsalubridade(alterarCargoDTO.getAdicionalDeInsalubridade());
            cargo.setAdicionalDePericulosidade(alterarCargoDTO.getAdicionalDePericulosidade());
            cargo.setCargaHoraria(alterarCargoDTO.getCargaHoraria());

            cargo = cargoService.alterar(id, cargo);
            responseBody = ResponseBody.Ok(cargo);
        }
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }

    @PatchMapping("/inativar/{id}")
    public ResponseEntity<ResponseBody> inativar(@PathVariable Integer id){
        Cargo cargo = cargoService.obterPorId(id);
        ResponseBody responseBody;
        if(cargo == null)
            responseBody = ResponseBody.NotFound();
        else{
            cargoService.inativar(id);
            responseBody = ResponseBody.NoContent();
        }
        return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
    }
}

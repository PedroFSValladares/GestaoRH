package br.edu.infnet.pedrovalladaresapi.controllers;

import br.edu.infnet.pedrovalladaresapi.domain.DTOs.cargo.AlterarCargoDTO;
import br.edu.infnet.pedrovalladaresapi.domain.DTOs.cargo.IncluirCargoDTO;
import br.edu.infnet.pedrovalladaresapi.domain.factories.CargoFactory;
import br.edu.infnet.pedrovalladaresapi.domain.models.Cargo;
import br.edu.infnet.pedrovalladaresapi.services.CargoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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

        return ResponseBody.getByCode(HttpStatus.CREATED, cargo);
    }

    @GetMapping
    public ResponseEntity<ResponseBody> listarTodos(){
        var cargos = cargoService.listarTodos();
        return cargos.isEmpty() ? ResponseBody.getByCode(HttpStatus.NO_CONTENT, null) : ResponseBody.getByCode(HttpStatus.OK, cargos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obterPorId(@PathVariable Integer id){
        Cargo cargo = cargoService.obterPorId(id);
        return cargo == null ? ResponseBody.getByCode(HttpStatus.NOT_FOUND, null) : ResponseBody.getByCode(HttpStatus.OK ,cargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> alterar(@PathVariable Integer id, @Valid @RequestBody AlterarCargoDTO alterarCargoDTO){
        Cargo cargo = cargoService.obterPorId(id);

        if(cargo == null)
            return ResponseBody.getByCode(HttpStatus.NOT_FOUND, null);
        else{
            cargo.setNome(alterarCargoDTO.getNome());
            cargo.setRemuneracao(alterarCargoDTO.getRemuneracao());
            cargo.setValeTransporte(alterarCargoDTO.getValeTransporte());
            cargo.setValeAlimentacao(alterarCargoDTO.getValeAlimentacao());
            cargo.setAdicionalDeInsalubridade(alterarCargoDTO.getAdicionalDeInsalubridade());
            cargo.setAdicionalDePericulosidade(alterarCargoDTO.getAdicionalDePericulosidade());
            cargo.setCargaHoraria(alterarCargoDTO.getCargaHoraria());

            cargo = cargoService.alterar(id, cargo);
            return ResponseBody.getByCode(HttpStatus.OK, cargo);
        }
    }

    @PatchMapping("/inativar/{id}")
    public ResponseEntity<ResponseBody> inativar(@PathVariable Integer id){
        Cargo cargo = cargoService.obterPorId(id);
        if(cargo == null)
             return ResponseBody.getByCode(HttpStatus.NOT_FOUND, null);
        else{
            cargoService.inativar(id);
            return ResponseBody.getByCode(HttpStatus.NO_CONTENT, null);
        }
    }
}

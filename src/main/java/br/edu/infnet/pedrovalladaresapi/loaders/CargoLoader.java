package br.edu.infnet.pedrovalladaresapi.loaders;

import br.edu.infnet.pedrovalladaresapi.domain.models.Cargo;
import br.edu.infnet.pedrovalladaresapi.domain.models.Endereco;
import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;
import br.edu.infnet.pedrovalladaresapi.services.CargoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;

@Order(1)
@Component
public class CargoLoader extends BaseLoader implements ApplicationRunner {

    private final CargoService cargoService;

    public CargoLoader(CargoService cargoService){
        this.cargoService = cargoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var linhas = obterLinhasDeArquivo("Cargos.tsv", true);
        String[] campos = null;

        for (String linha : linhas){
            campos = linha.split("\t");

            Cargo cargo = new Cargo();
            cargo.setNome(campos[1]);
            cargo.setRemuneracao(Double.valueOf(campos[2]));
            cargo.setValeAlimentacao(Double.valueOf(campos[3]));
            cargo.setValeTransporte(Double.valueOf(campos[4]));
            cargo.setAdicionalDePericulosidade(campos[5].equals("Sim"));
            cargo.setAdicionalDeInsalubridade(campos[6].equals("Sim"));
            cargo.setCargaHoraria(Integer.valueOf(campos[7]));
            cargo.setAtivo(true);

            cargoService.incluir(cargo);
        }

        Collection<Cargo> cargos = cargoService.listarTodos();
        cargos.forEach(System.out::println);
    }
}

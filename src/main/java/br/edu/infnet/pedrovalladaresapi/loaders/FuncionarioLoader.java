package br.edu.infnet.pedrovalladaresapi.loaders;

import br.edu.infnet.pedrovalladaresapi.domain.models.Cargo;
import br.edu.infnet.pedrovalladaresapi.domain.models.Endereco;
import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;
import br.edu.infnet.pedrovalladaresapi.services.FuncionariosService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;

@Component
public class FuncionarioLoader implements ApplicationRunner {

    private final FuncionariosService funcionariosService;

    public FuncionarioLoader(FuncionariosService funcionariosService){
        this.funcionariosService = funcionariosService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader  arquivo = new FileReader("Funcionários.tsv");
        BufferedReader leitura = new BufferedReader(arquivo);

        String linha = leitura.readLine();
        String[] campos = null;
        Boolean cabecalho = true;

        while (linha != null){
            if(!cabecalho){
                campos = linha.split("\t");

                Funcionario funcionario = new Funcionario();

                funcionario.setNome(campos[0]);
                funcionario.setCPF(campos[1]);
                funcionario.setEmail(campos[2]);
                funcionario.setEmail(campos[3]);
                funcionario.setMatricula(campos[9]);
                funcionario.setAtivo(true);

                Endereco endereco = new Endereco();
                endereco.setCEP(campos[4]);
                endereco.setLogradouro(campos[5]);
                endereco.setComplemento(campos[6]);
                endereco.setBairro(campos[7]);
                endereco.setUF(campos[8]);

                Cargo cargo = new Cargo();
                cargo.setId(Integer.valueOf(campos[10]));

                funcionario.setEndereco(endereco);
                funcionario.setCargo(cargo);

                funcionariosService.incluir(funcionario);
            }
            linha = leitura.readLine();
            cabecalho = false;
        }

        Collection<Funcionario> funcionarios = funcionariosService.listarTodos();
        funcionarios.forEach(System.out::println);

        leitura.close();
    }
}

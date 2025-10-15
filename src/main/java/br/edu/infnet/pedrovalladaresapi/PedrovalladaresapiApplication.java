package br.edu.infnet.pedrovalladaresapi;

import br.edu.infnet.pedrovalladaresapi.model.domain.Cargo;
import br.edu.infnet.pedrovalladaresapi.model.domain.Endereco;
import br.edu.infnet.pedrovalladaresapi.model.domain.Funcionario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PedrovalladaresapiApplication {

	public static void main(String[] args) {
        SpringApplication.run(PedrovalladaresapiApplication.class, args);

        Funcionario funcionario = new Funcionario();

        funcionario.setNome("Pedro");
        funcionario.setEmail("pedro.valladares@email.com");
        funcionario.setCPF("12345678910");
        funcionario.setTelefone("61 12345678");
        funcionario.setMatricula("123456");

        Endereco endereco = new Endereco();

        endereco.setLogradouro("quadra xyz");
        endereco.setCEP("12345678");
        endereco.setBairro("Bairro ABC");
        endereco.setUF("GO");

        funcionario.setEndereco(endereco);

        Cargo cargo = new Cargo();

        cargo.setNome("Gerente");
        cargo.setRemuneracao(3000.0);
        funcionario.setCargo(cargo);
        System.out.println(funcionario.toString());
	}

}

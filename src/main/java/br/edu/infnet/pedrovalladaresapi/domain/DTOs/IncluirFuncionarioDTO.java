package br.edu.infnet.pedrovalladaresapi.domain.DTOs;

import br.edu.infnet.pedrovalladaresapi.domain.objetosDeValor.CPF;
import br.edu.infnet.pedrovalladaresapi.validation.annotations.ValidCpf;
import jakarta.validation.constraints.*;

public class IncluirFuncionarioDTO {
    @NotEmpty(message = "O campo nome deve ser informado.")
    private String Nome;
    //@Convert(converter = CpfConverter.class)
    @NotNull(message = "O campo CPF deve ser informado.")
    @ValidCpf
    private CPF CPF;
    @NotEmpty(message = "O campo e-mail deve ser informado.")
    @Email(message = "O e-mail informado não é válido.")
    private String Email;
    @NotEmpty(message = "O campo telefone deve ser informado.")
    private String Telefone;
    @NotEmpty(message = "O campo matrícula deve ser informado.")
    private String Matricula;
    @NotNull(message = "O campo cargo deve ser informado.")
    private Integer CargoId;
    @NotEmpty(message = "O campo CEP deve ser informado.")
    @Size(min = 8, max = 8, message = "O CEP informado não é válido.")
    private String Cep;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF.getCpf();
    }

    public void setCPF(String CPF) {
        this.CPF = new CPF(CPF);
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public int getCargoId() {
        return CargoId;
    }

    public void setCargoId(int cargoId) {
        CargoId = cargoId;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }
}

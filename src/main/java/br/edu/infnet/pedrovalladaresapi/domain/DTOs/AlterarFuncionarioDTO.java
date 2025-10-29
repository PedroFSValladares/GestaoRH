package br.edu.infnet.pedrovalladaresapi.domain.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlterarFuncionarioDTO {
    @NotEmpty(message = "O campo nome deve ser informado.")
    private String Nome;
    @NotEmpty(message = "O campo e-mail deve ser informado.")
    @Email(message = "O e-mail informado não é válido.")
    private String Email;
    @NotEmpty(message = "O campo telefone deve ser informado.")
    private String Telefone;
    @NotNull(message = "O campo cargo deve ser informado.")
    private Integer CargoId;
    @NotEmpty(message = "O campo CEP deve ser informado.")
    @Size(min = 8, max = 8, message = "O CEP informado não é válido.")
    private String Cep;
    private Boolean ativo;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
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

    public Integer getCargoId() {
        return CargoId;
    }

    public void setCargoId(Integer cargoId) {
        CargoId = cargoId;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

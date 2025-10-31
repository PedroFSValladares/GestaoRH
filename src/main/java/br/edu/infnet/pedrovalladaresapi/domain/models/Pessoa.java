package br.edu.infnet.pedrovalladaresapi.domain.models;

import br.edu.infnet.pedrovalladaresapi.converters.CpfConverter;
import br.edu.infnet.pedrovalladaresapi.domain.objetosDeValor.CPF;
import br.edu.infnet.pedrovalladaresapi.validation.annotations.ValidCpf;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    @Id
    @Column(name = "cpf")
    @Convert(converter = CpfConverter.class)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @NotNull(message = "O campo CPF deve ser informado.")
    @ValidCpf
    private CPF CPF;
    @Column(name = "email")
    @NotEmpty(message = "O campo e-mail deve ser informado.")
    @Email(message = "O e-mail informado não é válido.")
    private String Email;
    @Column(name = "nome")
    @NotEmpty(message = "O campo nome deve ser informado.")
    private String Nome;
    @Column(name = "telefone")
    @NotEmpty(message = "O campo telefone deve ser informado.")
    private String Telefone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cep")
    private Endereco Endereco;


    @Override
    public String toString(){
        return String.format("Nome: %s | CPF: %s | Email: %s | Telefone: %s | %s",
                Nome, CPF, Email, Telefone, Endereco.toString());
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF.getCpf();
    }

    public void setCPF(String cpf) {
        this.CPF = new CPF(cpf);
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

    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco endereco) {
        if(endereco == null)
            throw new IllegalArgumentException("Endereço deve ser informado!");
        Endereco = endereco;
    }
}

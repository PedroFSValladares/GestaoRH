package br.edu.infnet.pedrovalladaresapi.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "transportes")
public class Transporte {
    @Id
    @Column(name = "codigo_linha")
    @NotEmpty(message = "O código da linha deve ser informado.")
    private String codigo;
    @Column(name = "tarifa")
    @NotNull(message = "A tarifa deve ser informada.")
    private Double Tarifa;
    @Column(name = "ativo")
    private Boolean ativo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getTarifa() {
        return Tarifa;
    }

    public void setTarifa(Double tarifa) {
        Tarifa = tarifa;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

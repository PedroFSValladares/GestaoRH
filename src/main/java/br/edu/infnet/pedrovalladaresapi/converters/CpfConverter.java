package br.edu.infnet.pedrovalladaresapi.converters;

import br.edu.infnet.pedrovalladaresapi.domain.objetosDeValor.CPF;
import jakarta.persistence.AttributeConverter;

public class CpfConverter implements AttributeConverter<CPF, String> {

    @Override
    public String convertToDatabaseColumn(CPF cpf) {
        return cpf.getCpf();
    }

    @Override
    public CPF convertToEntityAttribute(String s) {
        return new CPF(s);
    }
}

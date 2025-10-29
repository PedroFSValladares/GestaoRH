package br.edu.infnet.pedrovalladaresapi.validation.validators;

import br.edu.infnet.pedrovalladaresapi.domain.objetosDeValor.CPF;
import br.edu.infnet.pedrovalladaresapi.validation.annotations.ValidCpf;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<ValidCpf, CPF>{
    @Override
    public boolean isValid(CPF cpf, ConstraintValidatorContext constraintValidatorContext) {
        if(cpf == null)
            return false;
        else if(cpf.getCpf().isEmpty())
            return false;

        return cpf.valido();
    }
}

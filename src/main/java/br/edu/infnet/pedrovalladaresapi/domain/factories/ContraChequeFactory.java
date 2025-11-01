package br.edu.infnet.pedrovalladaresapi.domain.factories;

import br.edu.infnet.pedrovalladaresapi.domain.models.ContraCheque;
import br.edu.infnet.pedrovalladaresapi.domain.models.Funcionario;
import br.edu.infnet.pedrovalladaresapi.domain.models.Ponto;

import java.util.List;

public class ContraChequeFactory {
    public static ContraCheque gerarContraCheque(Funcionario funcionario, List<Ponto> diasTrabalhados){
        ContraCheque contraCheque = new ContraCheque();

        return contraCheque;
    }
}

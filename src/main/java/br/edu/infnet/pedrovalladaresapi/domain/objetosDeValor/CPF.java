package br.edu.infnet.pedrovalladaresapi.domain.objetosDeValor;

public class CPF {
    private String cpf;

    public CPF(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public Boolean valido(){
        int somatorio = 0,
                primeiroDigitoVerificador,
                segundoDigitoVerificador;
        int[] primeiraSequencia = new int[9],
                segundaSequencia = new int[10];
        String digitosVerificadoresOriginais = cpf.substring(9),
                digitoVerificadorFinal;

        char[] temp = new char[9];

        cpf.getChars(0, 9, temp, 0);
        for(int i = 0; i < temp.length; i++){
            primeiraSequencia[i] = Character.getNumericValue(temp[i]);
            segundaSequencia[i] = Character.getNumericValue(temp[i]);
        }

        for(int i = 0,  multiplicador = 10; i < primeiraSequencia.length; i++, multiplicador--){
            somatorio += primeiraSequencia[i] * multiplicador;
        }

        int restoPrimeiraDivisao = somatorio % 11;
        primeiroDigitoVerificador = restoPrimeiraDivisao < 2 ? 0 : 11 - restoPrimeiraDivisao;

        segundaSequencia[9] = primeiroDigitoVerificador;
        somatorio = 0;

        for(int i = 0,  multiplicador = 11; i < segundaSequencia.length; i++, multiplicador--){
            somatorio += segundaSequencia[i] * multiplicador;
        }

        int restoSegundaDivisao = somatorio % 11;
        segundoDigitoVerificador = restoSegundaDivisao < 2 ? 0 : 11 - restoSegundaDivisao;

        digitoVerificadorFinal = String.valueOf(primeiroDigitoVerificador) + String.valueOf(segundoDigitoVerificador);

        return digitosVerificadoresOriginais.equals(digitoVerificadorFinal);
    }

    private int calcularDigitoVerificador(char[] caracteres){
        int somatorio = 0,
                digitoVerificador;
        int[] sequencia = new int[caracteres.length];

        for(int i = 0; i < caracteres.length; i++)
            sequencia[i] = Character.getNumericValue(caracteres[i]);


        for(int i = 0,  peso = sequencia.length + 1; i < sequencia.length; i++, peso--){
            somatorio += sequencia[i] * peso;
        }

        int restoPrimeiraDivisao = somatorio % 11;
        digitoVerificador = restoPrimeiraDivisao < 2 ? 0 : 11 - restoPrimeiraDivisao;

        return digitoVerificador;
    }
}

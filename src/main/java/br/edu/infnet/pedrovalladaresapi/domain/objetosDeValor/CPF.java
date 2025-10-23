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
        int primeiroDigitoVerificador,
                segundoDigitoVerificador;
        String digitosVerificadoresOriginais = cpf.substring(9),
                digitoVerificadorFinal;

        char[] temp = new char[9];

        cpf.getChars(0, 9, temp, 0);
        primeiroDigitoVerificador = calcularDigitoVerificador(temp);

        temp = new char[10];
        cpf.getChars(0, 9, temp, 0);
        temp[9] = Character.forDigit(primeiroDigitoVerificador, 10);

        segundoDigitoVerificador = calcularDigitoVerificador(temp);

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

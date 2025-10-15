package br.edu.infnet.pedrovalladaresapi.model.domain;

public class Funcionario extends Pessoa{

    private String Matricula;
    private Cargo Cargo;

    @Override
    public String toString(){
        return String.format("%s\nMatrícula: %s\n%s",
                super.toString() ,Matricula, Cargo.toString());
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public Cargo getCargo() {
        return Cargo;
    }

    public void setCargo(Cargo cargo) {
        Cargo = cargo;
    }
}

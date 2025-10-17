package br.edu.infnet.pedrovalladaresapi.model.domain;

public class Funcionario extends Pessoa{
    private String Matricula;
    private Cargo Cargo;
    private Boolean Ativo;

    @Override
    public String toString(){
        return String.format("%s\nMatrícula: %s\nAtivo: %s\n%s",
                super.toString() ,Matricula, Ativo ? "Sim" : "Não", Cargo.toString());
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

    public void setAtivo(Boolean ativo){
        Ativo = ativo;
    }

    public Boolean getAtivo(){
        return Ativo;
    }
}

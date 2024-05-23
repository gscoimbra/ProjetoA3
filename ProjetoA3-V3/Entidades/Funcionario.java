package Entidades;

public class Funcionario extends Pessoa {

    private static int contador = 1;
    private int idFuncionario;
    private double salario;
    private String cargo;

    public Funcionario(String nome, int idade, String sexo, String cpf, String endereco, double salario, String cargo) {
        super(nome, idade, sexo, cpf, endereco);

        this.idFuncionario = contador;
        this.salario = salario;
        this.cargo = cargo;
        Funcionario.contador++;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

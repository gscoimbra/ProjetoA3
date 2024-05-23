package Entidades;

public class Veiculo {

    private static int contador = 1;
    private int idVeiculo;
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private double valor;

    public Veiculo(String marca, String modelo, int ano, String cor, double valor) {

        this.idVeiculo = contador;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.valor = valor;
        Veiculo.contador++;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

}

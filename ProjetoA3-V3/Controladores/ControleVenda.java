package Controladores;

import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Veiculo;

import java.util.ArrayList;
import java.util.Scanner;

/*
Responsável pela operação de venda de veículos, esta classe relaciona as três principais
entidades do projeto (cliente, funcionário e veículo).
*/

public class ControleVenda {
    private ArrayList<Veiculo> listaVeiculos;
    private Scanner entrada;

    public ControleVenda(ArrayList<Veiculo> listaVeiculos, Scanner entrada) {
        this.listaVeiculos = listaVeiculos;
        this.entrada = entrada;
    }

    // VENDER VÉICULO
    public void venderVeiculo() {

        int idCliente;
        //Tratativa de erro
        while (true) {
            System.out.print("Digite o ID do cliente: ");
            if (entrada.hasNextInt()) {
                idCliente = entrada.nextInt();
                break; // sai do loop se a entrada for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.nextLine(); // consome a entrada inválida
            }
        }

        int idFuncionario;
        //Tratativa de erro
        while (true) {
            System.out.print("Digite o ID do funcionário: ");
            if (entrada.hasNextInt()) {
                idFuncionario = entrada.nextInt();
                break; // sai do loop se a entrada for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.nextLine(); // consome a entrada inválida
            }
        }

        int idVeiculo;
        //Tratativa de erro
        while (true) {
            System.out.print("Digite o ID do Veiculo: ");
            if (entrada.hasNextInt()) {
                idVeiculo = entrada.nextInt();
                break; // sai do loop se a entrada for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.nextLine(); // consome a entrada inválida
            }
        }

        // Trazendo os objetvos respectivos
        Cliente c = ControleCliente.buscarCliente(idCliente);
        Funcionario f = ControleFuncionario.buscarFuncionario(idFuncionario);
        Veiculo v = ControleVeiculo.buscarVeiculo(idVeiculo);

        // Verificação se os objetos chamados anteriormente existem
        if (c != null && f != null && v != null) {
            System.out.format("%-10s %-14s %-10s %-14s","CLIENTE","FUNCIONARIO","VEICULO","SITUACAO");
            System.out.println();
            System.out.format("%-10s %-14s %-10s %-14s",c.getNome(),f.getNome(),v.getModelo(),"EM PROCESSAMENTO");
            System.out.println();
            System.out.format("%-10s %-14s %-10s %-14s",c.getCarteira(),f.getCargo(),v.getValor()," ");
            System.out.println();
            System.out.println();

            System.out.print("Deseja prosseguir com a operação de venda?(S/N): ");
            String resposta = entrada.next();
            if (resposta.equalsIgnoreCase("S")) {
         // Verificação do saldo do cliente para aprovação da compra, se tiver saldo suficiente, a carteira do cliente é subtraída do valor do veículo e o veículo é removido da listaVeiculos
                if (c.getCarteira() >= v.getValor()) {
                    c.setCarteira(c.getCarteira() - v.getValor());
                    listaVeiculos.remove(v);
                    System.out.println("Venda efetuada com sucesso!");
                    System.out.println();
                    System.out.println();
                    System.out.format("%-10s %-14s %-10s %-14s","CLIENTE","FUNCIONARIO","VEICULO","SITUACAO");
                    System.out.println();
                    System.out.format("%-10s %-14s %-10s %-14s",c.getNome(),f.getNome(),v.getModelo(),"DEFERIDO");
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println();
                    System.out.println("O cliente não possui fundos para comprar esse veículo.");
                    System.out.format("%-10s %-14s %-10s %-14s","CLIENTE","FUNCIONARIO","VEICULO","SITUACAO");
                    System.out.println();
                    System.out.format("%-10s %-14s %-10s %-14s",c.getNome(),f.getNome(),v.getModelo(),"INDEFERIDO");
                    System.out.println();
                    System.out.println();
                }
            } else {
                System.out.println("Ok! Retornando ao menu...");
            }
            // Caso algum objeto não existe, exibo qual não existe
        } else {
            if (c == null) {
                System.out.println("Cliente não encontrado.");
            }
            if (f == null) {
                System.out.println("Funcionário não encontrado.");
            }
            if (v == null) {
                System.out.println("Veículo não encontrado.");
            }
        }
    }
}

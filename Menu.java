import Controladores.ControleCliente;
import Controladores.ControleFuncionario;
import Controladores.ControleVeiculo;
import Controladores.ControleVenda;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Veiculo;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner entrada;
    private ControleCliente controleCliente;
    private ControleFuncionario controleFuncionario;
    private ControleVeiculo controleVeiculo;
    private ControleVenda controleVenda;

    public Menu(Scanner entrada, ArrayList<Cliente> listaClientes, ArrayList<Funcionario> listaFuncionarios, ArrayList<Veiculo> listaVeiculos) {
        this.entrada = entrada;
        this.controleCliente = new ControleCliente(listaClientes, entrada);
        this.controleVeiculo = new ControleVeiculo(listaVeiculos, entrada);
        this.controleFuncionario = new ControleFuncionario(listaFuncionarios, entrada);
        this.controleVenda = new ControleVenda(listaVeiculos, entrada);
    }
    //Função que chama a tela de MENU para o usuário
    public void exibirMenu() {
        while(true) {
            System.out.println("------------------------------------------------------");
            System.out.println("--------------- Concessionária UNIFACS ---------------");
            System.out.println("------------------------------------------------------");
            System.out.println("***** Selecione uma operação que deseja realizar *****");
            System.out.println("Opção 1 - Cadastrar Cliente         |");
            System.out.println("Opção 2 - Exibir Clientes           |");
            System.out.println("Opção 3 - Atualizar Cliente         |");
            System.out.println("Opção 4 - Deletar Cliente           |");
            System.out.println("Opção 5 - Cadastrar Funcionário     |");
            System.out.println("Opção 6 - Exibir Funcionários       |");
            System.out.println("Opção 7 - Atualizar Funcionário     |");
            System.out.println("Opção 8 - Deletar Funcionário       |");
            System.out.println("Opção 9 - Cadastrar Veículo         |");
            System.out.println("Opção 10 - Exibir Veículos          |");
            System.out.println("Opção 11 - Atualizar Veículo        |");
            System.out.println("Opção 12 - Deletar Veículo          |");
            System.out.println("Opção 13 - Vender Veículo           |");
            System.out.println("Opção 14 - Sair                     |");
            System.out.println("------------------------------------------------------");

            //Tratativa de erro no Menu
            int opcao;
            while (true) {
                System.out.print("Digite o número de uma das opções: ");
                if (entrada.hasNextInt()) {
                    opcao = entrada.nextInt();
                    break; // sai do loop se a entrada for válida
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    entrada.nextLine(); // consome a entrada inválida
                }
            }
            switch (opcao) {
                case 1:
                    controleCliente.cadastrarCliente();
                    break;
                case 2:
                    controleCliente.exibirClientes();
                    break;
                case 3:
                    controleCliente.atualizarCliente();
                    break;
                case 4:
                    controleCliente.deletarCliente();
                    break;
                case 5:
                    controleFuncionario.cadastrarFuncionario();
                    break;
                case 6:
                    controleFuncionario.exibirFuncionarios();
                    break;
                case 7:
                    controleFuncionario.atualizarFuncionario();
                    break;
                case 8:
                    controleFuncionario.deletarFuncionario();
                    break;
                case 9:
                    controleVeiculo.cadastrarVeiculo();
                    break;
                case 10:
                    controleVeiculo.exibirVeiculos();
                    break;
                case 11:
                    controleVeiculo.atualizarVeiculo();
                    break;
                case 12:
                    controleVeiculo.deletarVeiculo();
                    break;
                case 13:
                    controleVenda.venderVeiculo();
                    break;
                case 14:
                    System.out.println("Obrigado por usar nossa concessionária!");
                    return; // Termina o loop e sai do método
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
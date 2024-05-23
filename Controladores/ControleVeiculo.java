package Controladores;

import Entidades.Veiculo;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleVeiculo {
    private Scanner entrada;
    private static ArrayList<Veiculo> listaVeiculos;

    public ControleVeiculo(ArrayList<Veiculo> listaVeiculos, Scanner entrada) {
        this.entrada = entrada;
        this.listaVeiculos = listaVeiculos;
    }

    // CADASTRO DO VEÍCULO
    public void cadastrarVeiculo() {
        entrada.nextLine(); // Limpar buffer
        System.out.print("Digite a marca do veículo: ");
        String marca = entrada.nextLine();

        System.out.print("Digite o modelo do veículo: ");
        String modelo = entrada.nextLine();

        int ano;
        while (true) {
            System.out.print("Digite o ano do veículo: ");
            if (entrada.hasNextInt()) {
                ano = entrada.nextInt();
                break; // sai do loop se a entrada for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.nextLine(); // consome a entrada inválida
            }
        }

        entrada.nextLine(); // Limpar buffer
        System.out.print("Digite a cor do veículo: ");
        String cor = entrada.nextLine();

        double valor;
        while (true) {
            System.out.print("Digite o valor do veículo: ");
            if (entrada.hasNextInt() || entrada.hasNextDouble()) {
                valor = entrada.nextDouble();
                break; // sai do loop se a entry for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.nextLine(); // consome a entrada inválida
            }
        }

        Veiculo veiculo = new Veiculo(marca, modelo, ano, cor, valor);
        listaVeiculos.add(veiculo);

        System.out.println("Veículo cadastrado com sucesso!");
    }

    // EXIBIR 3 ATRIBUTOS DE TODOS OS VEÍCULOS OU TODOS DE UM VEÍCULO ESPECÍFICO
    public void exibirVeiculos() {
        if (listaVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        System.out.println("Lista de veículos: ");
        exibirVeiculo_3Atributos(listaVeiculos);

        System.out.print("Deseja exibir todos os atributos de um veículo específico?(S/N): ");
        String resposta = entrada.next();
        if (resposta.equalsIgnoreCase("S")) {

            int idVeiculo;
            while (true) {
                System.out.print("Digite o ID do veículo: ");
                if (entrada.hasNextInt()) {
                    idVeiculo = entrada.nextInt();
                    break; // sai do loop se a entry for válida
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    entrada.nextLine(); // consome a entrada inválida
                }
            }

            Veiculo v = buscarVeiculo(idVeiculo);
            if (v != null) {
                exibirVeiculoAtributos(v);
            } else {
                System.out.println("Veículo não encontrado.");
            }
        } else {
            System.out.println("Retornando ao menu...");
        }
    }

    // ATUALIZAR VEÍCULO
    public void atualizarVeiculo() {

        int idVeiculo;
        while (true) {
            System.out.print("Digite o ID do veículo: ");
            if (entrada.hasNextInt()) {
                idVeiculo = entrada.nextInt();
                break; // sai do loop se a entry for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.next(); // consome a entrada inválida
            }
        }

        Veiculo v = buscarVeiculo(idVeiculo);
        if (v != null) {
            System.out.println("Veículo encontrado, o que deseja atualizar?");
            System.out.println("***** Selecione a atualização que deseja realizar *****");
            System.out.println("Opção 1 - Atualizar marca       |");
            System.out.println("Opção 2 - Atualizar modelo      |");
            System.out.println("Opção 3 - Atualizar ano         |");
            System.out.println("Opção 4 - Atualizar cor         |");
            System.out.println("Opção 5 - Atualizar valor       |");
            System.out.println("------------------------------------------------------");

            int opcao;
            while (true) {
                System.out.print("Digite o número de uma das opções: ");
                if (entrada.hasNextInt()) {
                    opcao = entrada.nextInt();
                    break; // sai do loop se a entry for válida
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    entrada.nextLine(); // consome a entrada inválida
                }
            }
            entrada.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("Marca atual: " + v.getMarca());
                    System.out.print("Digite a nova marca: ");
                    v.setMarca(entrada.nextLine());
                    break;
                case 2:
                    System.out.println("Modelo atual: " + v.getModelo());
                    System.out.print("Digite o novo modelo: ");
                    v.setModelo(entrada.nextLine());
                    break;
                case 3:
                    System.out.println("Ano atual: " + v.getAno());;
                    while (true) {
                        System.out.print("Digite o novo ano: ");;
                        if (entrada.hasNextInt()) {
                            v.setAno(entrada.nextInt());
                            break; // sai do loop se a entrada for válida
                        } else {
                            System.out.println("Entrada inválida. Por favor, digite um número.");
                            entrada.nextLine(); // consome a entrada inválida
                        }
                    }
                    entrada.nextLine(); // Limpar buffer
                    break;
                case 4:
                    System.out.println("Cor atual: " + v.getCor());
                    System.out.print("Digite a nova cor: ");
                    v.setCor(entrada.nextLine());
                    break;
                case 5:
                    System.out.println("Valor atual: " + v.getValor());
                    while (true) {
                        System.out.print("Digite o novo valor: ");
                        if (entrada.hasNextInt() || entrada.hasNextDouble()) {
                            v.setValor(entrada.nextDouble());
                            break; // sai do loop se a entrada for válida
                        } else {
                            System.out.println("Entrada inválida. Por favor, digite um número.");
                            entrada.nextLine(); // consome a entrada inválida
                        }
                    }
                    entrada.nextLine(); // Limpar buffer
                    break;
                default:
                    System.out.println("Opção inválida! Veículo não foi atualizado.");
                    return;
            }
            System.out.println("Veículo atualizado com sucesso!");

            System.out.print("Deseja realizar mais alguma atualização?[S/N]: ");
            String resposta = entrada.next();
            if (resposta.equalsIgnoreCase("S")) {
                atualizarVeiculo();
            }
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }

    // DELETAR VEÍCULO
    public void deletarVeiculo() {

        int idVeiculo;
        while (true) {
            System.out.print("Digite o ID do veículo que deseja deletar: ");
            if (entrada.hasNextInt()) {
                idVeiculo = entrada.nextInt();
                break; // sai do loop se a entry for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.next(); // consome a entrada inválida
            }
        }

        int index = buscarIndexVeiculo(idVeiculo);
        if (index != -1) {
            System.out.print("Deseja realmente deletar esse veículo?(S/N): ");
            String resposta = entrada.next();
            if (resposta.equalsIgnoreCase("S")) {
                listaVeiculos.remove(index);
                System.out.println("Veículo removido com sucesso!");
            } else {
                System.out.println("O veículo não foi removido!");
            }
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    // MÉTODOS AUXILIARES
    // Buscando veiculo pelo id  de forma estatica, otimizando a velocidade de busca.
    public static Veiculo buscarVeiculo(int idVeiculo) {
        for (Veiculo v : listaVeiculos) {
            if (v.getIdVeiculo() == idVeiculo) {
                return v;
            }
        }
        return null;
    }
    //Buscando veiculo pelo index por meio do id, não estatico.
    private int buscarIndexVeiculo(int idVeiculo) {
        for (int i = 0; i < listaVeiculos.size(); i++) {
            if (listaVeiculos.get(i).getIdVeiculo() == idVeiculo) {
                return i;
            }
        }
        return -1;
    }
    //Exibindo em formato tabular 3 atributos de todos os veiculos.
    private void exibirVeiculo_3Atributos(ArrayList<Veiculo> listaVeiculos) {
        System.out.format("%-8s %-14s %-5s","ID","MODELO","VALOR");
        System.out.println();
        for (Veiculo v : listaVeiculos) {
            System.out.format("%-8s %-14s %-5s",v.getIdVeiculo() , v.getModelo() ,v.getValor());
            System.out.println();
        }
    }

    //Exibindo em formato tabular todos atributos de um veiculo.
    private void exibirVeiculoAtributos(Veiculo veiculo) {
        System.out.format("%-8s %-8s %-10s %-8s %-10s %-16s ","ID","MODELO","MARCA","ANO","COR","VALOR");
        System.out.println();
        System.out.format("%-8s %-8s %-10s %-8s %-10s %-16s",veiculo.getIdVeiculo() , veiculo.getModelo() , veiculo.getMarca() , veiculo.getAno() , veiculo.getCor() ,
                veiculo.getValor());
        System.out.println();

    }
}

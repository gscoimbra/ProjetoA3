package Controladores;

import Entidades.Funcionario;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleFuncionario {
    private Scanner entrada;
    private static ArrayList<Funcionario> listaFuncionarios;

    public ControleFuncionario(ArrayList<Funcionario> listaFuncionarios, Scanner entrada) {
        this.entrada = entrada;
        this.listaFuncionarios = listaFuncionarios;
    }

    // CADASTRO DO FUNCIONÁRIO
    public void cadastrarFuncionario() {
        entrada.nextLine(); // Limpar buffer
        System.out.print("Nome do funcionário: ");
        String nome = entrada.nextLine();

        int idade;
        while (true) {
            System.out.print("Idade do funcionário: ");
            if (entrada.hasNextInt()) {
                idade = entrada.nextInt();
                break; // sai do loop se a entrada for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.nextLine(); // consome a entrada inválida
            }
        }

        entrada.nextLine(); // Limpar buffer
        System.out.print("Sexo do funcionário (Masculino, Feminino): ");
        String sexo = entrada.nextLine();

        System.out.print("CPF do funcionário (somente os números): ");
        String cpf = entrada.nextLine();

        System.out.print("Endereço do funcionário (Rua e número da residência): ");
        String endereco = entrada.nextLine();

        double salario;
            while (true) {
                System.out.print("Salário do funcionário: ");
                if (entrada.hasNextInt() || entrada.hasNextDouble()) {
                    salario = entrada.nextDouble();
                    break; // sai do loop se a entrada for válida
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    entrada.nextLine(); // consome a entrada inválida
                }
            }

        entrada.nextLine(); // Limpar buffer
        System.out.print("Cargo do funcionário: ");
        String cargo = entrada.nextLine();

        Funcionario funcionario = new Funcionario(nome, idade, sexo, cpf, endereco, salario, cargo);
        listaFuncionarios.add(funcionario);

        System.out.println(funcionario.getNome() + " foi cadastrado com sucesso!");
    }

    // EXIBIR 3 ATRIBUTOS DE TODOS OS FUNCIONÁRIOS OU TODOS DE UM FUNCIONÁRIO ESPECÍFICO
    public void exibirFuncionarios() {
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("Lista de funcionários: ");
        exibirFuncionarios_3Atributos(listaFuncionarios);

        System.out.print("Deseja exibir todos os atributos de um funcionário específico?(S/N): ");
        String resposta = entrada.next();
        if (resposta.equalsIgnoreCase("S")) {
            System.out.print("Digite o ID do funcionário: ");
            int idFuncionario = entrada.nextInt();

            Funcionario f = buscarFuncionario(idFuncionario);
            if (f != null) {
                exibirFuncionarioAtributos(f);
            } else {
                System.out.println("Funcionário não encontrado.");
            }
        } else {
            System.out.println("Retornando ao menu...");
        }
    }

    // ATUALIZAR FUNCIONÁRIO
    public void atualizarFuncionario() {

        int idFuncionario;
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
        Funcionario f = buscarFuncionario(idFuncionario);
        if (f != null) {
            System.out.println("Funcionário encontrado, o que deseja atualizar?");
            System.out.println("***** Selecione a atualização que deseja realizar *****");
            System.out.println("Opção 1 - Atualizar nome");
            System.out.println("Opção 2 - Atualizar idade");
            System.out.println("Opção 3 - Atualizar sexo");
            System.out.println("Opção 4 - Atualizar CPF");
            System.out.println("Opção 5 - Atualizar endereço");
            System.out.println("Opção 6 - Atualizar salário");
            System.out.println("Opção 7 - Atualizar cargo");
            System.out.println("------------------------------------------------------");

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
            entrada.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("Nome atual: " + f.getNome());
                    System.out.print("Digite o novo nome: ");
                    f.setNome(entrada.nextLine());
                    break;
                case 2:
                    System.out.println("Idade atual: " + f.getIdade());
                    System.out.print("Digite a nova idade: ");
                    f.setIdade(entrada.nextInt());
                    entrada.nextLine(); // Limpar buffer
                    break;
                case 3:
                    System.out.println("Sexo atual: " + f.getSexo());
                    System.out.print("Digite o novo sexo: ");
                    f.setSexo(entrada.nextLine());
                    break;
                case 4:
                    System.out.println("CPF atual: " + f.getCpf());
                    System.out.print("Digite o novo CPF: ");
                    f.setCpf(entrada.nextLine());
                    break;
                case 5:
                    System.out.println("Endereço atual: " + f.getEndereco());
                    System.out.print("Digite o novo endereço: ");
                    f.setEndereco(entrada.nextLine());
                    break;
                case 6:
                    System.out.println("Salário atual: " + f.getSalario());
                    while (true) {
                        System.out.print("Digite o novo salário: ");
                        if (entrada.hasNextInt() || entrada.hasNextDouble()) {
                            f.setSalario(entrada.nextDouble());
                            break; // sai do loop se a entrada for válida
                        } else {
                            System.out.println("Entrada inválida. Por favor, digite um número.");
                            entrada.nextLine(); // consome a entrada inválida
                        }
                    }
                    entrada.nextLine(); // Limpar buffer
                    break;
                case 7:
                    System.out.println("Cargo atual: " + f.getCargo());
                    System.out.print("Digite o novo cargo: ");
                    f.setCargo(entrada.nextLine());
                    break;
                default:
                    System.out.println("Opção inválida! Funcionário não foi atualizado.");
                    return;
            }
            System.out.println("Funcionário atualizado com sucesso!");

        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    // DELETAR FUNCIONÁRIO
    public void deletarFuncionario() {
        int idFuncionario;
        while (true) {
            System.out.print("Digite o ID do funcionário que deseja deletar: ");
            if (entrada.hasNextInt()) {
                idFuncionario = entrada.nextInt();
                break; // sai do loop se a entrada for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.nextLine(); // consome a entrada inválida
            }
        }

        int index = buscarIndexFuncionario(idFuncionario);
        if (index != -1) {
            System.out.print("Deseja realmente deletar esse funcionário?(S/N): ");
            String resposta = entrada.next();
            if (resposta.equalsIgnoreCase("S")) {
                listaFuncionarios.remove(index);
                System.out.println("Funcionário removido com sucesso!");
            } else {
                System.out.println("O funcionário não foi removido!");
            }
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // MÉTODOS AUXILIARES
    // Buscando funcionario pelo id de forma estatica, otimizando a velocidade de busca.
    public static Funcionario buscarFuncionario(int idFuncionario) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getIdFuncionario() == idFuncionario) {
                return f;
            }
        }
        return null;
    }
    //Buscando funcionario pelo index por meio do id, não estatico.
    private int buscarIndexFuncionario(int idFuncionario) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getIdFuncionario() == idFuncionario) {
                return i;
            }
        }
        return -1;
    }
    //Exibindo em formato tabular 3 atributos de todos os funcionarios.
    private void exibirFuncionarios_3Atributos(ArrayList<Funcionario> listaFuncionarios) {
            System.out.format("%-8s %-20s %-5s","ID","NOME","CARGO");
            System.out.println();
        for (Funcionario f : listaFuncionarios) {
            System.out.format("%-8s %-20s %-5s", f.getIdFuncionario() , f.getNome() ,f.getCargo());
            System.out.println();
        }
    }
    //Exibindo em formato tabular todos atributos de um funcionario.
    private void exibirFuncionarioAtributos(Funcionario funcionario) {
        System.out.format("%-8s %-8s %-10s %-14s %-10s %-16s %-30s ","ID","IDADE","SEXO","CPF","SALARIO","CARGO","ENDEREÇO");
        System.out.println();
        System.out.format("%-8s %-8s %-10s %-14s %-10s %-16s %-30s",funcionario.getIdFuncionario(),funcionario.getIdade(),funcionario.getSexo(),
                  funcionario.getCpf() , funcionario.getSalario() , funcionario.getCargo(),funcionario.getEndereco());
        System.out.println();
    }
}

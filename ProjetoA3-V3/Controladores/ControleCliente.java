package Controladores;

import Entidades.Cliente;

import java.util.ArrayList;
import java.util.Scanner;
    public class ControleCliente {
    private Scanner entrada;
    private static ArrayList<Cliente> listaClientes;

    public ControleCliente(ArrayList<Cliente> listaClientes, Scanner entrada) {
        this.entrada = entrada;
        this.listaClientes = listaClientes;
    }

    // CADASTRO DO CLIENTE: Basicamente peço ao usuário os atributos do cliente e crio um objeto cliente com as informações, depois adiciono à lista
    public void cadastrarCliente() {
        entrada.nextLine(); // Limpar buffer
        System.out.print("Nome do cliente: ");
        String nome = entrada.nextLine();

        int idade;
        //Tratativa de erro
        while (true) {
            System.out.print("Idade do cliente: ");
            if (entrada.hasNextInt()) {
                idade = entrada.nextInt();
                break; // sai do loop se a entrada for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.nextLine(); // consome a entrada inválida
            }
        }

        entrada.nextLine(); // Limpar buffer
        System.out.print("Sexo do cliente(Masculino, Feminino): ");
        String sexo = entrada.nextLine();

        System.out.print("CPF do cliente(somente os números): ");
        String cpf = entrada.nextLine();

        System.out.print("Endereço do cliente(Rua e número da residência): ");
        String endereco = entrada.nextLine();

        double carteira;
        //Tratativa de erro
        while (true) {
            System.out.print("Carteira do cliente (R$): ");
            if (entrada.hasNextDouble() || entrada.hasNextInt()) {
                carteira = entrada.nextDouble();
                break; // sai do loop se a entrada for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.nextLine(); // consome a entrada inválida
            }
        }
        entrada.nextLine(); // Limpar buffer
        System.out.print("Email do cliente: ");
        String email = entrada.nextLine();

        System.out.print("Telefone do cliente(somente os números): ");
        String telefone = entrada.nextLine();

        Cliente cliente = new Cliente(nome, idade, sexo, cpf, endereco, carteira, email, telefone);
        listaClientes.add(cliente);

        System.out.println(cliente.getNome() + " foi cadastrado com sucesso!");
    }

    //EXIBIR CLIENTES: Exibo 3 atributos dos clientes e/ou todos de um cliente específico
    public void exibirClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Lista de clientes: ");
        exibirClientes_3Atributos(listaClientes);

        System.out.print("Deseja exibir todos os atributos de um cliente específico?(S/N): ");
        String resposta = entrada.next();
        if (resposta.equalsIgnoreCase("S")) {

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

            Cliente c = buscarCliente(idCliente);
            if (c != null) {
                exibirClienteAtributos(c);
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } else {
            System.out.println("Retornando ao menu...");
        }
    }

    // ATUALIZAR CLIENTE: Exibo um menu com os atributos e pergunto qual deseja atualizar, no final seto a nova informação no atributo do objeto
    public void atualizarCliente() {

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

        Cliente c = buscarCliente(idCliente);
        if (c != null) {
            System.out.println("Cliente encontrado, o que deseja atualizar do cliente?");
            System.out.println("***** Selecione a atualização que deseja realizar *****");
            System.out.println("Opção 1 - Atualizar nome           |");
            System.out.println("Opção 2 - Atualizar idade          |");
            System.out.println("Opção 3 - Atualizar sexo           |");
            System.out.println("Opção 4 - Atualizar CPF            |");
            System.out.println("Opção 5 - Atualizar endereço       |");
            System.out.println("Opção 6 - Atualizar carteira       |");
            System.out.println("Opção 7 - Atualizar Email          |");
            System.out.println("Opção 8 - Atualizar telefone       |");
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
                    System.out.println("Nome atual: " + c.getNome());
                    System.out.print("Digite o novo nome: ");
                    c.setNome(entrada.nextLine());
                    break;
                case 2:
                    System.out.println("Idade atual: " + c.getIdade());
                    while (true) {
                        System.out.print("Digite a nova idade: ");
                        if (entrada.hasNextInt()) {
                            c.setIdade(entrada.nextInt());
                            break; // sai do loop se a entrada for válida
                        } else {
                            System.out.println("Entrada inválida. Por favor, digite um número.");
                            entrada.nextLine(); // consome a entrada inválida
                        }
                    }
                    entrada.nextLine(); // Limpar buffer
                    break;
                case 3:
                    System.out.println("Sexo atual: " + c.getSexo());
                    System.out.print("Digite o novo sexo: ");
                    c.setSexo(entrada.nextLine());
                    break;
                case 4:
                    System.out.println("CPF atual: " + c.getCpf());
                    System.out.print("Digite o novo CPF: ");
                    c.setCpf(entrada.nextLine());
                    break;
                case 5:
                    System.out.println("Endereço atual: " + c.getEndereco());
                    System.out.print("Digite o novo endereço: ");
                    c.setEndereco(entrada.nextLine());
                    break;
                case 6:
                    System.out.println("Carteira atual: " + c.getCarteira());
                    System.out.print("");
                    while (true) {
                        System.out.print("Digite a nova carteira: ");
                        if (entrada.hasNextInt() || entrada.hasNextDouble()) {
                            c.setCarteira(entrada.nextDouble());
                            break; // sai do loop se a entrada for válida
                        } else {
                            System.out.println("Entrada inválida. Por favor, digite um número.");
                            entrada.nextLine(); // consome a entrada inválida
                        }
                    }
                    entrada.nextLine(); // Limpar buffer
                    break;
                case 7:
                    System.out.println("Email atual: " + c.getEmail());
                    System.out.print("Digite o novo email: ");
                    c.setEmail(entrada.nextLine());
                    break;
                case 8:
                    System.out.println("Telefone atual: " + c.getTelefone());
                    System.out.print("Digite o novo telefone: ");
                    c.setTelefone(entrada.nextLine());
                    break;
                default:
                    System.out.println("Opção inválida! Cliente não foi atualizado.");
                    return;
            }
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    // DELETAR CLIENTE: Busco o cliente e depois o removo da lista pelo index
    public void deletarCliente() {

        int idCliente;
        //Tratativa de erro
        while (true) {
            System.out.print("Digite o ID do cliente: ");
            if (entrada.hasNextInt()) {
                idCliente = entrada.nextInt();
                break; // sai do loop se a entrada for válida
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.next(); // consome a entrada inválida
            }
        }
        int index = buscarIndexCliente(idCliente);
        if (index != -1) {
            System.out.print("Deseja realmente deletar esse cliente?(S/N): ");
            String resposta = entrada.next();
            if (resposta.equalsIgnoreCase("S")) {
                listaClientes.remove(index);
                System.out.println("Cliente removido com sucesso!");
            } else {
                System.out.println("O cliente não foi removido!");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // BUSCAR CLIENTE: Busco o cliente na lista e retorno ele mesmo.
    public static Cliente buscarCliente(int idCliente) {
        for (Cliente c : listaClientes) {
            if (c.getIdCliente() == idCliente) {
                return c;
            }
        }
        return null;
    }

    // MÉTODOS AUXILIARES: Como estarei usando eles apenas nessa classe, deixo como private.

    //Buscando cliente pelo index por meio do id, não estatico.
    private int buscarIndexCliente(int idCliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getIdCliente() == idCliente) {
                return i;
            }
        }
        return -1;
    }
    //Exibindo em formato tabular 3 atributos de todos os clientes.
    private void exibirClientes_3Atributos(ArrayList<Cliente> listaClientes) {
            System.out.format("%-8s %-20s %-8s","ID","NOME","CARTEIRA");
            System.out.println();
        for (Cliente c : listaClientes) {
            System.out.format("%-8s %-20s %-8s",c.getIdCliente(),c.getNome(),c.getCarteira());
            System.out.println();
        }
    }
    //Exibindo em formato tabular todos atributos de um cliente.
    private void exibirClienteAtributos(Cliente cliente) {
            System.out.format("%-8s %-8s %-10s %-14s %-10s %-10s %-30s %-30s","ID","IDADE","SEXO","CPF","CARTEIRA","TELEFONE","ENDEREÇO","EMAIL");
            System.out.println();
            System.out.format("%-8s %-8s %-10s %-14s %-10s %-10s %-30s %-30s",cliente.getIdCliente(),cliente.getIdade()
                ,cliente.getSexo() ,cliente.getCpf(), cliente.getCarteira(),cliente.getTelefone(),cliente.getEndereco(),cliente.getEmail());
            System.out.println();
    }
}

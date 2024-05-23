/*
O tema do projeto escolhido pelo grupo é um sistema de concessionária que, apesar de nosso contexto ser uma elaboração
simples do que poderia ser um sistema real, foi escolhido por estar alinhado com os objetivos do trabalho e ser facilmente
compreendido pela maioria das pessoas. O principal objetivo do projeto é desenvolver um sistema CRUD (Create, Read, Update, Delete)
utilizando a linguagem Java. Para alcançar esse objetivo, decidimos utilizar os ambientes de desenvolvimento Visual Studio Code
e IntelliJ IDEA.

O Cliente, o Funcionário e o Veículo são as entidades do nosso projeto, sendo que em suas classes temos os getters e setters
para manipular os dados. Pessoa é a Super Classe de Cliente e Funcionário.

Os Controladores são as classes que possuem os métodos relacionados à sua entidade, por exemplo o ControleCliente é o controlador
da entidade cliente e nela teremos os métodos de cadastro, exibir, atualizar e deletar.

O Menu exibe o menu de opções ao usuário.
*/

import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Veiculo;

import java.util.Scanner;
import java.util.ArrayList;

/*
Esta classe Principal contém a função main(), que é o ponto de entrada do programa. Nela inicializamos o que será nosso banco de dados,
representado por um ArrayList<>, instanciamos as entidades iniciais conforme os requisitos do trabalho e instanciamos o menu.
 */
public class Principal {
    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<Veiculo> listaVeiculos;
    private static ArrayList<Cliente> listaClientes;
    private static ArrayList<Funcionario> listaFuncionarios;

    public static void main(String[] args) {
        listaVeiculos = new ArrayList<>();
        listaClientes = new ArrayList<>();
        listaFuncionarios = new ArrayList<>();

        //Cliente cliente = new Cliente(nome, idade, sexo, cpf, endereco, carteira, email, telefone);
        Cliente cliente01 = new Cliente("Maria",35,"F","23546789421","Rua nossa Senhora do Carmo 31",90000.0,"mariacarmo@gmail.com","988504190");
        Cliente cliente02 = new Cliente("Luis",28,"M","54786214623","Av.Aliomar Baleeiro 52",70000.0,"luisalmeida@outlook.com","983997570");
        Cliente cliente03 = new Cliente("Fernando",40,"M","25789643125","Rua Belo Horizonte 65",150000.0,"fernandomascarenhas@hotmail.com","988205463");
        listaClientes.add(cliente01);
        listaClientes.add(cliente02);
        listaClientes.add(cliente03);

        //Funcionario funcionario = new Funcionario(nome, idade, sexo, cpf, endereco, salario, cargo);
        Funcionario funcionario01 = new Funcionario("Jonathas", 25, "M", "78542369541", "Rua sol Nascente 43", 3000.0, "Vendedor Jr");
        Funcionario funcionario02 = new Funcionario("Anna", 33, "F", "85412654785", "AV. Fernandes Cunha 97", 4000.0, "Vendedor Pl");
        Funcionario funcionario03 = new Funcionario("Diana", 48, "F", "21456752489", "Av. Paulo VI 510", 6000.0, "Vendedor Sr");
        listaFuncionarios.add(funcionario01);
        listaFuncionarios.add(funcionario02);
        listaFuncionarios.add(funcionario03);

        //Veiculo veiculo = new Veiculo(marca, modelo, ano, cor, valor);
        Veiculo veiculo01 = new Veiculo("Chevrolet","Onix",2024,"Prata",87790.0);
        Veiculo veiculo02 = new Veiculo("Renalt","Duster",2023,"Branco",73640.0);
        Veiculo veiculo03 = new Veiculo("FIAT","Argo",2022,"Vermelho",84990.0);
        Veiculo veiculo04 = new Veiculo("Ferrari","296 GTB",2020,"Vermelha",800000.0);
        Veiculo veiculo05 = new Veiculo("BMW","X6",2021,"Branco",300000.0);
        Veiculo veiculo06 = new Veiculo("FIAT","Uno",2019,"Prata",50000.0);
        Veiculo veiculo07 = new Veiculo("Ford","Ka",2017,"Preto",55000.0);
        listaVeiculos.add(veiculo01);
        listaVeiculos.add(veiculo02);
        listaVeiculos.add(veiculo03);
        listaVeiculos.add(veiculo04);
        listaVeiculos.add(veiculo05);
        listaVeiculos.add(veiculo06);
        listaVeiculos.add(veiculo07);

        //Crio um objeto Menu para acessar o Menu de opções
        Menu menu = new Menu(entrada, listaClientes, listaFuncionarios, listaVeiculos);
        menu.exibirMenu();
    }
}

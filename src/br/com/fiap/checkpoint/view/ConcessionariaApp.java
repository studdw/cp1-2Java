package br.com.fiap.checkpoint.view;

import br.com.fiap.checkpoint.model.Veiculo;
import br.com.fiap.checkpoint.model.VeiculoDao;
import br.com.fiap.checkpoint.model.VeiculoNovo;
import br.com.fiap.checkpoint.model.VeiculoSeminovo;

import java.util.List;
import java.util.Scanner;

public class ConcessionariaApp {

    private Scanner scanner;
    private VeiculoDao dao;

    public ConcessionariaApp() {
        this.scanner = new Scanner(System.in);
        this.dao = new VeiculoDao();
    }

    public static void main(String[] args) {
        ConcessionariaApp app = new ConcessionariaApp();
        app.iniciar();
    }

    public void iniciar() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("===== MENU - CONCESSIONÁRIA =====");
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Listar veículos");
            System.out.println("3 - Pesquisar veículo por placa");
            System.out.println("4 - Editar veículo");
            System.out.println("5 - Remover veículo");
            System.out.println("6 - Pesquisar veículo por modelo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine().trim());

            if (opcao == 1) {
                cadastrarVeiculo();

            } else if (opcao == 2) {
                listarVeiculos();

            } else if (opcao == 3) {
                pesquisarPorPlaca();

            } else if (opcao == 4) {
                editarVeiculo();

            } else if (opcao == 5) {
                removerVeiculo();

            } else if (opcao == 6) {
                pesquisarPorModelo();

            } else if (opcao == 0) {
                System.out.println("Encerrando o sistema. Até mais!");

            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private void cadastrarVeiculo() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Preço: ");
        double preco = Double.parseDouble(
                scanner.nextLine().trim().replace(",", ".")
        );

        System.out.print("Tipo (1 - Novo | 2 - Seminovo): ");
        int tipo = Integer.parseInt(scanner.nextLine().trim());

        Veiculo veiculo;

        if (tipo == 1) {

            System.out.print("Garantia (meses): ");
            int garantia = Integer.parseInt(scanner.nextLine().trim());

            veiculo = new VeiculoNovo(
                    placa,
                    modelo,
                    ano,
                    preco,
                    garantia
            );

        } else {

            System.out.print("Quilometragem: ");
            int km = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Quantidade de donos anteriores: ");
            int donos = Integer.parseInt(scanner.nextLine().trim());

            veiculo = new VeiculoSeminovo(
                    placa,
                    modelo,
                    ano,
                    preco,
                    km,
                    donos
            );
        }

        boolean sucesso = dao.cadastrar(veiculo);

        if (sucesso) {
            System.out.println("Veículo cadastrado com sucesso!");
        } else {
            System.out.println("Já existe um veículo com essa placa!");
        }
    }

    private void listarVeiculos() {
        List<Veiculo> veiculos = dao.listar();

        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            System.out.println("----- Lista de veículos -----");

            for (Veiculo v : veiculos) {
                System.out.println(v);
            }
        }
    }

    private void pesquisarPorPlaca() {
        System.out.print("Digite a placa: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = dao.pesquisarPorPlaca(placa);

        if (veiculo != null) {
            System.out.println(veiculo);
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private void editarVeiculo() {
        System.out.print("Placa do veículo que vai editar: ");
        String placa = scanner.nextLine();

        System.out.print("Novo modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Novo preço: ");
        double preco = Double.parseDouble(
                scanner.nextLine().trim().replace(",", ".")
        );

        boolean sucesso = dao.editar(placa, modelo, preco);

        if (sucesso) {
            System.out.println("Veículo atualizado!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private void removerVeiculo() {
        System.out.print("Placa do veículo para remover: ");
        String placa = scanner.nextLine();

        boolean sucesso = dao.remover(placa);

        if (sucesso) {
            System.out.println("Veículo removido!!!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private void pesquisarPorModelo() {
        System.out.print("Digite o modelo: ");
        String modelo = scanner.nextLine();

        List<Veiculo> encontrados = dao.pesquisarPorModelo(modelo);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum veículo encontrado com esse modelo.");
        } else {
            for (Veiculo v : encontrados) {
                System.out.println(v);
            }
        }
    }
}
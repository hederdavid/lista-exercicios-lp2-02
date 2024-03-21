package prova.quest03;

import java.util.Scanner;

public class ProdutoUtil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[5];
        String nome, siglaUnd;
        int estoqueInicial, opcaoEscolhida = 0;
        double precoUnitario;
        boolean isValoresCorretos = false;
        for (int i = 0; i < produtos.length; i++) {
            do {
                System.out.println("Cadastre seu produto...");

                System.out.print("Insira o nome do produto: ");
                nome = scanner.nextLine();

                System.out.print("Insira a sigla da unidade de venda (kg, lt...): ");
                siglaUnd = scanner.nextLine();

                System.out.print("Insira o estoque incial: ");
                estoqueInicial = scanner.nextInt();

                System.out.print("Insira o preço por unidade: ");
                precoUnitario = scanner.nextDouble();
                scanner.nextLine();
                try {
                    produtos[i] = new Produto(nome, siglaUnd, estoqueInicial, precoUnitario);
                    isValoresCorretos = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (!isValoresCorretos);
        }

        isValoresCorretos = false;

        do {
            System.out.println("Escolha uma operação: ");
            System.out.println("1. Listar produtos com estoque disponivel");
            System.out.println("2. Registrar venda");
            System.out.println("3. Exibir faturamento");
            System.out.println("4. Encerrar operação");
            System.out.print("Insira a opção escolhida: ");
            opcaoEscolhida = scanner.nextInt();
            switch (opcaoEscolhida) {
                case 1 -> {
                    System.out.println("Produtos disponíveis para venda: ");
                    for (Produto produto : produtos) {
                        if (produto.isDisponivel()) {
                            System.out.println(produto.getNome());
                        }
                    }
                }
                case 2 -> {
                    int opcaoProduto, quantidadeVenda;
                    System.out.println("Selecione um produto: ");
                    for (int i = 0; i < produtos.length; i++) {
                        System.out.println((i + 1) + ". " + produtos[i].getNome());
                    }
                    System.out.print("Opção escolhida: ");
                    opcaoProduto = scanner.nextInt();
                    System.out.print("Insira a quantidade a comprar: ");
                    quantidadeVenda = scanner.nextInt();

                    switch (opcaoProduto) {
                        case 1 -> {
                            if (produtos[0].adicionarVenda(quantidadeVenda)) {
                                System.out.println("Venda realizada com sucesso!");
                            } else {
                                System.out.println("Estoque atual insuficiente.");
                            }
                        }
                        case 2 -> {
                            if (produtos[1].adicionarVenda(quantidadeVenda)) {
                                System.out.println("Venda realizada com sucesso!");
                            } else {
                                System.out.println("Estoque indisponível.");
                            }
                        }
                        case 3 -> {
                            if (produtos[2].adicionarVenda(quantidadeVenda)) {
                                System.out.println("Venda realizada com sucesso!");
                            } else {
                                System.out.println("Estoque indisponível.");
                            }
                        }
                        case 4 -> {
                            if (produtos[3].adicionarVenda(quantidadeVenda)) {
                                System.out.println("Venda realizada com sucesso!");
                            } else {
                                System.out.println("Estoque indisponível.");
                            }
                        }
                        case 5 -> {
                            if (produtos[4].adicionarVenda(quantidadeVenda)) {
                                System.out.println("Venda realizada com sucesso!");
                            } else {
                                System.out.println("Estoque indisponível.");
                            }
                        }
                        default -> System.out.println("Entrada inválida, tente novamente.");
                    }

                }
                case 3 -> {
                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i].getFaturamentoVenda() > 0) {
                            System.out.println("Produto " + (i + 1));
                            System.out.println("Faturamento: " + produtos[i].getFaturamentoVenda());
                        }
                    }
                }
                default -> {
                    opcaoEscolhida = 4;
                }
            }


        } while (opcaoEscolhida != 4);

    }
}

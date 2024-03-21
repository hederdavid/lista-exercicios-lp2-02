package prova.quest05;

import java.util.Scanner;

public class SomadorAleatorioUtil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SomadorAleatorio[] somadores = new SomadorAleatorio[3];
        int intervalo = 0, opcaoEscolhida = 0;

        for (int i = 0; i < somadores.length; i++) {
            System.out.print("Insira o intervalo de geração de números da " + (i + 1) + "ª thread em segundos: ");
            intervalo = scanner.nextInt();
            somadores[i] = new SomadorAleatorio(intervalo);
            somadores[i].start();
        }

        do {
            System.out.println("Escolha uma operação: ");
            System.out.println("1. Consultar valor atual (específico)");
            System.out.println("2. Consultar valor atual (todas)");
            System.out.println("3. Encerrar aplicação");
            System.out.print("Opção escolhida: ");
            opcaoEscolhida = scanner.nextInt();
            switch (opcaoEscolhida) {
                case 1 -> {
                    int opcaoSomador;
                    for (int i = 0; i < somadores.length; i++) {
                        System.out.println("Somador " + (i + 1));
                    }
                    System.out.print("Opção escolhida: ");
                    opcaoSomador = scanner.nextInt();
                    switch (opcaoSomador) {
                        case 1 -> {
                            System.out.println("Soma atual: " + somadores[0].getSomaAtual());
                        }
                        case 2 -> {
                            System.out.println("Soma atual: " + somadores[1].getSomaAtual());
                        }
                        case 3 -> {
                            System.out.println("Soma atual: " + somadores[2].getSomaAtual());
                        }
                    }
                }
                case 2 -> {
                    for (int i = 0; i < somadores.length; i++) {
                        System.out.println("Valor atual do somador " + (i + 1) + ": " + somadores[i].getSomaAtual());
                    }
                }
                default -> {
                    opcaoEscolhida = 3;
                }
            }
        } while (opcaoEscolhida != 3);
    }
}

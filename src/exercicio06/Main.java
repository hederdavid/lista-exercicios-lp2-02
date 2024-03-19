package exercicio06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroFornecido;
        int opcaoEscolhida;
        NumerosTriangulares[] triangulares = new NumerosTriangulares[3];
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Insira o " + (i + 1) + "º número inteiro positivo: ");
            numeroFornecido = scanner.nextInt();
            triangulares[i] = new NumerosTriangulares(numeroFornecido);
            threads[i] = new Thread(triangulares[i]);
            threads[i].start();
        }

        while (threads[0].isAlive() || threads[1].isAlive() || threads[2].isAlive()) {
            System.out.println("Programa em execução, espere um pouco...");
        }

        do {
            System.out.print("Escolha <1/2/3> para exibir os resultados, <4> para exibir thread de menor tempo e <5>" +
                    " para finalizar: ");
            opcaoEscolhida = scanner.nextInt();

            switch (opcaoEscolhida) {
                case 1:
                    triangulares[0].getResultado();
                    break;
                case 2:
                    triangulares[1].getResultado();
                    break;
                case 3:
                    triangulares[2].getResultado();
                    break;
                case 4:
                    long menorTempo = triangulares[0].tempoExecucao;;
                    if (triangulares[1].tempoExecucao < menorTempo) {
                        menorTempo = triangulares[1].tempoExecucao;
                    }
                    if (triangulares[2].tempoExecucao < menorTempo) {
                        menorTempo = triangulares[2].tempoExecucao;
                    }
                    System.out.println("O menor tempo de execução foi: " + menorTempo);
                    break;
                default:
                    opcaoEscolhida = 5;
                    break;
            }
        } while(opcaoEscolhida != 5);
    }
}

package exercicio08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Palindromos[] arrayPalindromos = new Palindromos[3];
        int quantidade = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("Informe Quantidade de Palíndromos: ");
            quantidade = scanner.nextInt();
            arrayPalindromos[i] = new Palindromos(quantidade);
            arrayPalindromos[i].start();
        }

        while(arrayPalindromos[0].isAlive() || arrayPalindromos[1].isAlive() || arrayPalindromos[2].isAlive()) {
            System.out.println("Programa em execução, aguarde...");
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Gerador " + (i + 1));
            arrayPalindromos[i].getResultado();
            System.out.println("-----------------------------------------------------------");
        }

        long menorTempo = arrayPalindromos[0].getTempoExecucao();
        int gerador = 1;
        if (menorTempo > arrayPalindromos[1].getTempoExecucao()) {
            menorTempo = arrayPalindromos[1].getTempoExecucao();
            gerador = 2;
        }
        if (arrayPalindromos[0].getTempoExecucao() > arrayPalindromos[2].getTempoExecucao()) {
            menorTempo = arrayPalindromos[0].getTempoExecucao();
            gerador = 3;
        }

        System.out.println("Gerador com menor tempo de processamento: " + gerador);


    }
}

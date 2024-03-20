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
        int geradorMenorTempo = 1;
        if (menorTempo > arrayPalindromos[1].getTempoExecucao()) {
            menorTempo = arrayPalindromos[1].getTempoExecucao();
            geradorMenorTempo = 2;
        }
        if (menorTempo > arrayPalindromos[2].getTempoExecucao()) {
            menorTempo = arrayPalindromos[0].getTempoExecucao();
            geradorMenorTempo = 3;
        }

        long maiorTempo = arrayPalindromos[0].getTempoExecucao();
        int geradorMaiorTempo = 1;
        if (maiorTempo < arrayPalindromos[1].getTempoExecucao()) {
            maiorTempo = arrayPalindromos[1].getTempoExecucao();
            geradorMaiorTempo = 2;
        }
        if (maiorTempo < arrayPalindromos[2].getTempoExecucao()) {
            maiorTempo = arrayPalindromos[2].getTempoExecucao();
            geradorMaiorTempo = 3;
        }

        double porcentagemAcima = ((double) (arrayPalindromos[geradorMaiorTempo - 1].getTempoExecucao()
                - arrayPalindromos[geradorMenorTempo - 1].getTempoExecucao()) /
                arrayPalindromos[geradorMenorTempo - 1].getTempoExecucao() * 100);

        System.out.println("Gerador com menor tempo de processamento: " + geradorMenorTempo);
        System.out.println("Gerador com maior tempo de processamento: " + geradorMaiorTempo + "" +
                " Aproximadamente <" + String.format("%.2f", porcentagemAcima) + "% acima>" );


    }
}

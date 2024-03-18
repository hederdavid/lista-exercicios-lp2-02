package exercicio05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cronometro[] cronometros = new Cronometro[3];
        long tempo;
        String escolha = null;
        char selecionarCronometro;
        boolean isF = false;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print( (i + 1) + "ª Contagem Regressiva..............: ");
            tempo = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Pausa P/" + (i + 1) + "ª Contagem Regressiva (S/N)? ");
            escolha = scanner.nextLine();
            cronometros[i] = new Cronometro(tempo, escolha.equalsIgnoreCase("s") ? 1000 : 0 );
            Thread t  = new Thread(cronometros[i]);
            t.start();
        }

        do {
            System.out.print("Consultar Contador Regressivo (1/2/3) ou Encerrar (F)? ");
            selecionarCronometro = scanner.next().charAt(0);

            int opcao = Character.getNumericValue(selecionarCronometro);

            switch (opcao) {
                case 1:
                    System.out.println("Contagem Atual de Contador 1 -> " + cronometros[0].getContador() + " " + cronometros[0].getSituacao());
                    break;
                case 2:
                    System.out.println("Contagem Atual de Contador 2 -> " + cronometros[1].getContador() + " " + cronometros[1].getSituacao());
                    break;
                case 3:
                    System.out.println("Contagem Atual de Contador 3 -> " + cronometros[2].getContador() + " " + cronometros[2].getSituacao());
                    break;
                default:
                    isF = true;
                    if (cronometros[0].getContador() != 0 || cronometros[1].getContador() != 0 || cronometros[3].getContador() != 0) {
                        System.out.println("O programa se encerrará assim que todos os cronometros chegarem a 0");
                    } else {
                        System.out.println("Programa encerrado.");
                    }
                    break;
            }
            scanner.nextLine();
        } while (!isF);

        scanner.close();
    }
}

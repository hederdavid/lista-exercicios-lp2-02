package exercicio03;

import exercicio02.NumerosPrimos;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int intervaloNumericoMain = 0;
        int inicio = 0;
        int fim;
        NumerosPrimos[] divididos = new NumerosPrimos[5];
        do {
            System.out.print("Forneça o intervalo numérico inteiro divisível por 5: ");
            intervaloNumericoMain = scanner.nextInt();
            if (intervaloNumericoMain % 5 != 0) {
                System.out.println("Forneça um número inteiro divisível por 5!");
            }
        } while (intervaloNumericoMain % 5 != 0);

        fim = intervaloNumericoMain / 5;

        for (int i = 0; i < 5; i++) {
            divididos[i] = new NumerosPrimos(inicio, fim);
            inicio = fim;
            fim += intervaloNumericoMain / 5;
            divididos[i].start();
        }

        sleep(500);

        for (int i = 0; i < divididos.length; i++) {
            if (i == 0) {
                System.out.println("Números primos de " + divididos[i].getInicio() + " a " + divididos[i].getFim());
                divididos[i].getResultado();
                sleep(2000);
            } else {
                System.out.println("Números primos de " + (divididos[i].getInicio() + 1) + " a " + divididos[i].getFim());
                divididos[i].getResultado();
                sleep(1000);
            }

        }
    }
}

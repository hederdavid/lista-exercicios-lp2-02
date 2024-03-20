package exercicio09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SomadorNumerosAleatorios[] arraySomadorNumerosAleatorios = new SomadorNumerosAleatorios[4];
        System.out.print("Informe a quantidade de somas: ");
        int quantidadeDeSomas = scanner.nextInt();
        String consultarOuEncerrar;
        for (int i = 0; i < 4; i++) {
            arraySomadorNumerosAleatorios[i] = new SomadorNumerosAleatorios(quantidadeDeSomas);
            Thread t = new Thread(arraySomadorNumerosAleatorios[i]);
            t.start();
        }

        do {
            System.out.print("Consultar Somadores ou Encerrar (S/E)? ");
            consultarOuEncerrar = scanner.nextLine();

            System.out.print("Somadores: \n");
            for (int i = 0; i < 4; i++) {
                System.out.println("S" + (i + 1) + " <" + arraySomadorNumerosAleatorios[i].getResultado() + "> ");

            }

            String maiorSomador;
            if (arraySomadorNumerosAleatorios[0].getResultado() < arraySomadorNumerosAleatorios[1].getResultado() &&
                    arraySomadorNumerosAleatorios[1].getResultado() < arraySomadorNumerosAleatorios[2].getResultado() &&
                    arraySomadorNumerosAleatorios[2].getResultado() < arraySomadorNumerosAleatorios[3].getResultado()) {
                maiorSomador = "S4";
            } else if (arraySomadorNumerosAleatorios[0].getResultado() < arraySomadorNumerosAleatorios[1].getResultado() &&
                    arraySomadorNumerosAleatorios[1].getResultado() < arraySomadorNumerosAleatorios[2].getResultado()) {
                maiorSomador = "S3";
            } else if (arraySomadorNumerosAleatorios[0].getResultado() < arraySomadorNumerosAleatorios[1].getResultado()) {
                maiorSomador = "S2";
            } else {
                maiorSomador = "S1";
            }

            System.out.println("Somador de Maior Valor Momentâneo: " + maiorSomador);
        } while(!consultarOuEncerrar.equalsIgnoreCase("E"));
    }
}

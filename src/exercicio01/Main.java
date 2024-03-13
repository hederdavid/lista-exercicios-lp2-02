package exercicio01;

import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        Cronometro[] cronometros = new Cronometro[10];
        int indice = 0;
        do {
            System.out.println("---------------------------------------");
            System.out.println("GERENCIADOR DE CRONÔMETROS");
            System.out.println("---------------------------------------");
            System.out.println("Selecione uma opção: ");
            System.out.println("1. Criar novo cronômetro");
            System.out.println("2. Consultar cronômetro");
            System.out.println("3. Consultar todos os cronômetros");
            System.out.println("4. Sair");
            System.out.print("Opção escolhida: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    cronometros[indice] = new Cronometro(false);
                    cronometros[indice].start();
                    System.out.println("Cronometro iniciado com sucesso.");
                    indice++;
                }
                case 2 -> {
                    indice = 1;
                    int opcaoCronometro = 0;

                    System.out.println("Selecione o cronômetro: ");
                    if (cronometros[0] == null) {
                        System.out.println("Nenhum cronômetro disponível, crie um antes de consultar.");
                        sleep(2000);
                    } else {
                        for (int i = 0; i < cronometros.length; i++) {
                            if (cronometros[i] != null) {
                                System.out.println("Cronômetro " + indice);
                                indice++;
                            } else {
                                break;
                            }
                        }
                        boolean isValorCorreto = false;
                        do {
                            try {


                                System.out.print("Cronômetro escolhido: ");
                                opcaoCronometro = scanner.nextInt();
                                if (opcaoCronometro == 1) {
                                    System.out.println("Contagem atual: " + cronometros[0].getContador() + " segundos");
                                    isValorCorreto = true;
                                } else if (opcaoCronometro == 2) {
                                    System.out.println("Contagem atual: " + cronometros[1].getContador() + " segundos");
                                    isValorCorreto = true;
                                } else if (opcaoCronometro == 3) {
                                    System.out.println("Contagem atual: " + cronometros[2].getContador() + " segundos");
                                    isValorCorreto = true;
                                } else if (opcaoCronometro == 4) {
                                    System.out.println("Contagem atual: " + cronometros[3].getContador() + " segundos");
                                    isValorCorreto = true;
                                } else if (opcaoCronometro == 5) {
                                    System.out.println("Contagem atual: " + cronometros[4].getContador() + " segundos");
                                    isValorCorreto = true;
                                } else if (opcaoCronometro == 6) {
                                    System.out.println("Contagem atual: " + cronometros[5].getContador() + " segundos");
                                    isValorCorreto = true;
                                } else if (opcaoCronometro == 7) {
                                    System.out.println("Contagem atual: " + cronometros[6].getContador() + " segundos");
                                    isValorCorreto = true;
                                } else if (opcaoCronometro == 8) {
                                    System.out.println("Contagem atual: " + cronometros[7].getContador() + " segundos");
                                    isValorCorreto = true;
                                } else if (opcaoCronometro == 9) {
                                    System.out.println("Contagem atual: " + cronometros[8].getContador() + " segundos");
                                    isValorCorreto = true;
                                } else if (opcaoCronometro == 10) {
                                    System.out.println("Contagem atual: " + cronometros[9].getContador());
                                    isValorCorreto = true;
                                }
                            } catch (NullPointerException e) {
                                System.out.println("O cronometro inserido não existe!");
                            }
                        } while (!isValorCorreto);
                    }
                }
                case 3 -> {
                    indice = 1;
                    for (Cronometro cronometro : cronometros) {
                        if (cronometro != null) {
                            System.out.println("Cronômetro " + indice + ": " + cronometro.getContador() + " segundos.");
                            indice++;
                        }
                    }
                }
            }

        } while (opcao != 4);

    }
}

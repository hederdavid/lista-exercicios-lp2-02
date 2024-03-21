package prova.quest05;

import java.util.Random;
public class SomadorAleatorio extends Thread {
    final int MAX = 10;

    private int soma = 0;
    private int intervalo = 0;

    public SomadorAleatorio(int intervalo) {
        this.intervalo = intervalo;
    }

    public int getSomaAtual() {
        return soma;
    }

    public void run() {
        Random gerador = new Random(); // gerador de números pseudoaleatórios

        while (true) {
            try {
                soma += gerador.nextInt(MAX) + 1;
                sleep(intervalo * 1000);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

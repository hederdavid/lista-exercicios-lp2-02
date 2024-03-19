package exercicio07;

import static java.lang.Thread.sleep;

public class RelogioThreadUtil extends Relogio implements Runnable {
    private int horaFinal;
    private int minutoFinal;
    private int segundoFinal;

    public RelogioThreadUtil(int horaFinal, int minutoFinal, int segundoFinal) {
        this.horaFinal = horaFinal;
        this.minutoFinal = minutoFinal;
        this.segundoFinal = segundoFinal;
    }

    @Override
    public void run() {
        double porcentagem = 0;
        double tempoFinalEmSegundos = horaFinal * 24 * 60 + minutoFinal * 60 + segundoFinal;
        double tempoAtualEmSegundos = 0;
        for (int i = 0; tempoAtualEmSegundos <= tempoFinalEmSegundos; i++) {
            porcentagem = tempoAtualEmSegundos * 100;
            tempoAtualEmSegundos++;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            porcentagem /= tempoFinalEmSegundos;
            System.out.println(toString() + " | " + String.format("%.2f", porcentagem) + "%");
            addSegundo();
        }
        System.out.println("Tempo finalizado.");
    }
}

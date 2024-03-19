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

        while (getHora() != this.horaFinal || getMinuto() != this.minutoFinal || getSegundo() != this.segundoFinal) {
            porcentagem = (getHora() * 24 * 60 + getMinuto() * 60 + getSegundo()) * 100;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            porcentagem /= (horaFinal * 24 * 60 + minutoFinal * 60 + segundoFinal);
            System.out.println(toString() + " | " + String.format("%.2f", porcentagem) + "%");
            addSegundo();
        }
        porcentagem = (getHora() * 24 * 60 + getMinuto() * 60 + getSegundo()) * 100;
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        porcentagem /= (horaFinal * 24 * 60 + minutoFinal * 60 + segundoFinal);
        System.out.println(toString() + " | " + String.format("%.2f", porcentagem) + "%");
        System.out.println("Tempo finalizado.");

    }
}

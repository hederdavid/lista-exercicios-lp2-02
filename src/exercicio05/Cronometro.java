package exercicio05;

import static java.lang.Thread.sleep;

public class Cronometro implements Runnable {
    private long inicioContagem;
    private final long MILISEGUNDOS;
    private long contador;

    public Cronometro(long inicioContagem, long milisegundos) {
        this.inicioContagem = inicioContagem;
        MILISEGUNDOS = milisegundos;
        contador = inicioContagem;

    }
    @Override
    public void run() {
        for (long i = inicioContagem; i > 0; i--) {
            try {
                sleep(MILISEGUNDOS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            contador--;
        }
    }

    public long getContador() {
        return contador;
    }

    public String getSituacao() {
        return contador == 0 ? "<encerrado>" : "<em atividade>";
    }
}

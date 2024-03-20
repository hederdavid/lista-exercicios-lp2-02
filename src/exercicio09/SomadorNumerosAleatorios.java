package exercicio09;

import static java.lang.Thread.sleep;

public class SomadorNumerosAleatorios implements Runnable {
    private int quantidadeDeSomas;
    private int resultado;

    public SomadorNumerosAleatorios(int quantidadeDeSomas) {
        this.quantidadeDeSomas = quantidadeDeSomas;
    }

    @Override
    public void run() {
        for (int i = 0; i <= quantidadeDeSomas; i++) {
            int numeroAleatorio = (int) (Math.random() * 100);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resultado += numeroAleatorio;
        }
    }

    public void setQuantidadeDeSomas(int quantidadeDeSomas) {
        this.quantidadeDeSomas = quantidadeDeSomas;
    }

    public int getResultado() {
        return resultado;
    }
}

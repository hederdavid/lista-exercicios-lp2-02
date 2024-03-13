package exercicio02;

public class NumerosPrimos extends Thread {
    private int inicio = 0;
    private final int fim;
    private String resultado = "";
    private long executionTime;

    public NumerosPrimos(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        resultado = "Números primos de " + inicio + " até " + fim + ":";
        for (int i = inicio; i <= fim; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    if (j == i) {
                        resultado += (" " + i);
                    } else {
                        j = fim + 1;
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
    }

    public void getResultado() {
        System.out.println(resultado);
        System.out.println("Tempo de execução: " + executionTime + " millisegundos");
        System.out.println();

    }
}

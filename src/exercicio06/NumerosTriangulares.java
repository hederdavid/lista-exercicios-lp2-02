package exercicio06;

import static java.lang.Thread.sleep;

public class NumerosTriangulares implements Runnable {
    private final long numero;
    private String resultado;
    public long tempoExecucao;

    public NumerosTriangulares(long numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        long inicio = System.currentTimeMillis();
        resultado = "";
        int numeroAnterior = 0;
        for (int i = 1; (numeroAnterior + i) <= numero; i++) {
            if (i != 1) {
                resultado += ((numeroAnterior + i) + " ");
            } else {
                resultado += i + " ";
            }
            numeroAnterior += i;
        }
        long fim = System.currentTimeMillis();
        tempoExecucao = fim - inicio;
    }
    
    public void getResultado() {
        System.out.println("Números triangulares de 1 a " + numero + ": " + resultado);
        System.out.println("Tempo de execução: " + tempoExecucao + " milisegundos");
    }
}

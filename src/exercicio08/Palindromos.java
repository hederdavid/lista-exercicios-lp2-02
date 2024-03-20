package exercicio08;

public class Palindromos extends Thread {
    private int quantidadePalindromos;
    private String resultado = "";
    private long tempoExecucao;

    public Palindromos(int quantidadePalindromos) {
        this.quantidadePalindromos = quantidadePalindromos;
    }

    public void run() {
        long inicio = System.nanoTime();
        int quantidadePalindromosAchados = 0;
        boolean isQuantidadePalindromosCorreta = false;
        String possivelPalindromo = "";
        for (int i = 0; !isQuantidadePalindromosCorreta; i++) {
            String iString = String.valueOf(i);
            for (int j = iString.length() - 1; j >= 0; j--) {
                possivelPalindromo += iString.charAt(j);
            }
            if (i == Integer.parseInt(possivelPalindromo)) {
                resultado += i + " ";
                quantidadePalindromosAchados++;
            }
            if (quantidadePalindromosAchados == quantidadePalindromos) {
                isQuantidadePalindromosCorreta = true;
            }
            possivelPalindromo = "";
        }
        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }

    public void getResultado() {
        System.out.println("Aqui estão " + quantidadePalindromos + " palindromos: " + resultado);
        System.out.println("Tempo de execução: " + tempoExecucao + " nanosegundos.");
    }

    public long getTempoExecucao() {
        return tempoExecucao;
    }
}

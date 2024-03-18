package exercicio04;

public class Contagem implements Runnable {
    private boolean contagemConcluida;

    public Contagem() {
        contagemConcluida = false;
    }

    public void run() {
        int cont = 0;
        while (cont <= 10) {
            cont++;
        }
        contagemConcluida = true;
    }
    public boolean isContagemConcluida() {
        return contagemConcluida;
    }

    public static void main(String[] args) {
        Contagem c = new Contagem();

        Thread thread = new Thread(c);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(c.isContagemConcluida());
        }
    }
}

// Alternativa correta: letra D

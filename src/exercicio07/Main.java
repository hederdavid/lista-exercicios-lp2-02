package exercicio07;

public class Main {
    public static void main(String[] args) {
        RelogioThreadUtil relogio = new RelogioThreadUtil(00, 05, 00);
        Thread thread = new Thread(relogio);
        thread.start();
    }
}

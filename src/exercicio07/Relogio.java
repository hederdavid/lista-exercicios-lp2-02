package exercicio07;

public class Relogio {
    private int hora;
    private int minuto;
    private int segundo;

    public Relogio() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    public Relogio(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    public int getHora() {
        return hora;
    }
    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }
    public void addSegundo() {
        int t = hora * 24 * 60 + minuto * 60 + segundo; // conversão em total de segundos

        t++; // incremento de 1 (um) segundo

        hora = t / (24 * 60);
        minuto = t % (24 * 60) / 60;
        segundo = t % 60;
    }

    public String toString() {
        return (hora < 10 ? "0" : "") + hora + ":" + (minuto < 10 ? "0" : "") + minuto + ":" +
                (segundo < 10 ? "0" : "") + segundo;
    }

}

public class Policial extends Thread {
    private static final int TEMPO_MAXIMO = 10000; // 10 segundos
    private Cofre cofre;
    private boolean hackersPresos;

    public Policial(Cofre cofre) {
        this.cofre = cofre;
        this.hackersPresos = false;
    }

    @Override
    public void run() {
        try {
            for (int tempo = TEMPO_MAXIMO; tempo > 0; tempo -= 1000) {
                System.out.println("Tempo restante: " + tempo / 1000 + " segundos");
                Thread.sleep(1000);
                if (hackersPresos) {
                    return;
                }
            }
            System.out.println("A polícia pegou os hackers e eles estão presos!");
            System.exit(0); // Encerra o programa após o tempo limite
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void prenderHackers() {
        hackersPresos = true;
    }
}

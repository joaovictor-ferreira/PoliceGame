public class PoliceOfficer extends Thread {
    private static final int MAX_TIME = 10000; // 10 segundos
    private DepositorySafe depositorySafe;
    private boolean hackersArrested;

    public PoliceOfficer(DepositorySafe depositorySafe) {
        this.depositorySafe = depositorySafe;
        this.hackersArrested = false;
    }

    @Override
    public void run() {
        try {
            for (int time = MAX_TIME; time > 0; time -= 1000) {
                System.out.println("Tempo restante: " + time / 1000 + " segundos");
                Thread.sleep(1000);
                if (hackersArrested) {
                    return;
                }
            }
            System.out.println("Os policiais os hackers e prenderam-nos!");
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void arrestHackers() {
        hackersArrested = true;
    }
}

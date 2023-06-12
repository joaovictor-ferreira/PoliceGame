import java.util.Random;

class Cofre {
    private int senha;

    public Cofre() {
        Random random = new Random();
        senha = random.nextInt(100000); // Gera um número aleatório entre 0 e 99999
    }

    public synchronized boolean verificarSenha(int tentativa) {
        return tentativa == senha;
    }
}

class Hacker extends Thread {
    private Cofre cofre;
    private boolean senhaEncontrada;

    public Hacker(Cofre cofre) {
        this.cofre = cofre;
        this.senhaEncontrada = false;
    }

    @Override
    public void run() {
        for (int tentativa = 0; tentativa < 100000; tentativa++) {
            if (cofre.verificarSenha(tentativa)) {
                senhaEncontrada = true;
                System.out.println("Hacker " + getId() + " abriu o cofre!");
                break;
            }
        }
    }

    public boolean senhaEncontrada() {
        return senhaEncontrada;
    }
}

class Policial extends Thread {
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

public class Main {
    public static void main(String[] args) {
        Cofre cofre = new Cofre();
        Hacker hacker1 = new Hacker(cofre);
        Hacker hacker2 = new Hacker(cofre);
        Policial policial = new Policial(cofre);

        hacker1.start();
        hacker2.start();
        policial.start();

        try {
            hacker1.join();
            hacker2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (hacker1.senhaEncontrada()) {
            policial.prenderHackers();
        } else if (hacker2.senhaEncontrada()) {
            policial.prenderHackers();
        }
    }
}

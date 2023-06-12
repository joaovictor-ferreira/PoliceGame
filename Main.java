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

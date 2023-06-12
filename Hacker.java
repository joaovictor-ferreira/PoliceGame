public class Hacker extends Thread {
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

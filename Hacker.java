public class Hacker extends Thread {
    private DepositorySafe depositorySafe;
    private boolean passwordFound;

    public Hacker( DepositorySafe depositorySafe) {
        this.depositorySafe = depositorySafe;
        this.passwordFound = false;
    }

    @Override
    public void run() {
        for (int attempt = 0; attempt < 100000; attempt++) {
            if (depositorySafe.checkPassword(attempt)) {
                passwordFound = true;
                System.out.println("O Hacker " + getId() + " conseguiu abrir o cofre!");
                break;
            }
        }
    }

    public boolean isPasswordFound() {
        return passwordFound;
    }
}

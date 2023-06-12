import java.util.Random;

public class Cofre {
    private int senha;

    public Cofre() {
        Random random = new Random();
        senha = random.nextInt(100000); // Gera um número aleatório entre 0 e 99999
    }

    public synchronized boolean verificarSenha(int tentativa) {
        return tentativa == senha;
    }
}

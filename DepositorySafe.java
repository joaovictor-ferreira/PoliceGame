import java.util.Random;

public class DepositorySafe{
    private int password;

    public DepositorySafe() {
        Random random = new Random();
        password = random.nextInt(100000); // Generates a random number in the following range: 0-99999
    }

    public synchronized boolean checkPassword(int attempt) {
        return attempt == password;
    }
}

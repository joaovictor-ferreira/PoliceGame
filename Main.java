public class Main {
    public static void main(String[] args) {
        DepositorySafe depositorySafe = new DepositorySafe();
        Hacker hacker1 = new Hacker(depositorySafe);
        Hacker hacker2 = new Hacker(depositorySafe);
        Hacker hacker3 = new Hacker(depositorySafe);
        Hacker hacker4= new Hacker(depositorySafe);
        PoliceOfficer policeOfficer = new PoliceOfficer(depositorySafe);

        hacker1.start();
        hacker2.start();
        hacker3.start();
        hacker4.start();
        policeOfficer.start();

        try {
            hacker1.join();
            hacker2.join();
            hacker3.join();
            hacker4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (hacker1.isPasswordFound() || hacker2.isPasswordFound() || hacker3.isPasswordFound() || hacker4.isPasswordFound()) {
            policeOfficer.arrestHackers();
        }
    }
}

package Optimization.SimulatedAnnealing;

import java.util.Random;

public class Utility {

    public static double distance(City a, City b) {
        double dX = a.getX() - b.getX(), dY = a.getY() - b.getY();
        return Math.sqrt(dX * dX + dY * dY);
    }

    public static double acceptProbability(double curDistance, double newDistance, double temperature) {
        if (newDistance < curDistance) {
            return 1.0;
        }

        return Math.exp((curDistance - newDistance) / temperature);
    }

    public static double randomDouble() {
        Random rand = new Random();
        return rand.nextDouble();
    }

    public static int randomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }

}

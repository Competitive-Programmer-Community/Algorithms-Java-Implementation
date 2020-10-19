package Optimization;

import java.util.Random;

// use repeated random sampling to get numeric result
// use randomness to solve problems that might be deterministic in principle

// process:
// 1 select a domain for possible inputs
// 2 randomly generate a possible input under domain
// 3 do deterministic computation on the input
// 4 aggregate the results

// guarantee randomness
// the inputs should be large enough

public class MonteCarloMethod {

    public static void main(String[] args) {
        int iteration = 10000000;
        int count_circle = 0;
        int count_square = 0;

        Random rand = new Random();

        while(iteration > count_square) {
            double x = rand.nextDouble();
            double y = rand.nextDouble();
            count_square++;

            if (x * x + y * y <= 1) {
                count_circle++;
            }
        }

        System.out.println("Estimated value of Pi: " + count_circle * 1.0 / count_square * 4);
    }
}

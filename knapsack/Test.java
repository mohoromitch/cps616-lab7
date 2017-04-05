package knapsack;

import java.util.Scanner;

/**
  * Test program for the problem problem.
  * @author Sophie Quigley
  * @author Mitchell Mohorovich
  * 
  */
public class Test {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Problem problem;

        for (int run = 1; run <= 3; run++) {
			System.out.printf("Starting run %d...\n", run);
			for (int i = 10; i <= 200; i += 10) {
				problem = new Problem(i, i);
				process(problem);
			}
			System.out.printf("...done run %d\n\n", run);
		}

    }

    /**
     * Processes a knapsack Problem: prints it, solves it, and prints the solution
     * <br>DO NOT MODIFY
     * @param problem Knapsack Problem
     */
    private static void process(Problem problem) {
        Solution solution;
        long time = System.nanoTime();
        solution = problem.solve();
        time = System.nanoTime() - time;
        System.out.printf("%d\n", time);
    }

}

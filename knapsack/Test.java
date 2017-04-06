package knapsack;

/**
  * Test program for the problem problem.
  * @author Sophie Quigley
  * @author Mitchell Mohorovich
  * 
  */
public class Test {

	/**
	 * What to start the capacity limit at
	 */
	private static final int CAP_START = 10;

	/**
	 * The max capacity to test
	 */
	private static final int CAP_LIMIT = 110;

	/**
	 * What to increment the cap loop with
	 */
	private static final int CAP_INCREMENT = 10;

	/**
	 * How many runs to complete
	 */
	private static final int RUN_NUMBER = 3;

    /**
     * 
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		Problem problem;
		Problem2 problem2;
		Problem3 problem3;

		for (int i = CAP_START; i <= CAP_LIMIT; i += CAP_INCREMENT) {
			problem = new Problem(i, i);
			process(problem);
		}

		for (int i = CAP_START; i <= CAP_LIMIT; i += CAP_INCREMENT) {
			problem2 = new Problem2(i, i);
			process2(problem2);
		}

		for (int i = CAP_START; i <= CAP_LIMIT; i += CAP_INCREMENT) {
			problem3 = new Problem3(i, i);
			process3(problem3);
		}

	}

	/**
	 * Processes a knapsack Problem: prints it, solves it, and prints the solution
	 * <br>DO NOT MODIFY
	 * @param problem Knapsack Problem
	 */
	private static void process(Problem problem) {
		long aveTime = 0;

		for(int i = 0; i < RUN_NUMBER; i++) {
			Solution solution;
			long time = System.nanoTime();
			solution = problem.solve();
			time = System.nanoTime() - time;
			System.out.printf("sol: 1, cap: %5d, val: %5d, time: %10d\n", solution.totalCapacity, solution.getWorth(), time);
			aveTime += time;
		}
		aveTime = aveTime/3;
		System.out.printf("Average time: %d\n\n", aveTime);

	}

	private static void process2(Problem2 problem) {
		long aveTime = 0;

		for(int i = 0; i < RUN_NUMBER; i++) {
			Solution2 solution;
			long time = System.nanoTime();
			solution = problem.solve();
			time = System.nanoTime() - time;
			aveTime += time;
			System.out.printf("sol: 2, cap: %5d, val: %5d, time: %10d\n", solution.totalCapacity, solution.getWorth(), time);
		}
		aveTime = aveTime/3;
		System.out.printf("Average time: %d\n\n", aveTime);

	}

	private static void process3(Problem3 problem) {
		long aveTime = 0;

		for(int i = 0; i < RUN_NUMBER; i++) {
			Solution3 solution;
			long time = System.nanoTime();
			solution = problem.solve();
			time = System.nanoTime() - time;
			System.out.printf("sol: 3, cap: %5d, val: %5d, time: %10d\n", solution.totalCapacity, solution.getWorth(), time);
			aveTime += time;
		}
		aveTime = aveTime/3;
		System.out.printf("Average time: %d\n\n", aveTime);

	}

}

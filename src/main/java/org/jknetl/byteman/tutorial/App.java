/**
 *
 */
package org.jknetl.byteman.tutorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Simple Main application for playing with JBoss Byteman. The main application does the following:
 *
 * 1. Create counter objects which has set a maximum value it can reach (the maximum value is taken from the first argument).
 * 2. Creates N threads which compete for increasing counter (where N is specified by the second argument)
 *
 * @author jknetl
 *
 */
public class App {

	private int counterMax;
	private int numOfThreads;

	public App(int counterMax, int numOfThreads) {
		super();
		this.counterMax = counterMax;
		this.numOfThreads = numOfThreads;
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("You are required to provide two arguments."
					+ " First argument sets a maximum counter value, the second one is number of the threads.");
			System.exit(1);
		}

		final App main = new App(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
		main.startIncrementing();
	}

	/**
	 * Creates a counter and launches threads which will increment the counter.
	 */
	public void startIncrementing() {
		final Counter counter = new Counter(counterMax);

		final ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);

		for (int i = 0; i < numOfThreads; i++) {
			executor.execute(new IncrementWorker(counter));
		}

		// shutdown the executor
		executor.shutdown();
		// wait at most one minute until threads finishes
		try {
			executor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Counting finished.");
	}

}

/**
 *
 */
package org.jknetl.byteman.tutorial;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Increment worker tries to repeatedly increment the counter untill it reaches its maximum value.
 *
 * @author jknetl
 *
 */
public class IncrementWorker implements Runnable {

	private static final int RANDOM_SLEEP_BOUND = 10;
	private Counter counter;

	public IncrementWorker(Counter counter) {
		super();
		this.counter = counter;
	}

	public void run() {
		try {
		while (!counter.maxValueReached()) {
			counter.increment();
			randomSleep();
		}
		} catch (final Throwable t) {
			System.out.println("Thread " + Thread.currentThread().getName()
					+ " failed! Exception: " + t.getClass().getName());
			throw new RuntimeException(t);
		}
	}

	/**
	 * Introduces sleep with random timeout so that interleaving of the threads is more random at
	 * different runs.
	 */
	private void randomSleep() {
		final Random random = new Random();
		final int timeout = random.nextInt(RANDOM_SLEEP_BOUND);
		try {
			if (timeout < RANDOM_SLEEP_BOUND / 2) {
				TimeUnit.MILLISECONDS.sleep(timeout);
			}
		} catch (final InterruptedException e) {
			//do nothing
		}
	}
}

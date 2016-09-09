package org.jknetl.byteman.tutorial;

/**
 * Counter class for the playing with JBoss Byteman. The counter just represents simple counter which can be incremented in the thread safe way.
 * But the value of the counter may not be higher than its maximum value.
 *
 * @author jknetl
 *
 */
public class Counter {

	//counter internal state
	private int i;

	// maximum value of the counter
	private int maxValue;

	public Counter(int maxValue) {
		super();
		if (maxValue <= 0) {
			throw new IllegalArgumentException("Max value must be a positive value");
		}
		i = 0;
		this.maxValue = maxValue;
	}

	/**
	 * Increments counter. If the counter has already reached the maximum value then this call does nothing!
	 */
	public synchronized void increment() {
		if (i < maxValue) {
			incrementByOne();
		}
	}

	/**
	 *
	 * @return current value of the counter.
	 */
	public synchronized int getValue() {
		return i;
	}

	public synchronized boolean maxValueReached() {
		return i == maxValue;
	}

	private void incrementByOne() {
		i++;
	}

}

package org.jknetl.byteman.tutorial.test;

import org.jboss.byteman.contrib.bmunit.BMScript;
import org.jboss.byteman.contrib.bmunit.BMUnitConfig;
import org.jboss.byteman.contrib.bmunit.BMUnitRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.jknetl.byteman.tutorial.App;

@RunWith(BMUnitRunner.class)
// maven surefire moves compiled test classes and test resources to target/test-classes
@BMUnitConfig(loadDirectory = "target/test-classes", debug = true)
@BMScript("output.btm")
public class TasksTest {

	/**
	 * This is not the test in fact. I used the test to solve this tasks because it is more simple
	 * then to run the rule using BMUnit than manually using the java command! But the test result is
	 * irrelevant (in fact it should always succeed, even if the rule is wrong).
	 *
	 *
	 * @throws InterruptedException
	 */
	@Test
	@BMScript("thread-fail.btm")
	public void threadFailTest() throws InterruptedException {
		final App app = new App(30, 2);
		app.startIncrementing();
	}


	/**
	 * This is not the test in fact. I used the test to solve this tasks because it is more simple
	 * then to run the rule using BMUnit than manually using the java command! But the test result is
	 * irrelevant (in fact it should always succeed, even if the rule is wrong).
	 */
	@Test
	@BMScript("increment-twice.btm")
	public void incrementTwiceTest() {
		final App app = new App(30, 2);
		app.startIncrementing();
	}

	/**
	 * This is not the test in fact. I used the test to solve this tasks because it is more simple
	 * then to run the rule using BMUnit than manually using the java command! But the test result is
	 * irrelevant (in fact it should always succeed, even if the rule is wrong).
	 *
	 *
	 * @throws InterruptedException
	 */
	@Test
	@BMScript("synchronization.btm")
	public void synchronizeTest() {
		final App app = new App(18, 3);
		app.startIncrementing();
	}
}

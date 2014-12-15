package org.tdd.concurrency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.junit.Ignore;
import org.junit.Test;

public class CounterTest {

	@Test
	public void testBasicIncrement() {
		final Counter counter = new Counter();
		assertThat(0, is(counter.getValue()));
		counter.increment();
		assertThat(1, is(counter.getValue()));
		counter.increment();
		assertThat(2, is(counter.getValue()));
	}

	/**
	 * <b>That is a bad test for MultipleThread testing</b>: <li>It does not
	 * guarantee, that all threads run parallel</li> <li>thread sleep does not
	 * guarantee, that all threads go to the end</li> <li>thread sleep slows
	 * down the test</li>
	 * 
	 * @throws InterruptedException
	 */
	@Test
	@Ignore
	public void testForThreadSafety() throws InterruptedException {
		final Counter counter = new Counter();
		final int numberOfThreads = 50;
		final int incrementPerThread = 100;
		Runnable run = new Runnable() {

			public void run() {
				for (int i = 0; i < incrementPerThread; i++) {
					counter.increment();
				}
			}
		};
		for (int i = 0; i < numberOfThreads; i++) {
			new Thread(run).start();
		}
		Thread.sleep(3000);
		assertThat(counter.getValue(), equalTo(numberOfThreads
				* incrementPerThread));
	}

	/**
	 * this test fails more reliably. but it can not 100% guarantee that it
	 * always fails for a wrong implementation
	 * 
	 * @throws InterruptedException
	 * @throws BrokenBarrierException
	 */
	@Test
	public void testForThreadSafetyUsingCyclicBarrier()
			throws InterruptedException, BrokenBarrierException {
		final Counter counter = new Counter();
		final int numberOfThreads = 50;
		final int incrementPerThread = 1000;
		// create cyclicbarrier for all new thread plus this one
		CyclicBarrier entryBarrier = new CyclicBarrier(numberOfThreads + 1);
		CyclicBarrier exitBarrier = new CyclicBarrier(numberOfThreads + 1);
		Runnable run = new Runnable() {

			public void run() {
				for (int i = 0; i < incrementPerThread; i++) {
					counter.increment();
				}
			}
		};

		for (int i = 0; i < numberOfThreads; i++) {
			new SyncedThread(run, entryBarrier, exitBarrier).start();
		}
		assertThat("All threads are not started", counter.getValue(),
				equalTo(0));
		entryBarrier.await();
		exitBarrier.await();
		assertThat(counter.getValue(), equalTo(numberOfThreads
				* incrementPerThread));
	}
	
}

package org.tdd.concurrency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

public class ThreadsafeCounterTest {

	@Test
	public void testGetValue() throws Exception {
		final ThreadsafeCounter counter = new ThreadsafeCounter();
		final int numberOfThreads = 50;
		final int incrementPerThread = 100000;
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

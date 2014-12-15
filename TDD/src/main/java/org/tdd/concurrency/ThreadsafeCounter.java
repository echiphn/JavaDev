package org.tdd.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * using atomic long to implement thread safe counter
 * here is another solution for the issue of Counter class
 * @author cle
 *
 */
public class ThreadsafeCounter {
	private AtomicInteger counter=new AtomicInteger(0);
	public void increment() {
		counter.incrementAndGet();
	}

	public int getValue() {
		return counter.intValue();
	}
}

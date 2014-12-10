package org.tdd.concurrency;

public class Counter {
	private int counter;

	public synchronized void increment() {
		counter++;
	}

	public int getValue() {
		return counter;
	}

}

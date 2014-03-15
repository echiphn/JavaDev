package org.tdd.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SyncedThread extends Thread {
	private CyclicBarrier entryBarrier;
	private CyclicBarrier exitBarrier;

	public SyncedThread(Runnable run, CyclicBarrier entryBarrier,
			CyclicBarrier exitBarrier) {
		super(run);
		this.entryBarrier = entryBarrier;
		this.exitBarrier = exitBarrier;
	}

	@Override
	public void run() {
		try {
			entryBarrier.await();
			super.run();
			exitBarrier.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}

}

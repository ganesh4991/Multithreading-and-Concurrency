package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SyncThread extends Thread {

	static int globalVariable = 0;
	private final Object lock = new Object();

	List<Integer> list;
	CountDownLatch time;

	public SyncThread(CountDownLatch latch) {
		list = new ArrayList<Integer>();
		time = latch;
	}

	public void run() {
		try {
			time.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			if (globalVariable < 100)
				increment();
			else
				return;
		}
	}

	public synchronized void increment() {
		synchronized (lock) {
			globalVariable += 1;
			System.out.println(globalVariable);
			list.add(globalVariable);	
		}
	}

}

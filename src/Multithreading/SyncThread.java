package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SyncThread extends Thread {

	static int globalVariable = 0;
	private static final Object countLock = new Object();
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
			synchronized (countLock) {

				if (globalVariable < 100) {
					globalVariable += 1;
					list.add(globalVariable);
				}
			}

		}
	}

}

package Multithreading;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String args[]) throws IOException {

		//Using CountDownLatch to start all code at same time
		CountDownLatch latch = new CountDownLatch(1);

		SyncThread t1 = new SyncThread(latch);
		SyncThread t2 = new SyncThread(latch);
		SyncThread t3 = new SyncThread(latch);

		t1.start();
		t2.start();
		t3.start();

		latch.countDown();

		//Using join to ensure thread lists are displayed after all threads have stopped running
		try {
			t1.join();
			t2.join();
			t3.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Displaying number modified by each thread
		
		System.out.println("Thead 1 List: " + t1.list);
		System.out.println("Thead 2 List: " + t2.list);
		System.out.println("Thead 3 List: " + t3.list);
		
	}
}

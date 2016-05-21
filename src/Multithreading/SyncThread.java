package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SyncThread extends Thread {

	static int globalVariable = 0;

	List<Integer> list; // List to store numbers modified by this thread
	CountDownLatch time;

	public SyncThread(CountDownLatch latch) {
		list = new ArrayList<Integer>();
		time = latch;
	}

	public void run() {
		try {
			time.await(); // waiting for run command from CountDownLatch
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
				int temp=increment(); 
				if(temp!=-1)
					list.add(temp);
				else
					return;
			
		}
	}

	// Synchronized function to increment the global counter and return the new value to be added to the list
	
	public static synchronized int increment() {
		if (globalVariable < 100){
			globalVariable += 1;
			System.out.println(globalVariable);
			return globalVariable;
		}
		else
			return -1; // -1 to stop the execution of run() and return command to main
	}

}

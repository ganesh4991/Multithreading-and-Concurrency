package Multithreading;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String args[]) throws IOException{
		
		CountDownLatch latch = new CountDownLatch(1);
		
		SyncThread t1=new SyncThread(latch);
		SyncThread t2=new SyncThread(latch);
		SyncThread t3=new SyncThread(latch);
		
		t1.start();
		t2.start();
		t3.start();
		
		latch.countDown();
	}
}

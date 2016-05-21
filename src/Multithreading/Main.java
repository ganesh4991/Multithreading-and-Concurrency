package Multithreading;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String args[]) throws IOException{
		IncrementCounter c=new IncrementCounter();
		
		CountDownLatch latch = new CountDownLatch(1);
		
		SyncThread t1=new SyncThread(c,latch);
		SyncThread t2=new SyncThread(c,latch);
		SyncThread t3=new SyncThread(c,latch);
		
		t1.start();
		t2.start();
		t3.start();
		
		latch.countDown();
	}
}

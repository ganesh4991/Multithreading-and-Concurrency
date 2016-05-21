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
		
		System.out.println("Thead 1 List: "+t1.list+t1.list.size());
		System.out.println("Thead 2 List: "+t2.list+t2.list.size());
		System.out.println("Thead 3 List: "+t3.list+t3.list.size());
	}
}

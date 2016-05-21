package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SyncThread extends Thread{
	static int globalVariable=0;
	List <Integer> list;
	CountDownLatch time;
	IncrementCounter i;
	
	public SyncThread(IncrementCounter a,CountDownLatch latch) {
		list=new ArrayList<Integer>();	
		i=a;
		time=latch;
	}
	
	public void run(){
		
		try {
			time.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
		if(globalVariable<100){
		globalVariable=i.counter(globalVariable);
		list.add(globalVariable);
		}
		}
	}

}

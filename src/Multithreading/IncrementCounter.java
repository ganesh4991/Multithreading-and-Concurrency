package Multithreading;

public class IncrementCounter {	   
	    public synchronized int counter(int value){
	      value += 1;
	      System.out.println(value);
	      return value;
	    }
}